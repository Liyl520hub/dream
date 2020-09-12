package com.dream.cleaner.ui.my.presenter;

import com.dream.cleaner.beans.my.ApplyMaterielBean;
import com.dream.cleaner.beans.my.LeaveBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.my.contract.MaterielApplyContract;
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
 * date   : 2020/9/12
 * desc   :
 */
public class MaterielApplyPresenter extends BasePresenter<MaterielApplyContract> {

    /**
     * 物料申请列表
     */
    public void getPageList(String pageIndex, String pageSize) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("applyPerson", InfoUtils.getCleanerId());
        jsonObject.addProperty("pageIndex", pageIndex);
        jsonObject.addProperty("pageSize", pageSize);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());
        Api
                .observable(Api.getService(ApiService.class).getPageList(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<ApplyMaterielBean, BaseBean<ApplyMaterielBean>>() {
                    @Override
                    protected void onSuccess(ApplyMaterielBean leaveBean, String successMessage) {
                        mContract.returnMaterielBean(leaveBean);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, ApplyMaterielBean leaveBean) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }





}
