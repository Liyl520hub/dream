package com.dream.cleaner.base;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.multidex.MultiDex;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.StringUtils;
import com.dream.cleaner.BuildConfig;
import com.dream.cleaner.R;
import com.dream.cleaner.ui.login.activity.LoginActivity;
import com.dream.cleaner.utils.InfoUtils;
import com.dream.cleaner.utils.UiUtil;
import com.dream.cleaner.widget.pop.PopTip;
import com.dream.common.base.BaseApplication;
import com.dream.common.baserx.BaseRxSubscriber;
import com.dream.common.http.Api;
import com.dream.common.http.config.ApiConfig;
import com.dream.common.widget.SuperToast;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

import java.util.Map;

import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;

/**
 * @author : admin
 * date   : 2020/8/15
 * desc   :app的Application
 */
public class MyApplication extends BaseApplication {

    private static final String TAG = "MyApplication";
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        initAutoSize();
        initUmeng();
        registerGlobalErrorListener();


    }

    private void initUmeng() {
        //初始化友盟推送
        UMConfigure.init(this, "5f5e33a7b4739632429e3dad",
                "cleaner", UMConfigure.DEVICE_TYPE_PHONE, "26658a6cb55df9d40d4a07adb24ee269");
        UMConfigure.setLogEnabled(true);
        //获取消息推送代理示例
        PushAgent mPushAgent = PushAgent.getInstance(this);
        mPushAgent.setNotificaitonOnForeground(true);
        mPushAgent.setNoDisturbMode(0, 0, 0, 0);
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.i(TAG, "注册成功：deviceToken：-------->  " + deviceToken);
                //alias_type 必须先add下，类型添加完后续不许再次添加
//                mPushAgent.addAlias("dream","test",null);
                String cleanerId = InfoUtils.getCleanerId();
                if (!StringUtils.isEmpty(cleanerId)) {
                    mPushAgent.deleteAlias(cleanerId, "test", new UTrack.ICallBack() {
                        @Override
                        public void onMessage(boolean b, String s) {
                            Log.e(TAG, "删除别名: " + s);
                            mPushAgent.setAlias(cleanerId, "test", new UTrack.ICallBack() {
                                @Override
                                public void onMessage(boolean b, String s) {
                                    Log.e(TAG, "设置别名: " + s);
                                }
                            });
                        }
                    });
                }

            }

            @Override
            public void onFailure(String s, String s1) {
//                Log.e(TAG, "注册失败：-------->  " + "s:" + s + ",s1:" + s1);
            }
        });
        UmengMessageHandler messageHandler = new UmengMessageHandler() {
            @Override
            public Notification getNotification(Context context, UMessage msg) {
                Log.e(TAG, "getNotification: " + msg.getRaw().toString());
                if (msg.extra != null) {
                    String orderType = msg.extra.get("orderType");
                    if (!StringUtils.isEmpty(orderType)) {
                        if ("05".equals(orderType)) {
                            playMedia();
                        }
                    }
                }
                return super.getNotification(context, msg);
            }
        };
        mPushAgent.setMessageHandler(messageHandler);
    }

    private void playMedia() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.neworder);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
    }


    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.white, R.color.color_333333);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
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

    private void registerGlobalErrorListener() {

        BaseRxSubscriber.registerGlobalErrorListener(new BaseRxSubscriber.GlobalErrorListener() {

            private PopTip mDialog;

            @Override
            public void onReturn10007Code(BaseRxSubscriber rxSubscriber, String message) {
                final Activity mActivity;
                if (rxSubscriber.getActivity() != null) {
                    mActivity = rxSubscriber.getActivity();
                } else if (rxSubscriber.getFragment() != null) {
                    mActivity = rxSubscriber.getFragment().getActivity();
                } else {
                    mActivity = ActivityUtils.getTopActivity();
                }
                if (mActivity != null) {

                    mDialog = new PopTip.Builder()
                            .setType(2)
                            .setTitle("提示")
                            .setSubmitText("确定")
                            .setCancelText("取消")
                            .setMsg(message)
                            .setCancelClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mDialog.dismiss();
                                    mDialog = null;
                                }
                            })
                            .setSubmitClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mDialog.dismiss();
                                    Bundle bundle = new Bundle();
                                    //从哪来 回哪去
                                    bundle.putBoolean("TokenVerificationFailed", true);
                                    UiUtil.openActivity(mActivity, LoginActivity.class, bundle);
                                    mDialog = null;
                                }
                            }).build(mActivity);
                    if (!mDialog.isShowing()) {
                        try {
                            mDialog.showPopupWindow();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    SuperToast.showShortMessage(message);
                }
            }
        });
    }


}
