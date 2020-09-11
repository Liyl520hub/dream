package com.dream.cleaner.ui.my.presenter;

import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.beans.workorder.TaskDetailsBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.my.contract.UserInfoActivityContract;
import com.dream.common.base.BaseBean;
import com.dream.common.base.BasePresenter;
import com.dream.common.baserx.BaseRxSubscriber;
import com.dream.common.http.Api;
import com.dream.common.http.error.ErrorType;
import com.dream.common.http.mode.RequestMode;
import com.dream.common.widget.SuperToast;

/**
 * @author : Liyalei
 * date   : 2020/9/11
 * desc   :
 */
public class UserInfoActivityPresenter extends BasePresenter<UserInfoActivityContract> {

    /**
     * 获取个人信息
     */
    public void userInfo(String id) {
        Api
                .observable(Api.getService(ApiService.class).userInfo(id))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<LoginBean.CleanerBean, BaseBean<LoginBean.CleanerBean>>() {
                    @Override
                    protected void onSuccess(LoginBean.CleanerBean cleanerBean, String successMessage) {
                        mContract.returnUserInfoBean(cleanerBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, LoginBean.CleanerBean cleanerBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }



}
