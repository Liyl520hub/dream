package com.dream.common.base;

import android.app.Application;

import com.blankj.utilcode.util.Utils;


/**
 * @author : Liyalei
 * date   : 2020/8/15
 * desc   :Application基类
 */
public class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        //初始化工具类
        Utils.init(this);
    }
}
