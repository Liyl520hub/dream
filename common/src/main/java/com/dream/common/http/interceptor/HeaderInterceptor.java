package com.dream.common.http.interceptor;


import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.dream.common.base.BaseApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Administrator
 * @date 2018/3/17
 */

public class HeaderInterceptor implements Interceptor {

    private int mHeaderType;

    public HeaderInterceptor(int headerType) {
        this.mHeaderType = mHeaderType;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(initBuilder(chain.request().newBuilder()).build());
    }

    private Request.Builder initBuilder(Request.Builder builder) {

        builder.addHeader("Content-Type", "application/json");
//        builder.addHeader("platform", "1");
//        builder.addHeader("appVersion", );
        String string = SPUtils.getInstance().getString("token");
        builder.addHeader("token", SPUtils.getInstance().getString("token"));
//        builder.addHeader("sysfrom", BuildConfig.SYSFROM);
//        builder.addHeader("userNo", com.baseapp.common.utils.SPUtils.getSharedStringData(BaseApplication.getAppContext(), Global.APP_USER_CODE_KEY));
//        builder.addHeader("platform", BuildConfig.PLATFORM);
//        builder.addHeader("appVersion", "1.0");
//        }
        return builder;
    }


}
