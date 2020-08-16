package com.dream.cleaner.base;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.dream.cleaner.BuildConfig;
import com.dream.common.base.BaseApplication;
import com.dream.common.http.Api;
import com.dream.common.http.config.ApiConfig;

import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;

/**
 * @author : Liyalei
 * date   : 2020/8/15
 * desc   :app的Application
 */
public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initAutoSize();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private void initAutoSize() {
        initApiConfig();
        AutoSize.initCompatMultiProcess(this);
        //设置系统字体不影响app字体
        AutoSizeConfig.getInstance().setExcludeFontScale(true);
    }
    private void initApiConfig() {
        ApiConfig mApiConfig = new ApiConfig();
        mApiConfig.setHostServer(BuildConfig.HOST_SERVER);
        mApiConfig.setReadTimeOut(BuildConfig.READ_TIME_OUT);
        mApiConfig.setConnectTimeOut(BuildConfig.CONNECT_TIME_OUT);
        Api.setConfig(mApiConfig);
    }

}
