package com.dream.cleaner.ui.main.presenter;

import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.beans.workorder.TaskDetailsBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.main.contract.TaskDetailsActivityContract;
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
 * date   : 2020/9/10
 * desc   :
 */
public class TaskDetailsActivityPresenter extends BasePresenter<TaskDetailsActivityContract> {

    /**
     * 订单详情
     */
    public void taskInfoId(String id) {
        Api
                .observable(Api.getService(ApiService.class).taskInfoId(id))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<TaskDetailsBean, BaseBean<TaskDetailsBean>>() {
                    @Override
                    protected void onSuccess(TaskDetailsBean taskDetailsBean, String successMessage) {
                        mContract.returnTaskDetail(taskDetailsBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, TaskDetailsBean taskDetailsBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }
//  /**
//     * 订单详情
//     *
//     */
//    public void userLogin(String id) {
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("phone", userName);
//        jsonObject.addProperty("password", passWord);
//        jsonObject.addProperty("verifyToken", "");
//        jsonObject.addProperty("imgCode", "");
//        jsonObject.addProperty("code", "");
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
//        Api
//                .observable(Api.getService(ApiService.class).taskInfoId(id))
//                .presenter(this)
//                .requestMode(RequestMode.SINGLE)
//                .showLoading(true)
//                .doRequest(new BaseRxSubscriber<TaskDetailsBean, BaseBean<TaskDetailsBean>>() {
//                    @Override
//                    protected void onSuccess(TaskDetailsBean taskDetailsBean, String successMessage) {
//                        mContract.returnLoginBean(taskDetailsBean);
//
//                    }
//
//                    @Override
//                    protected void onError(ErrorType errorType, int errorCode, String message, TaskDetailsBean taskDetailsBean) {
//                        SuperToast.showShortMessage(message);
//                    }
//                });
//
//    }

}
