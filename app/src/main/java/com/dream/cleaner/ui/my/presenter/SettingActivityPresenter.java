package com.dream.cleaner.ui.my.presenter;

import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.my.contract.SettingActivityContract;
import com.dream.cleaner.utils.InfoUtils;
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
 * date   : 2020/9/8
 * desc   :
 */
public class SettingActivityPresenter extends BasePresenter<SettingActivityContract> {

    /**
     * 用户退出登录
     */
    public void logout() {
        Api
                .observable(Api.getService(ApiService.class).logout())
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String loginBean, String successMessage) {
                        mContract.returnLogout(loginBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String loginBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

    /**
     * 修改接收消息通知开关
     */
    public void updatePush(String isReceive) {
        // 0 接收  1 不接受
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", InfoUtils.getCleanerId());
        jsonObject.addProperty("isReceive", isReceive);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());

        Api
                .observable(Api.getService(ApiService.class).updatePush(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String string, String successMessage) {
                        mContract.returnUpdate(string);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String string) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

}
