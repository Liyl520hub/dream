package com.dream.cleaner.ui.my.presenter;

import com.dream.cleaner.beans.my.MyIncomeBean;
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
 * @author : Liyalei
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


}
