package com.dream.cleaner.ui.main.presenter;

import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.beans.workorder.WorkOrderTabBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.main.contract.WorkOrderTabFragmentContract;
import com.dream.cleaner.utils.InfoUtils;
import com.dream.common.base.BaseBean;
import com.dream.common.base.BasePresenter;
import com.dream.common.baserx.BaseRxSubscriber;
import com.dream.common.http.Api;
import com.dream.common.http.error.ErrorType;
import com.dream.common.http.mode.RequestMode;
import com.dream.common.widget.SuperToast;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONStringer;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author : Liyalei
 * date   : 2020/9/9
 * desc   :
 */
public class WorkOrderTabFragmentPresenter extends BasePresenter<WorkOrderTabFragmentContract> {

    /**
     * 任务列表
     *
     * @param pageIndex   页数
     * @param pageSize    页数size
     * @param orderStatus 查询0新任务，1待服务，2上门中，5服务中，8售后单，7已完成，9已取消
     */
    public void taskList(String pageIndex, String pageSize, int orderStatus, String orderTypeId, String serviceClassId) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", "0");
        jsonObject.addProperty("pageIndex", pageIndex);
        JsonArray jsonArray = new JsonArray();
        JsonObject pageSorts = new JsonObject();
        pageSorts.addProperty("column", "");
        pageSorts.addProperty("asc", true);
        jsonArray.add(pageSorts);
        jsonObject.add("pageSorts", jsonArray);
        jsonObject.addProperty("orderStatus", orderStatus);
        jsonObject.addProperty("pageSize", pageSize);
        jsonObject.addProperty("keyword", "");
        jsonObject.add("orderStatusList", new JsonArray());
        jsonObject.addProperty("cleanerId", InfoUtils.getCleanerId());
        jsonObject.addProperty("orderTypeId", orderTypeId);
        jsonObject.addProperty("serviceClasssId", serviceClassId);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).taskList(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<WorkOrderTabBean, BaseBean<WorkOrderTabBean>>() {
                    @Override
                    protected void onSuccess(WorkOrderTabBean loginBean, String successMessage) {
                        mContract.returnTaskList(loginBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, WorkOrderTabBean loginBean) {
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
