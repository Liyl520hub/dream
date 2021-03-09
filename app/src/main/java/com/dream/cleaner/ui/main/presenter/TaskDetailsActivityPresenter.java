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
 * @author : admin
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
    /**
     * 接单
     */
    public void taskReceive(String id) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).taskReceive(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String s, String successMessage) {
                        mContract.returnTaskReceive(s);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String s) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

    /**
     * 出发
     */
    public void taskGo(String id) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).taskGo(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String s, String successMessage) {
                        mContract.returnTaskReceive(s);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String s) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

    /**
     * 确认到达
     */
    public void arrive(String id) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).arrive(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String s, String successMessage) {
                        mContract.returnTaskReceive(s);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String s) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }


}
