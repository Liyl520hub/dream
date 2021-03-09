package com.dream.common.base;


import com.dream.common.baserx.RxManager;

/**
 * @author admin
 */
public abstract class BasePresenter<T extends BaseContract>{

    private BaseActivity mActivity;
    private BaseFragment mFragment;
    /**
     * 回调
     */
    public T mContract;
    /**
     * 管理Subscription,解除Rxjava订阅
     */
    private RxManager mRxManager = new RxManager();

    public void setVM(T v) {
        this.mContract = v;
    }

    public void setActivity(BaseActivity activity){
        this.mActivity = activity;
    }

    public void setFragment(BaseFragment fragment){
        this.mFragment = fragment;
    }

    public BaseActivity getActivity(){
        return mActivity;
    }

    public BaseFragment getFragment(){
        return mFragment;
    }

    public RxManager getRxManager(){
        return mRxManager;
    }

    public void onDestroy() {
        mActivity=null;
        mFragment=null;
        mContract=null;
        mRxManager.clear();
    }
}
