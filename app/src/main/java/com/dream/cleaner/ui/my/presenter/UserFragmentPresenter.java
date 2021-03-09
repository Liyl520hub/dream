package com.dream.cleaner.ui.my.presenter;

import com.dream.cleaner.beans.my.CleanerOrderCountBean;
import com.dream.cleaner.beans.my.MyIncomeListBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.my.contract.UserFragmentContract;
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
public class UserFragmentPresenter extends BasePresenter<UserFragmentContract> {
    /**
     * 保洁员订单个数
     */
    public void getCleanerOrderCount(String time) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("cleanerId", InfoUtils.getCleanerId());
        jsonObject.addProperty("time", time);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).getCleanerOrderCount(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<CleanerOrderCountBean, BaseBean<CleanerOrderCountBean>>() {
                    @Override
                    protected void onSuccess(CleanerOrderCountBean cleanerOrderCountBean, String successMessage) {
                        mContract.returnCleanerOrderCountBean(cleanerOrderCountBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, CleanerOrderCountBean cleanerOrderCountBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }
}
