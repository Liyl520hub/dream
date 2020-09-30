package com.dream.cleaner.ui.main.presenter;

import android.util.Log;

import com.blankj.utilcode.util.NetworkUtils;
import com.dream.cleaner.beans.UploadImageBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.main.contract.WorkReadyActivityContract;
import com.dream.cleaner.utils.InfoUtils;
import com.dream.common.base.BaseApplication;
import com.dream.common.base.BaseBean;
import com.dream.common.base.BasePresenter;
import com.dream.common.baserx.BaseRxSubscriber;
import com.dream.common.baserx.RxSchedulers;
import com.dream.common.http.Api;
import com.dream.common.http.error.ErrorType;
import com.dream.common.http.mode.RequestMode;
import com.dream.common.widget.SuperToast;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @author : Liyalei
 * date   : 2020/9/15
 * desc   :
 */
public class WorkReadyActivityPresenter extends BasePresenter<WorkReadyActivityContract> {

    /**
     * 上传图片
     */
    public void ossUpload(File file, boolean isSaoQianZhunBei) {

        if (NetworkUtils.isConnected()) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            builder.addFormDataPart("file", "icon.jpg", RequestBody.create(MediaType.parse("image/png"), file));
            Api.
                    observable(Api.getService(ApiService.class).ossUpload(builder.build())).
                    presenter(this).
                    requestMode(RequestMode.SINGLE).
                    showLoading(true).
                    doRequest(new BaseRxSubscriber<UploadImageBean, BaseBean<UploadImageBean>>() {
                        @Override
                        protected void onSuccess(UploadImageBean uploadImageBean, String successMessage) {
                            if (uploadImageBean != null) {
                                mContract.returnUpLoadImageStatus(uploadImageBean.getWebUrl(), uploadImageBean.getWebUrl(), isSaoQianZhunBei);
                            }else{
                                mContract.returnUpLoadImageStatus("失败", "", isSaoQianZhunBei);
                            }
                        }

                        @Override
                        protected void onError(ErrorType errorType, int errorCode, String message, UploadImageBean string) {
                            mContract.returnUpLoadImageStatus("失败", "", isSaoQianZhunBei);

                        }
                    });
        } else {
            SuperToast.showShortMessage("当前无网络，请检查您的网络");
            mContract.returnUpLoadImageStatus("无网络", "", isSaoQianZhunBei);
        }


    }

    /**
     * 确认开始-扫前准备上传照片
     */
    public void beforeClean(String orderId, String orderStatus, boolean isBefore, ArrayList<String> urlList,
                            String serviceReplenish, String suppleRefundType, String price, String explain,
                            ArrayList<String> explainPicList) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", orderId);
        jsonObject.addProperty("orderStatus", orderStatus);
        jsonObject.addProperty("cleanerId", InfoUtils.getCleanerId());
        int size = urlList.size();
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < size; i++) {
            jsonArray.add(urlList.get(i));
        }
        //扫前
        jsonObject.add("beforePicList", jsonArray);
        jsonObject.addProperty("remark", serviceReplenish);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).beforeClean(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String s, String successMessage) {
                        mContract.returnBeforeClean(s);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String s) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }

    /**
     * 确认完成
     */
    public void confirmFinish(String orderId, String orderStatus, boolean isBefore, ArrayList<String> urlList,
                              String serviceReplenish, String suppleRefundType, String price, String explain,
                              ArrayList<String> explainPicList) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", orderId);
        jsonObject.addProperty("orderStatus", orderStatus);
        jsonObject.addProperty("cleanerId", InfoUtils.getCleanerId());
        int size = urlList.size();
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < size; i++) {
            jsonArray.add(urlList.get(i));
        }
        jsonObject.add("afterPicList", jsonArray);
        //服务补充
        jsonObject.addProperty("serviceReplenish", serviceReplenish);
        //补退款type
        jsonObject.addProperty("suppleRefundType", suppleRefundType);
        // 0，退款，1补款  2 不需要
        if (!"2".equals(suppleRefundType)) {
            jsonObject.addProperty("price", price);
            //补退款说明
            jsonObject.addProperty("explain", explain);
            int explainPicListSize = explainPicList.size();
            JsonArray jsonArray2 = new JsonArray();
            for (int i = 0; i < explainPicListSize; i++) {
                jsonArray2.add(explainPicList.get(i));
            }
            jsonObject.add("explainPicList", jsonArray2);
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).confirmFinish(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String s, String successMessage) {
                        mContract.returnBeforeClean(s);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String s) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }


}
