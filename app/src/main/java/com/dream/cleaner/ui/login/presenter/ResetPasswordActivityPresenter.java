package com.dream.cleaner.ui.login.presenter;

import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.login.contract.ResetPasswordActivityContract;
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
 * @author : Liyalei
 * date   : 2020/9/7
 * desc   :
 */
public class ResetPasswordActivityPresenter extends BasePresenter<ResetPasswordActivityContract> {

    /**
     * 修改密码
     *
     * @param userName 用户名
     * @param passWord 密码
     */
    public void updatePassword(String userName, String passWord) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("phone", userName);
        jsonObject.addProperty("password", passWord);
        jsonObject.addProperty("verifyToken", "");
        jsonObject.addProperty("imgCode", "");
        jsonObject.addProperty("code", "");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).updatePassword(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<LoginBean, BaseBean<LoginBean>>() {
                    @Override
                    protected void onSuccess(LoginBean loginBean, String successMessage) {
                        mContract.returnUpdatePWBean(loginBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, LoginBean loginBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

}
