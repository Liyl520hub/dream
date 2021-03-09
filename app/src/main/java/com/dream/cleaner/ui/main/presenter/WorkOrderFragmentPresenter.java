package com.dream.cleaner.ui.main.presenter;

import com.dream.cleaner.beans.workorder.PopWorkOrderBean;
import com.dream.cleaner.beans.workorder.WorkOrderTabBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.main.contract.WorkOrderFragmentContract;
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
 * @author : admin
 * date   : 2020/9/15
 * desc   :
 */
public class WorkOrderFragmentPresenter extends BasePresenter<WorkOrderFragmentContract> {


    /**
     * 获取服务类型
     *
     * @param pageIndex   页数
     * @param pageSize    页数size
     * @param orderStatus 查询0新任务，1待服务，2上门中，5服务中，8售后单，7已完成，9已取消
     */
    public void getServiceClassList() {
        Api
                .observable(Api.getService(ApiService.class).getServiceClassList())
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<List<PopWorkOrderBean>, BaseBean<List<PopWorkOrderBean>>>() {
                    @Override
                    protected void onSuccess(List<PopWorkOrderBean> list, String successMessage) {
                        mContract.returnPopWorkOrder(list, false);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, List<PopWorkOrderBean> list) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }


    /**
     * 获取订单类型
     */
    public void getOrderTypeList() {
        Api
                .observable(Api.getService(ApiService.class).getOrderTypeList())
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<List<PopWorkOrderBean>, BaseBean<List<PopWorkOrderBean>>>() {
                    @Override
                    protected void onSuccess(List<PopWorkOrderBean> list, String successMessage) {
                        mContract.returnPopWorkOrder(list, true);

                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, List<PopWorkOrderBean> list) {
                        SuperToast.showShortMessage(message);
                    }
                });

    }


}
