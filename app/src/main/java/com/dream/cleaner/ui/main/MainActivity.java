package com.dream.cleaner.ui.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.blankj.utilcode.util.BusUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.BusBean;
import com.dream.cleaner.ui.main.adapter.MainAdapter;
import com.dream.cleaner.ui.main.fragment.WorkOrderFragment;
import com.dream.cleaner.ui.my.fragment.UserFragment;
import com.dream.cleaner.ui.news.fragment.NewsListFragment;
import com.dream.cleaner.ui.plan.fragment.PlanFragment;
import com.dream.cleaner.widget.DataGenerator;
import com.dream.cleaner.widget.pop.PopTip;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarTitleLeftTv;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;

/**
 * @author admin
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.my_view_pager)
    ViewPager2 myViewPager;
    @BindView(R.id.my_tab_layout)
    TabLayout myTabLayout;
    private ToolbarTitleLeftTv toolbarTitle;
    public String leftText;
    private PopTip popPermissionsTip;
    private static final String TAG = "MainActivity";
    private PopTip locationPop;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
    }


    @Override
    protected MyToolbar getMyToolbar() {
        toolbarTitle = new ToolbarTitleLeftTv(this, "壹佳保洁");
        return toolbarTitle;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        setDoubleClickExit(true);
        BusUtils.register(this);
        initData();
//        LocationUtils.initLocation(AMapLocationClientOption.AMapLocationPurpose.SignIn, 0, new AMapLocationListener() {
//            @Override
//            public void onLocationChanged(AMapLocation aMapLocation) {
//                if (aMapLocation != null) {
//                    if (aMapLocation.getErrorCode() == 0) {
//                        //纬度
//                        double latitude = aMapLocation.getLatitude();
//                        //经度
//                        double longitude = aMapLocation.getLongitude();
//                        SPUtils.getInstance().put(GlobalApp.USER_LATITUDE, latitude + "");
//                        SPUtils.getInstance().put(GlobalApp.USER_LONGITUDE, longitude + "");
//                        initData();
//                    } else {
//                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
//                        Log.e("AmapError", "location Error, ErrCode:"
//                                + aMapLocation.getErrorCode() + ", errInfo:"
//                                + aMapLocation.getErrorInfo());
//                    }
//                }
//            }
//        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        getMyPermissions();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void getMyPermissions() {
        String[] permissions = {Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION};
        Disposable subscribe = new RxPermissions(MainActivity.this).requestEach(permissions)
                .subscribe(aBoolean -> {
                    if (aBoolean.granted) {
//                        LocationUtils.initLocation();
                    } else if (aBoolean.shouldShowRequestPermissionRationale) {
                        getMyPermissions();
                    } else {
                        popPermissionsTip = new PopTip.Builder()
                                .setType(1)
                                .setTitle("提示")
                                .setSubmitText("立即获取")
                                .setMsg("考啦需要以下权限才能正常运行")
                                .setSubmitClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        // 帮跳转到该应用的设置界面，让用户手动授权
                                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        Uri uri = Uri.fromParts("package", MainActivity.this.getPackageName(), null);
                                        intent.setData(uri);
                                        startActivity(intent);
                                        popPermissionsTip.dismiss();
                                    }
                                }).build(MainActivity.this);
                    }
                });
    }

    /**
     * 弹框提示用户打开GPS
     */
    public void openGPS() {
        locationPop = new PopTip.Builder()
                .setType(1)
                .setTitle("提示")
                .setSubmitText("立即开启")
                .setMsg("未开启定位开关无法获取订单，是否立即开启？")
                .setSubmitClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 帮跳转到该应用的设置界面，让用户手动授权
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(intent, 8877);
                        locationPop.dismiss();
                    }
                }).build(MainActivity.this);
        locationPop.showPopupWindow();
    }


    private void initData() {
        if (isOPen(MainActivity.this)) {
            MainAdapter mainAdapter = new MainAdapter(MainActivity.this, getFragments());
            myViewPager.setAdapter(mainAdapter);
            myViewPager.setUserInputEnabled(false);
            myViewPager.setOffscreenPageLimit(4);
            initTabLayout();
        } else {
            openGPS();
        }


//        LocationUtils.initLocation();
    }

    private void initTabLayout() {
        //设置关联
        new TabLayoutMediator(myTabLayout, myViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setCustomView(DataGenerator.getTabView(MainActivity.this, position, position == 0));
            }
        }).attach();
        //设置点击切换状态
        myTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0: {
                        toolbarTitle.setTitle("壹佳保洁");
                        toolbarTitle.setLiftTitle("");
                    }
                    break;
                    case 1: {
                        toolbarTitle.setTitle("计划");
                        toolbarTitle.setLiftTitle(leftText);
                    }
                    break;
                    case 2: {
                        toolbarTitle.setTitle("消息通知");
                        toolbarTitle.setLiftTitle("");
                    }
                    break;
                    case 3: {
                        toolbarTitle.setTitle("个人中心");
                        toolbarTitle.setLiftTitle("");
                    }
                    break;
                    default:
                }

                if (position == 3) {

                }
                setTabState(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        WorkOrderFragment workOrderFragment = new WorkOrderFragment();
        PlanFragment planFragment = new PlanFragment();
        NewsListFragment newsFragment = new NewsListFragment();
        UserFragment userFragment = new UserFragment();
        fragments.add(workOrderFragment);
        fragments.add(planFragment);
        fragments.add(newsFragment);
        fragments.add(userFragment);
        return fragments;
    }

    /**
     * @param tabPosition 设置tab状态
     */
    private void setTabState(int tabPosition) {
        for (int i = 0; i < myTabLayout.getTabCount(); i++) {
            TabLayout.Tab tabAt = myTabLayout.getTabAt(i);
            if (tabAt != null) {
                View view = tabAt.getCustomView();
                if (view != null) {
                    ImageView icon = view.findViewById(R.id.tab_content_image);
                    TextView tabContentText = view.findViewById(R.id.tab_content_text);
                    if (i == tabPosition) {
                        // 选中状态
                        icon.setImageResource(DataGenerator.mTabRes[i]);
                        tabContentText.setSelected(true);
                    } else {// 未选中状态
                        icon.setImageResource(DataGenerator.mTabResPressed[i]);
                        tabContentText.setSelected(false);

                    }
                }
            }
        }
    }

    @BusUtils.Bus(tag = GlobalApp.BUS_FRAGMENT_PLAN)
    public void postBusListener(BusBean busBean) {
        leftText = busBean.getName();
        toolbarTitle.setLiftTitle(busBean.getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusUtils.unregister(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 8877) {
                initData();
            }
    }

    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的
     *
     * @param context
     * @return true 表示开启
     */
    public boolean isOPen(final Context context) {
        LocationManager locationManager
                = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        if (locationManager != null) {
            boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
            boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            if (gps && network) {
                return true;
            }
        }
        return false;
    }

}
