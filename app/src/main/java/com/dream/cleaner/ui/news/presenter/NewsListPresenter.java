package com.dream.cleaner.ui.news.presenter;

import com.dream.cleaner.beans.news.NewsListBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.news.contract.NewsListContract;
import com.dream.common.base.BaseBean;
import com.dream.common.base.BasePresenter;
import com.dream.common.baserx.BaseRxSubscriber;
import com.dream.common.http.Api;
import com.dream.common.http.error.ErrorType;
import com.dream.common.http.mode.RequestMode;
import com.dream.common.widget.SuperToast;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author : liyl
 * date   : 2020/9/9
 * desc   :
 */
public class NewsListPresenter extends BasePresenter<NewsListContract> {


    public void newsList(int pageIndex, int userId, String messageType) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("pageIndex", pageIndex);
        JsonArray jsonArray = new JsonArray();
        JsonObject pageSorts = new JsonObject();
        pageSorts.addProperty("column", "");
        pageSorts.addProperty("asc", true);
        jsonArray.add(pageSorts);
        jsonObject.add("pageSorts", jsonArray);

        jsonObject.addProperty("userId", userId);
        jsonObject.addProperty("pageSize", 0);
        jsonObject.addProperty("userType", "userType");
        jsonObject.addProperty("isDel", 0);
        jsonObject.addProperty("keyword", "keyword");
        jsonObject.addProperty("messageType", messageType);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());

        Api.observable(Api.getService(ApiService.class).messageList(requestBody))
                .presenter(this)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new BaseRxSubscriber<NewsListBean, BaseBean<NewsListBean>>() {
                    @Override
                    protected void onSuccess(NewsListBean newsListBean, String successMessage) {
                        mContract.returnNewsListBean(newsListBean);
                    }

                    @Override
                    protected void onError(ErrorType errorType, int errorCode, String message, NewsListBean data) {
                        SuperToast.showShortMessage(message);

                    }

                });

    }

}
