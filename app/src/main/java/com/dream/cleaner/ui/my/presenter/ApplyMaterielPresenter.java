package com.dream.cleaner.ui.my.presenter;

import com.dream.cleaner.beans.my.ApplyMaterielBean;
import com.dream.cleaner.beans.my.MaterielBean;
import com.dream.cleaner.beans.my.MaterielTypeBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.my.contract.ApplyMaterielContract;
import com.dream.cleaner.utils.InfoUtils;
import com.dream.common.base.BaseBean;
import com.dream.common.base.BasePresenter;
import com.dream.common.baserx.BaseRxSubscriber;
import com.dream.common.http.Api;
import com.dream.common.http.error.ErrorType;
import com.dream.common.http.mode.RequestMode;
import com.dream.common.widget.SuperToast;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author : Liyalei
 * date   : 2020/9/12
 * desc   :
 */
public class ApplyMaterielPresenter extends BasePresenter<ApplyMaterielContract> {


    /**
     * 物料申请接口
     */
    public void submitMateriel(String applyType, String applyNum, String collectTime, JsonArray items) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("applyType",applyType);
        jsonObject.addProperty("applyNum", applyNum);
        jsonObject.addProperty("collectTime", collectTime);
        jsonObject.add("items", items);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).submitMateriel(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String applyMaterielBean, String successMessage) {
                        mContract.returnApplyMaterielBean(applyMaterielBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String applyMaterielBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }


    /**
     * 物料详请接口
     */
    public void materielApplyInfoId(String id) {
        Api
                .observable(Api.getService(ApiService.class).materielApplyInfoId(id))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<MaterielBean, BaseBean<MaterielBean>>() {
                    @Override
                    protected void onSuccess(MaterielBean materielBean, String successMessage) {
                        mContract.returnMaterielBean(materielBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, MaterielBean materielBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }


    /**
     * 确认领取物料
     */
    public void collectId(String id) {

        Api
                .observable(Api.getService(ApiService.class).collectId(id))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String string, String successMessage) {
                        mContract.returnCollect(string);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String string) {
                        SuperToast.showShortMessage(message);
                    }
                });
    }


    /**
     * 拉取分类物料
     * 01 新人物料
     * 02 常规物料
     */
    public void materielList(String newmaterielTypeCode) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("newmaterielTypeCode", newmaterielTypeCode);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());

        Api
                .observable(Api.getService(ApiService.class).materielList(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<List<MaterielTypeBean>, BaseBean<List<MaterielTypeBean>>>() {
                    @Override
                    protected void onSuccess(List<MaterielTypeBean> list, String successMessage) {
                        mContract.returnMaterielTypeBeans(list);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, List<MaterielTypeBean> list) {
                        SuperToast.showShortMessage(message);
                    }
                });
    }


}
