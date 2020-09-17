package com.dream.common.base;

import android.app.Application;
import android.util.Log;

import com.blankj.utilcode.util.Utils;
import com.umeng.commonsdk.UMConfigure;


/**
 * @author : Liyalei
 * date   : 2020/8/15
 * desc   :Application基类
 */
public class BaseApplication extends Application {

    private static final String TAG = "BaseApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        //初始化工具类
        Utils.init(this);
        //初始化友盟推送
        UMConfigure.init(this, "5f5e33a7b4739632429e3dad", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "26658a6cb55df9d40d4a07adb24ee269");

    }


}
