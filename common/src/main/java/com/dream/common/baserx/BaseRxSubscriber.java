package com.dream.common.baserx;


import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.dream.common.R;
import com.dream.common.base.BaseActivity;
import com.dream.common.base.BaseBean;
import com.dream.common.base.BaseFragment;
import com.dream.common.http.HttpCustomDialog;
import com.dream.common.http.config.RequestConfig;
import com.dream.common.http.error.ApiException;
import com.dream.common.http.error.ErrorCode;
import com.dream.common.http.error.ErrorType;
import com.dream.common.http.error.ExceptionConverter;
import com.dream.common.widget.SuperToast;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * des:订阅封装
 *
 * @author Liyalei
 */

public abstract class BaseRxSubscriber<R, T extends BaseBean<R>> implements Observer<R> {

    /**
     * Http 返回码401监听，返回401需要退出登录
     */
    private static GlobalErrorListener mGlobalErrorListener;
    /**
     * 用于在dialog之上显示loadingvie
     */
    private HttpCustomDialog mCustomDialog;
    /**
     * onNext方法的data，成功回调
     */
    private R mOnNextData;
    /**
     * 服务器错误码的data，向_onError()方法传递
     */
    private R mErrorData;
    /**
     * JavaBean的Message字段的信息
     */
    private String mTMessage;
    /**
     * JavaBean的Status字段的信息
     */
    private boolean mStatus;
    /**
     * JavaBean的Status字段的信息
     */
    private int mCode;
    private RequestConfig<R, T> mRequestConfig;
    private Disposable mDisposable;
    private BaseActivity mActivity;
    private BaseFragment mFragment;

    public void setRequestConfig(RequestConfig<R, T> requestConfig) {
        this.mRequestConfig = requestConfig;
        mActivity = requestConfig.getPresenter().getActivity();
        mFragment = requestConfig.getPresenter().getFragment();
        mCustomDialog = requestConfig.getTargetDialog();
        if (mCustomDialog == null) {
            mCustomDialog = new HttpCustomDialog(mActivity, "加载中...");
        }
    }

    /**
     * 进行订阅请求网络
     *
     * @param observable
     */
    public void doSubscribe(Observable<T> observable) {
        observable.
                flatMap(new Function<T, ObservableSource<R>>() {
                    @Override
                    public ObservableSource<R> apply(T t) throws Exception {
                        mTMessage = t.getMessage();
                        mErrorData = t.getData();
                        mStatus = t.isSuccess();
                        mCode = t.getCode();
                        if (mStatus) {
                            return Observable.just(t.getData());
                        } else {
                            Throwable mThrowable = new Throwable("接口返回了错误业务码-----" + t.getCode());
                            throw new ApiException(t.getCode(), ErrorType.ERROR_API, mTMessage, mThrowable);
                        }
                    }
                }).
                subscribeOn(Schedulers.io()).
                unsubscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                onErrorResumeNext(new Function<Throwable, ObservableSource<? extends R>>() {
                    @Override
                    public ObservableSource<? extends R> apply(Throwable throwable) throws Exception {
                        return Observable.error(ExceptionConverter.convertException(throwable));
                    }
                }).
                subscribe(this);
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        if (mRequestConfig != null && !StringUtils.isTrimEmpty(mRequestConfig.getTag())) {
            LogUtils.d(mRequestConfig.getTag(), "-----onSubscribe()");
        }

        mDisposable = d;
        showLoadingViewIfNecessary();
    }

    @Override
    public void onNext(R r) {

        if (mRequestConfig != null && !StringUtils.isTrimEmpty(mRequestConfig.getTag())) {
            LogUtils.d(mRequestConfig.getTag(), "-----onNext()");
        }

        mOnNextData = r;
    }

