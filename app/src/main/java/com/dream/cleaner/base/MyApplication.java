package com.dream.cleaner.base;

import android.content.Context;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.dream.cleaner.BuildConfig;
import com.dream.common.base.BaseApplication;
import com.dream.common.http.Api;
import com.dream.common.http.config.ApiConfig;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;

import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;

/**
 * @author : Liyalei
 * date   : 2020/8/15
 * desc   :app的Application
 */
public class MyApplication extends BaseApplication {

    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        initAutoSize();

        //获取消息推送代理示例
        PushAgent mPushAgent = PushAgent.getInstance(this);

        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.i(TAG, "注册成功：deviceToken：-------->  " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e(TAG, "注册失败：-------->  " + "s:" + s + ",s1:" + s1);
            }
        });

        mPushAgent.setAlias("dream", "", new UTrack.ICallBack() {
            @Override
            public void onMessage(boolean b, String s) {
                Log.d(TAG, "onMessage: " + s);
            }
        });
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
