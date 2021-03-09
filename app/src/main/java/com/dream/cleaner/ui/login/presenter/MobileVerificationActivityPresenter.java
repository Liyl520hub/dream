package com.dream.cleaner.ui.login.presenter;

import com.blankj.utilcode.util.SPUtils;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.login.AgreementBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.login.contract.MobileVerificationActivityContract;
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
 * date   : 2020/9/7
 * desc   :
 */
public class MobileVerificationActivityPresenter extends BasePresenter<MobileVerificationActivityContract> {


    /**
     * 校验图片验证码
     */
    public void updateCheckLocalCode(String phone, String imgCode) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("phone", phone);
        jsonObject.addProperty("verifyToken", SPUtils.getInstance().getString(GlobalApp.VERIFY_TOKEN, ""));
        jsonObject.addProperty("imgCode", imgCode);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).checkImgCode(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String agreementBean, String successMessage) {
                        mContract.returnAgreementPhone(agreementBean, true);
                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String loginBean) {
                        mContract.showErrorTip(errorType, 1, message);
                        SuperToast.showShortMessage(message);
                    }
                });

    }

    /**
     * 校验验证码
     */
    public void updateCheckCode(String phone, String code) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("phone", phone);
//        jsonObject.addProperty("verifyToken",  SPUtils.getInstance().getString(GlobalApp.VERIFY_TOKEN, ""));
//        jsonObject.addProperty("imgCode", localCode);
        jsonObject.addProperty("code", code);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).CheckPhoneCode(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String agreementBean, String successMessage) {
                        mContract.returnAgreementPhone(agreementBean, false);
                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String loginBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

    /**
     * 发送验证码
     */
    public void agreementPhone(String phone, String localCode) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("phone", phone);
        jsonObject.addProperty("verifyToken", SPUtils.getInstance().getString(GlobalApp.VERIFY_TOKEN, ""));
        jsonObject.addProperty("imgCode", localCode);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());

        Api
                .observable(Api.getService(ApiService.class).agreementPhone(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<AgreementBean, BaseBean<AgreementBean>>() {
                    @Override
                    protected void onSuccess(AgreementBean agreementBean, String successMessage) {
//                        mContract.returnAgreementPhone(agreementBean);
                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, AgreementBean loginBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

}