    @Override
    public void onError(Throwable e) {

        LogUtils.e("--onError");
        if (mRequestConfig != null && !StringUtils.isTrimEmpty(mRequestConfig.getTag())) {
            LogUtils.d(mRequestConfig.getTag(), "-----onError()");
        }

        e.printStackTrace();

        dismissLoadingViewIfNecessary(true);

        doDispose();

        if (e instanceof ApiException) {
            ApiException exception = (ApiException) e;
            if (mStatus) {
                if (mCode == 5101) {
                    //token过期
                    mGlobalErrorListener.onReturn10007Code(this, mTMessage);
                } else if (mCode == 200) {
                    //业务成功 但 data为null的情况 需回调界面作判空处理
                    SuperToast.showShortMessage(mTMessage);
                    onSuccess(mErrorData, mTMessage);
//                }
//                else if (mStatus.equals(ErrorCode.SERVER_STATUS_FAILURE)) {
//                    //业务 失败
//                    SuperToast.showShortMessage(mTMessage);
//                    onError(exception.getErrorType(), exception.getCode(), mTMessage, mErrorData);
//                } else if (mStatus.equals(ErrorCode.SERVER_STATUS_SYSTEM_EXCEPTION)) {
//                    //服务器异常 直接吐司即可 保留回调
//                    SuperToast.showShortMessage(mTMessage);
//                    onError(exception.getErrorType(), exception.getCode(), mTMessage, mErrorData);
                } else {
                    //向错误回调传递data字段数据
                    String message = "考夫子迷路了";
                    if (!StringUtils.isEmpty(mTMessage)) {
                        message = mTMessage;
                    } else if ((!StringUtils.isEmpty(message))) {
                        message = exception.getMessage();
                    }
                    onError(exception.getErrorType(), exception.getCode(), message, mErrorData);
                }
            } else {
                if (StringUtils.isEmpty(mTMessage)) {
                    mTMessage = exception.getMessage();
                }
                onError(exception.getErrorType(), exception.getCode(), mTMessage, mErrorData);
            }

        } else {
            if (StringUtils.isEmpty(mTMessage)) {
                mTMessage = "未知错误";
            }
            //防止因网络等原因数据回调回去时activity已销毁做的处理，待实验
            if (mActivity != null && !mActivity.isDestroyed()) {
                onError(ErrorType.ERROR_UNKNOWN, ErrorCode.CODE_UNKNOWN, mTMessage, null);
            }
        }

    }

    @Override
    public void onComplete() {

        if (mRequestConfig != null && !StringUtils.isTrimEmpty(mRequestConfig.getTag())) {
            LogUtils.d(mRequestConfig.getTag(), "-----onComplete()");
        }

        doDispose();

        dismissLoadingViewIfNecessary(false);

        onSuccess(mOnNextData, mTMessage);

    }

    /**
     * 解除订阅关系
     */
    private void doDispose() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }


    /**
     * 显示加载进度指示符
     */
    private void showLoadingViewIfNecessary() {
        if (mRequestConfig != null && mRequestConfig.isShowLoading()) {
            switch (mRequestConfig.getRequestMode()) {
                case SINGLE:
                    //单网络请求显示加载进度View
                    operateLoadingViewVisibility(true);
                    break;

                case CHAIN:

                    switch (mRequestConfig.getChainPosition()) {
                        case CHAIN_START:
                            operateLoadingViewVisibility(true);
                            //链式请求的起始请求显示加载进度
                            break;

                        case CHAIN_MIDDLE:
                            //链式请求的中间请求不进行加载进度显示操作
                            break;

                        case CHAIN_END:
                            //链式请求的结束请求不进行加载进度显示操作
                            break;

                        default:
                            break;
                    }
                default:
            }
        }
    }


    private void dismissLoadingViewIfNecessary(boolean isError) {
        if (mRequestConfig != null && mRequestConfig.isShowLoading()) {
            switch (mRequestConfig.getRequestMode()) {
                case SINGLE:
                    operateLoadingViewVisibility(false);
                    break;

                case CHAIN:
                    switch (mRequestConfig.getChainPosition()) {
                        case CHAIN_START:
                        case CHAIN_MIDDLE:
                            //链式调用发生错误直接隐藏加载进度指示符
                            if (isError) {
                                operateLoadingViewVisibility(false);
                            }
                            break;

                        case CHAIN_END:
                            //链式调用最后请求必须隐藏加载进度指示符
                            operateLoadingViewVisibility(false);

                            break;
                        default:

                    }
                default:
            }
        }
    }

    /**
     * 操作加载进度View的显示和隐藏
     *
     * @param isShow true:显示   false：隐藏
     */
    private void operateLoadingViewVisibility(boolean isShow) {
        if (isShow) {
            if (mCustomDialog != null) {
                mCustomDialog.showLoading();
            }
        } else {

            if (mCustomDialog != null) {
                mCustomDialog.cancelLoading();
            }
        }

    }

    /**
     * 10007返回码监听listener,需要在Application的onCreate()方法中注册
     */
    public interface GlobalErrorListener {

        /**
         * @param baseRxSubscriber
         * @param message
         */
        void onReturn10007Code(BaseRxSubscriber baseRxSubscriber, String message);
    }

    /**
     * 注册重新登录监听
     *
     * @param listener
     */
    public static void registerGlobalErrorListener(GlobalErrorListener listener) {
        mGlobalErrorListener = listener;
    }

    public BaseActivity getActivity() {
        return mActivity;
    }


    public void setmActivity(BaseActivity mActivity) {
        this.mActivity = mActivity;
    }

    public BaseFragment getFragment() {
        return mFragment;
    }

    public Disposable getDisposable() {
        return mDisposable;
    }

    /**
     * 成功的回调
     *
     * @param r              泛型 接口返回的数据
     * @param successMessage 提示
     */
    protected abstract void onSuccess(R r, String successMessage);


    /**
     * 失败回调
     *
     * @param errorType 错误类型
     * @param errorCode 错误code
     * @param message   提示msd
     * @param data      数据
     */
    protected abstract void onError(ErrorType errorType, int errorCode, String message, R data);

}
