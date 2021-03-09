package com.dream.cleaner.ui.login.presenter;

import com.dream.cleaner.beans.login.AgreementBean;
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
import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author : admin
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
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("phone", userName);
        jsonObject.addProperty("password", passWord);
        jsonObject.addProperty("verifyToken", "");
        jsonObject.addProperty("imgCode", "");
        jsonObject.addProperty("code", "");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).userLogin(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<LoginBean, BaseBean<LoginBean>>() {
                    @Override
                    protected void onSuccess(LoginBean loginBean, String successMessage) {
                        mContract.returnLoginBean(loginBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, LoginBean loginBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

    /**
     * 保洁端获取用户协议
     */
    public void agreement(boolean isPrivacy) {
        Api
                .observable(Api.getService(ApiService.class).agreement())
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<AgreementBean, BaseBean<AgreementBean>>() {
                    @Override
                    protected void onSuccess(AgreementBean agreementBean, String successMessage) {
                        mContract.returnAgreementBean(agreementBean,isPrivacy);
                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, AgreementBean loginBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

    /**
     * 保洁端获取隐私条款
     */
    public void privacy(boolean isPrivacy) {
        Api
                .observable(Api.getService(ApiService.class).privacy())
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<AgreementBean, BaseBean<AgreementBean>>() {
                    @Override
                    protected void onSuccess(AgreementBean agreementBean, String successMessage) {
                        mContract.returnAgreementBean(agreementBean,isPrivacy);
                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, AgreementBean loginBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }


}
