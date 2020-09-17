package com.dream.cleaner.ui.main.presenter;

import android.util.Log;

import com.blankj.utilcode.util.NetworkUtils;
import com.dream.cleaner.beans.UploadImageBean;
import com.dream.cleaner.http.ApiService;
import com.dream.cleaner.ui.main.contract.WorkReadyActivityContract;
import com.dream.common.base.BaseApplication;
import com.dream.common.base.BaseBean;
import com.dream.common.base.BasePresenter;
import com.dream.common.baserx.BaseRxSubscriber;
import com.dream.common.baserx.RxSchedulers;
import com.dream.common.http.Api;
import com.dream.common.http.error.ErrorType;
import com.dream.common.http.mode.RequestMode;
import com.dream.common.widget.SuperToast;

import java.io.File;

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
    public void beforeClean(File file) {

        if (NetworkUtils.isConnected()) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            builder.addFormDataPart("file", "icon.jpg", RequestBody.create(MediaType.parse("image/png"), file));
            Api.
                    observable(Api.getService(ApiService.class).beforeClean(builder.build())).
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

}
