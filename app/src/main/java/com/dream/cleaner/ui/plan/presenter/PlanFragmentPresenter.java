package com.dream.cleaner.ui.plan.presenter;

import com.dream.cleaner.beans.PlanBean;
import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.plan.contract.PlanFragmentContract;
import com.dream.common.base.BaseBean;
import com.dream.common.base.BasePresenter;
import com.dream.common.baserx.BaseRxSubscriber;
import com.dream.common.http.Api;
import com.dream.common.http.error.ErrorType;
import com.dream.common.http.mode.RequestMode;
import com.dream.common.widget.SuperToast;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author : admin
 * date   : 2020/9/9
 * desc   :
 */
public class PlanFragmentPresenter extends BasePresenter<PlanFragmentContract> {


    /**
     * 获取计划
     *
     * @param year  年
     * @param month 月
     */
    public void getCleanerPlan(String year, String month) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("year", year);
        jsonObject.addProperty("month", month);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).getCleanerPlanMonth(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<List<PlanBean>, BaseBean<List<PlanBean>>>() {
                    @Override
                    protected void onSuccess(List<PlanBean> list, String successMessage) {
                        mContract.returnCleanerPlan(list);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, List<PlanBean> list) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

    /**
     * 获取计划
     *
     * @param year  年
     * @param month 月
     */
    public void getCleanerPlanDay(String currentDate) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("currentDate", currentDate);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).getCleanerPlanDay(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<List<PlanBean.CleanerPlanItemsBean>, BaseBean<List<PlanBean.CleanerPlanItemsBean>>>() {
                    @Override
                    protected void onSuccess(List<PlanBean.CleanerPlanItemsBean> list, String successMessage) {
                        mContract.returnCleanerPlanDay(list);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, List<PlanBean.CleanerPlanItemsBean> list) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

}
