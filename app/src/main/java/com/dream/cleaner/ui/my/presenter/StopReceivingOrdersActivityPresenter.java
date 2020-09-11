package com.dream.cleaner.ui.my.presenter;

import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.beans.my.LeaveBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.my.contract.StopReceivingOrdersActivityContract;
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
 * @author : Liyalei
 * date   : 2020/9/11
 * desc   :
 */
public class StopReceivingOrdersActivityPresenter extends BasePresenter<StopReceivingOrdersActivityContract> {

    /**
     * 请假列表
     */
    public void leaveApplyList(String pageIndex, String pageSize) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("cleanerId", InfoUtils.getCleanerId());
        jsonObject.addProperty("pageIndex", pageIndex);
        jsonObject.addProperty("pageSize", pageSize);
//        jsonObject.addProperty("imgCode", "");
//        jsonObject.addProperty("code", "");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).leaveApplyList(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<LeaveBean, BaseBean<LeaveBean>>() {
                    @Override
                    protected void onSuccess(LeaveBean leaveBean, String successMessage) {
                        mContract.returnLeaveBean(leaveBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, LeaveBean leaveBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }


    /**
     * 请假申请详情
     */
    public void leaveApplyList(String id) {
        Api
                .observable(Api.getService(ApiService.class).leaveApplyDetailId(id))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<LeaveBean.RecordsBean, BaseBean<LeaveBean.RecordsBean>>() {
                    @Override
                    protected void onSuccess(LeaveBean.RecordsBean leaveBean, String successMessage) {
                        mContract.returnLeaveRecordsBean(leaveBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, LeaveBean.RecordsBean leaveBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

    /**
     * 申请请假
     */
    public void leaveApply(String startTime, String endTime, String reason) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("cleanerId", InfoUtils.getCleanerId());
        jsonObject.addProperty("startTime", startTime);
        jsonObject.addProperty("endTime", endTime);
        jsonObject.addProperty("reason", reason);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).leaveApply(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String leaveBean, String successMessage) {
                        mContract.returnApply(leaveBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String leaveBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }
}
