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
    public void ossUpload(File file) {

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
                            mContract.returnUpLoadImageStatus(uploadImageBean.getWebUrl(), uploadImageBean.getWebUrl());

                        }

                        @Override
                        protected void onError(ErrorType errorType, int errorCode, String message, UploadImageBean string) {
                            mContract.returnUpLoadImageStatus("失败", "");

                        }
                    });
        } else {
            SuperToast.showShortMessage("当前无网络，请检查您的网络");
            mContract.returnUpLoadImageStatus("无网络", "");
        }


    }

    /**
     * 确认开始-扫前准备上传照片
     */
    public void beforeClean(String orderId, String orderStatus, boolean isBefore, ArrayList<String> urlList,
                            String serviceReplenish, String suppleRefundType, String price, String explain,
                            ArrayList<String> explainPicList) {
//        {
//            "id": 0,
//                "orderStatus": 0,
//                "orderType": 0,
//                "cleanerId": 0,
//                "beforePicList": [],扫前图片
//            "remark": "",扫前备注
//                "afterPicList": [],扫后图片
//            "serviceReplenish": "",服务补充
//                "suppleRefundType": 0,补退款
//                "price": 0,金额
//                "explain": "",补退款说明
//                "explainPicList": []补退款照片
//        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", orderId);
        jsonObject.addProperty("orderStatus", orderStatus);
        jsonObject.addProperty("cleanerId", InfoUtils.getCleanerId());
        if ("4".equals(orderStatus)) {
            int size = urlList.size();
            JsonArray jsonArray = new JsonArray();
            for (int i = 0; i < size; i++) {
                jsonArray.add(urlList.get(i));
            }
            if (isBefore) {
                jsonObject.add("beforePicList", jsonArray);
                jsonObject.addProperty("serviceReplenish", serviceReplenish);
            } else {
                jsonObject.add("afterPicList", jsonArray);
            }
        } else {
            jsonObject.addProperty("suppleRefundType", suppleRefundType);
            if ("1".equals(suppleRefundType)) {
                jsonObject.addProperty("price", price);
                jsonObject.addProperty("explain", explain);
                int size = explainPicList.size();
                JsonArray jsonArray = new JsonArray();
                for (int i = 0; i < size; i++) {
                    jsonArray.add(explainPicList.get(i));
                }
                jsonObject.add("explainPicList", jsonArray);
            }
        }
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


}
