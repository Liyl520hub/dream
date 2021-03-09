package com.dream.cleaner.ui.my.presenter;

import com.dream.cleaner.beans.my.MyIncomeBean;
import com.dream.cleaner.beans.my.MyIncomeListBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.my.contract.MyIncomeActivityContract;
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
 * date   : 2020/9/11
 * desc   :
 */
public class MyIncomeActivityPresenter extends BasePresenter<MyIncomeActivityContract> {


    /**
     * 我的收益
     */
    public void myIncome() {

        Api
                .observable(Api.getService(ApiService.class).myIncome())
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<MyIncomeBean, BaseBean<MyIncomeBean>>() {
                    @Override
                    protected void onSuccess(MyIncomeBean myIncomeBean, String successMessage) {
                        mContract.returnMyIncome(myIncomeBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, MyIncomeBean myIncomeBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }


    /**
     * 我的收益工单列表
     */
    public void myIncomeList(String yearAndMonth) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("yearAndMonth", yearAndMonth);
        jsonObject.addProperty("pageIndex", "1");
        jsonObject.addProperty("pageSize", "999");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).myIncomeList(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<MyIncomeListBean, BaseBean<MyIncomeListBean>>() {
                    @Override
                    protected void onSuccess(MyIncomeListBean myIncomeListBean, String successMessage) {
                        mContract.returnMyIncomeList(myIncomeListBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, MyIncomeListBean myIncomeListBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }


}
