package com.dream.cleaner.utils;

import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.ui.main.MainActivity;
import com.dream.cleaner.ui.main.adapter.MainAdapter;

/**
 * @author : Liyalei
 * date   : 2020/9/23
 * desc   :
 */
public class LocationUtils {

    /**
     * 声明AMapLocationClient类对象
     */
    public static AMapLocationClient mLocationClient = null;
    /**
     * 声明AMapLocationClientOption对象
     */
    public static AMapLocationClientOption mLocationOption = null;
    /**
     * 声明定位回调监听器
     */
    public static AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    //纬度
                    double latitude = aMapLocation.getLatitude();
                    //经度
                    double longitude = aMapLocation.getLongitude();
                    SPUtils.getInstance().put(GlobalApp.USER_LATITUDE, latitude + "");
                    SPUtils.getInstance().put(GlobalApp.USER_LONGITUDE, longitude + "");
                    Log.e("onLocationChanged: ", longitude + "," + latitude);
                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                }
            }
        }
    };

    /**
     * @param mode                 定位场景
     * @param interval             间隔时间
     * @param aMapLocationListener 监听
     */
    public static void initLocation(AMapLocationClientOption.AMapLocationPurpose mode, int interval, AMapLocationListener aMapLocationListener) {
        //初始化定位
        mLocationClient = new AMapLocationClient(Utils.getApp());
        //设置定位回调监听
        mLocationClient.setLocationListener(aMapLocationListener != null ? aMapLocationListener : mLocationListener);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        /**
         * 设置定位场景，目前支持三种场景（签到、出行、运动，默认无场景）
         */
        mLocationOption.setLocationPurpose(mode);
        if (null != mLocationClient) {
            mLocationClient.setLocationOption(mLocationOption);
            //设置场景模式后最好调用一次stop，再调用start以保证场景模式生效
            mLocationClient.stopLocation();
            mLocationClient.startLocation();
        }
        //获取多次定位  true 单次 false 多次
        mLocationOption.setOnceLocation(interval==0);
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //获取定位间隔时间
        mLocationOption.setInterval(interval);
        //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
        mLocationOption.setHttpTimeOut(20000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    /**
     * 默认--出行模式--间隔三秒获取一次位置
     */
    public static void initLocation() {
        initLocation(AMapLocationClientOption.AMapLocationPurpose.Transport,3000, mLocationListener);
    }

}
