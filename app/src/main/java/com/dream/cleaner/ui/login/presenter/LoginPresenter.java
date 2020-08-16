package com.dream.cleaner.ui.login.presenter;

import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.login.contract.LoginContract;
import com.dream.common.base.BaseBean;
import com.dream.common.base.BasePresenter;
import com.dream.common.baserx.BaseRxSubscriber;
import com.dream.common.http.Api;
import com.dream.common.http.error.ErrorType;
import com.dream.common.http.mode.RequestMode;
import com.dream.common.widget.SuperToast;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :
 */
public class LoginPresenter extends BasePresenter<LoginContract> {

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param passWord 密码
     */
    public void userLogin(String userName, String passWord) {

        Api
                .observable(Api.getService(ApiService.class).userLogin(userName, passWord))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<LoginBean, BaseBean<LoginBean>>() {
                    @Override
                    protected void onSuccess(LoginBean loginBean, String successMessage) {
                        mContract.retrunLoginBean(loginBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, LoginBean loginBean) {
                        SuperToast.showShortMessage(message);
                    }
                });


    }

}
