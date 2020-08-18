package com.dream.common.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dream.common.utils.TUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    /**
     * 空视图容器
     */
    private FrameLayout mEmptyViewContainer;
    /**
     * 空界面或错误界面图片
     */
    private ImageView mEmptyErrorImage;
    /**
     * 空界面或错误界面描述信息
     */
    private TextView mEmptyErrorDescText;
    /**
     * 空界面或者错误界面视图容器
     */
    private FrameLayout mEmptyErrorViewContainer;
    /**
     * 列表请求无网络码制，显示错误空界面视图时使用
     */
    public static final int CODE_LIST_NO_NETWORK = 1;
    /**
     * 空数据
     */
    public static final int CODE_EMPTY_LIST_DATA = 2;
    /**
     * 刷新接口请求失败
     */
    private static final int CODE_REFRESH_FAILED = 3;
    private BaseActivity mActivity;
    private View mRootView;
    private T mPresenter;
    private Unbinder mBinder;
    private View mEmptyView;
    private boolean isUIVisible = false;
    private boolean isCreateView = false;
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        mBinder = ButterKnife.bind(this, mRootView);
        this.mActivity = (BaseActivity) getActivity();
        mPresenter = TUtil.getT(this, 0);
        if (mPresenter != null) {
            mPresenter.setActivity(mActivity);
            mPresenter.setFragment(this);
        }
        return mRootView;
    }

    public View getRootView() {
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
        initView();
        isCreateView = true;
//        beforlazyLoad();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinder.unbind();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }

    /**
     * 设置布局资源id
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
     */
    protected abstract void initPresenter();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 懒加载方法 子类具体实现要做什么
     */
//    protected abstract void lazyLoad();

//    /**
//     * 懒加载方法调用前的判断
//     */
//    private void beforlazyLoad() {
//        if (isCreateView && isUIVisible) {
//            lazyLoad();
//        }
//    }


}
