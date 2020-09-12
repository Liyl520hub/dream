package com.dream.cleaner.ui.news.presenter;

import com.dream.cleaner.beans.news.NewsDetailsBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.news.contract.NewsDetailsContract;
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
 * Create by moying
 * Creation time:2020/8/28
 * Class action:
 */
public class NewsDetailsPresenter extends BasePresenter<NewsDetailsContract> {

    /**
     * 消息详情
     *
     * @param id
     */
    public void newsDetails(String id) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());

        Api.observable(Api.getService(ApiService.class).messageDetailId(id))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<NewsDetailsBean, BaseBean<NewsDetailsBean>>() {
                    @Override
                    protected void onSuccess(NewsDetailsBean NewsDetailsBean, String successMessage) {
                        mContract.returnNewsDetails(NewsDetailsBean);
                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, NewsDetailsBean data) {
                        SuperToast.showShortMessage(message);

                    }

                });

    }

    public void newsDetailsRead(String id) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", id);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());

        Api.observable(Api.getService(ApiService.class).messageReadId(id))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<String, BaseBean<String>>() {
                    @Override
                    protected void onSuccess(String string, String successMessage) {
                        mContract.returnNewsDetailsRead(string);
                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, String data) {
                        SuperToast.showShortMessage(message);

                    }

                });

    }
}
