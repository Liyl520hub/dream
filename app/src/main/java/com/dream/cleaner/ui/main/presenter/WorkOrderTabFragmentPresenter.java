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
     * 用户登录
     *
     * @param pageIndex   页数
     * @param pageSize    页数size
     * @param orderStatus 查询0新任务，1待服务，2上门中，5服务中，8售后单，7已完成，9已取消
     */
    public void taskList(String pageIndex, String pageSize, String orderStatus) {
        int intOrderStatus = 0;
        switch (orderStatus) {
            case "新任务": {
                intOrderStatus = 0;
            }
            break;
            case "待服务": {
                intOrderStatus = 1;
            }
            break;
            case "上门中": {
                intOrderStatus = 2;
            }
            break;
            case "服务中": {
                intOrderStatus = 5;
            }
            break;
            case "售后": {
                intOrderStatus = 8;
            }
            break;
            case "已完成": {
                intOrderStatus = 7;
            }
            break;
            case "已取消": {
                intOrderStatus = 9;
            }
            break;
            default:
        }


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", "0");
        jsonObject.addProperty("pageIndex", pageIndex);
        JsonArray jsonArray = new JsonArray();
        JsonObject pageSorts = new JsonObject();
        pageSorts.addProperty("column", "");
        pageSorts.addProperty("asc", true);
        jsonArray.add(pageSorts);
        jsonObject.add("pageSorts", jsonArray);
        jsonObject.addProperty("orderStatus", intOrderStatus);
        jsonObject.addProperty("pageSize", pageSize);
        jsonObject.addProperty("keyword", "");
        jsonObject.add("orderStatusList", new JsonArray());
        jsonObject.addProperty("cleanerId", InfoUtils.getCleanerId());
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


}
