package com.dream.common.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ClickUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dream.common.R;
import com.dream.common.baserx.RxManager;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorCode;
import com.dream.common.utils.TUtil;
import com.dream.common.widget.SuperToast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author : Liyalei
 * date   : 2020/8/15
 * desc   :activity基类
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
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
    public static final int CODE_REFRESH_FAILED = 3;
    public T mPresenter;
    public Activity mActivity;
    public RxManager mRxManager;
    private View mEmptyView;
    private FrameLayout mContentContainer;
    private boolean isFullScreen = false;

    /**
     * 点击两次返回按键退出程序标志位，默认false不退出程序，而是回退
     */
    private boolean isDoubleClickExit = false;
    /**
     * 空界面或者错误界面视图容器
     */
    private FrameLayout mEmptyErrorViewContainer;
    /**
     * 空界面或错误界面图片
     */
    private ImageView mEmptyErrorImage;
    /**
     * 空界面或错误界面描述信息
     */
    private TextView mEmptyErrorDescText;
    private Unbinder bind;
    private FrameLayout mToolbarContainer;
    /**
     * 上次点击退出的时间
     */
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mRxManager = new RxManager();
        initBeforeSetContentView();
        setContentView(getRootView());
        bind = ButterKnife.bind(this);
        mPresenter = TUtil.getT(this, 0);
        if (mPresenter != null) {
            mPresenter.setActivity(this);
            mPresenter.setFragment(null);
        }
        initPresenter();
        initView(savedInstanceState);

    }

    private View getRootView() {
        LinearLayout mRootView = new LinearLayout(this);
        mRootView.setOrientation(LinearLayout.VERTICAL);
        mRootView.setFitsSystemWindows(false);
        FrameLayout.LayoutParams mContentViewContainerParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mRootView.setLayoutParams(mContentViewContainerParams);
        initToolbarContainer();
        initContentContainer();
        MyToolbar myToolbar = getMyToolbar();
        Toolbar mToolbar = null;
        if (myToolbar != null) {
            mToolbar = myToolbar.getToolbar();
        }
        if (myToolbar == null || mToolbar == null) {
            //不设置IToolbar，或不设置view，视为不使用toolbar
        } else { //添加设置的toolbar的view
            mRootView.addView(mToolbarContainer);
            //交换背景色，基于微弱性能考虑
            mToolbarContainer.setBackground(mToolbar.getBackground());
            mToolbar.setBackground(null);
            mToolbarContainer.addView(mToolbar);
            //手动添加顶部margin
            if (isFullScreen) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mToolbar.getLayoutParams();
                int statusBarHeight = SPUtils.getInstance().getInt("StatusBarHeight");
                //有时状态栏获取不成功，此处如果状态栏像素小于10，认为没有获取到状态栏，给一个默认的状态栏高度
                statusBarHeight = statusBarHeight < 10 ? 46 : statusBarHeight;
                params.topMargin = statusBarHeight;
                mToolbar.setLayoutParams(params);
            }
        }
        getLayoutInflater().inflate(getLayoutId(), mContentContainer);
        mRootView.addView(mContentContainer);
        return mRootView;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    /**
     * 设置布局资源id
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
     *
     * @return
     */
    public abstract void initPresenter();

    /**
     * @return true 深色 false 浅色
     */
    public boolean getLightMode() {
        return true;
    }

    /**
     * 对Toolbar进行配置
     *
     * @return
     */
    protected abstract MyToolbar getMyToolbar();

    /**
     * 初始化view
     *
     * @param savedInstanceState
     * @return
     */
    protected abstract void initView(@Nullable Bundle savedInstanceState);


    private void initBeforeSetContentView() {
        setTranslucentStatusBar();
        //状态栏字体浅色
        BarUtils.setStatusBarLightMode(this, getLightMode());
        ScreenUtils.setPortrait(this);
    }

    /**
     * 获取Toolbar的容器
     *
     * @return
     * @Desc： SDK中的Toolbar对沉浸式状态栏支持不太好，软键盘弹出，在沉浸式状态下，toolbar高度会拉伸，此处给
     * toolbar设置外层容器，外层容器支持沉浸式，toolbar不会拉伸，当然外层容器的背景色作为了toolbar的背景色
     */
    private void initToolbarContainer() {
        mToolbarContainer = new FrameLayout(this);
        LinearLayout.LayoutParams mLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mToolbarContainer.setLayoutParams(mLayoutParams);
        mToolbarContainer.setFitsSystemWindows(false);
    }

    /**
     * 设置沉浸式状态栏
     */
    protected void setTranslucentStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

            isFullScreen = true;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);

            isFullScreen = true;
        } else {
            isFullScreen = false;
        }
    }


    /**
     * 显示404、网络加载失败、空视图
     *
     * @param errorCode {@link ErrorCode}中的错误码
     */
    public void showEmptyView(int errorCode, String message) {
        if (mEmptyView != null) {
            mContentContainer.removeView(mEmptyView);
        }
        mEmptyView = View.inflate(this, R.layout.common_view_empty_error, null);
        mEmptyErrorImage = mEmptyView.findViewById(R.id.view_empty_error_image);
        mEmptyErrorDescText = mEmptyView.findViewById(R.id.view_empty_error_tip);
        mContentContainer.addView(mEmptyView);
        mEmptyErrorDescText.setText(message);
        ClickUtils.applySingleDebouncing(mEmptyView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEmptyErrorViewRefreshButton();
            }
        });

        switch (errorCode) {
            case CODE_EMPTY_LIST_DATA:
                mEmptyErrorImage.setImageResource(R.drawable.empty_error_view_no_integral);
                mEmptyErrorDescText.setText("暂无记录");
                break;
            case CODE_LIST_NO_NETWORK:
            case CODE_REFRESH_FAILED:
                if (errorCode == CODE_LIST_NO_NETWORK) {
                    mEmptyErrorImage.setImageResource(R.drawable.empty_error_view_no_network);
                    mEmptyErrorDescText.setText("网络连接已断开，请点击重试");
                } else if (errorCode == CODE_REFRESH_FAILED) {
                    mEmptyErrorImage.setImageResource(R.drawable.empty_error_view_no_transaction);
                    mEmptyErrorDescText.setText("数据获取失败，请点击重试");
                }
                break;

            //接口请求错误，错误码404
            case ErrorCode.CODE_NOT_FOUND:
                break;
            case ErrorCode.CODE_INTERNAL_SERVER_ERROR:
                mEmptyErrorImage.setImageResource(R.drawable.empty_error_view_server_under_maintance);
                break;
            default:
                break;
        }
    }


    /**
     * 点击空界面或错误界面的刷新按键会调用该方法，子类实现该方法进行接口重新请求
     */
    protected void clickEmptyErrorViewRefreshButton() {

    }

    /**
     * 设置空界面视图或者错误界面视图的容器
     *
     * @param container
     */
    protected void setEmptyErrorViewContainer(FrameLayout container) {
        this.mEmptyErrorViewContainer = container;
    }

    /**
     * 设置是否点击两次返回按键退出程序
     *
     * @param exit true：退出  false：界面退到上一个界面
     */
    protected void setDoubleClickExit(boolean exit) {
        this.isDoubleClickExit = exit;
    }

    /**
     * 初始化内容视图容器
     */
    private void initContentContainer() {
        mContentContainer = new FrameLayout(this);
        LinearLayout.LayoutParams mContentContainerParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContentContainer.setLayoutParams(mContentContainerParams);
    }

    @Override
    public void onBackPressed() {


        if (!isDoubleClickExit) {
            //说明可以回退,直接调用super，系统finish掉Activity，在onPause方法中从AppMananger中移除
            //exitAnim();
            super.onBackPressed();
        } else {
            long time = System.currentTimeMillis();
            if (time - mLastClickTime < 2000) {
                ActivityUtils.finishAllActivities();
            } else {
                mLastClickTime = time;
                SuperToast.showShortMessage("再按一次退出保洁端");
            }

        }
    }

}
