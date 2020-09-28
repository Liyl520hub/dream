package com.dream.cleaner.ui.main.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.workorder.TaskDetailsBean;
import com.dream.cleaner.ui.main.contract.TaskDetailsActivityContract;
import com.dream.cleaner.ui.main.presenter.TaskDetailsActivityPresenter;
import com.dream.cleaner.utils.InfoUtils;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.cleaner.utils.UiUtil;
import com.dream.cleaner.widget.pop.PopTip;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.ToolbarBackTitle;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

/**
 * author : liyl
 * date   : 2020/8/20
 * desc   : 任务详情
 * type
 * 0 新任务---》 任务信息 联系方式 订单信息  底部按钮为接单
 * 1 待服务---》 任务信息 联系方式（增加拨打电话） 订单信息（增加待服务状态） 底部按钮为出发
 * 2 上门中---》 任务信息 联系方式（增加拨打电话） 订单信息（增加上门中状态） 底部按钮为确认到达--》点击到达后变为扫前准备--》点击跳转
 * 3 服务中---》 任务信息 联系方式（增加拨打电话） 订单信息（增加服务中状态） 底部按钮为完成服务--》点击后跳转
 * 4 售后单---》 售后状态信息 任务信息 联系方式（增加拨打电话） 订单信息（增加售后中状态）补退款 扫前准备 扫后记录 没有底部按钮
 *
 * @author liyl
 */
public class TaskDetailsActivity extends BaseActivity<TaskDetailsActivityPresenter> implements TaskDetailsActivityContract {

    @BindView(R.id.tv_after_sate_title)
    TextView tvAfterSateTitle;
    @BindView(R.id.tv_after_sate_time)
    TextView tvAfterSateTime;
    @BindView(R.id.tv_after_sate_reason_title)
    TextView tvAfterSateReasonTitle;
    @BindView(R.id.tv_after_sate_reason)
    TextView tvAfterSateReason;
    @BindView(R.id.tv_after_sate_supplement)
    TextView tvAfterSateSupplement;
    @BindView(R.id.tv_after_sate_line)
    TextView tvAfterSateLine;
    @BindView(R.id.tv_after_sate_time_2)
    TextView tvAfterSateTime2;
    @BindView(R.id.tv_after_sate_agree)
    TextView tvAfterSateAgree;
    @BindView(R.id.tv_after_sate_explain)
    TextView tvAfterSateExplain;
    @BindView(R.id.tv_after_sate_line_2)
    TextView tvAfterSateLine2;
    @BindView(R.id.tv_after_sate_time_3)
    TextView tvAfterSateTime3;
    @BindView(R.id.tv_task_info_title)
    TextView tvTaskInfoTitle;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_bei_zhu)
    TextView tvBeiZhu;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_ju_li)
    TextView tvJuLi;
    @BindView(R.id.tv_go_navigation)
    TextView tvGoNavigation;
    @BindView(R.id.tv_contact_information_title)
    TextView tvContactInformationTitle;
    @BindView(R.id.tv_contact_information_name)
    TextView tvContactInformationName;
    @BindView(R.id.tv_contact_information_mobile)
    TextView tvContactInformationMobile;
    @BindView(R.id.tv_contact_information_call_mobile)
    TextView tvContactInformationCallMobile;
    @BindView(R.id.tv_contact_information_bei_zhu)
    TextView tvContactInformationBeiZhu;
    @BindView(R.id.tv_order_info_title)
    TextView tvOrderInfoTitle;
    @BindView(R.id.tv_order_info_service_status)
    TextView tvOrderInfoServiceStatus;
    @BindView(R.id.tv_order_info_name)
    TextView tvOrderInfoName;
    @BindView(R.id.tv_order_info_price)
    TextView tvOrderInfoPrice;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    private int orderStatus;
    private String orderId;
    private PopTip popPermissionsTip;
    private PopTip popTip;
    private String lat;
    private String lon;
    private String contactAddress;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_task_details;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "任务详情");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            orderId = intent.getStringExtra("orderId");
            mPresenter.taskInfoId(orderId);
        }
        tvGoNavigation.setBackground(ShapeUtils.getDiyGradientDrawable(R.color.white, 0, ConvertUtils.dp2px(1), R.color.color_4986FA));
        tvContactInformationCallMobile.setBackground(ShapeUtils.getDiyGradientDrawable(R.color.white, 0, ConvertUtils.dp2px(1), R.color.color_F6B351));
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void returnTaskDetail(TaskDetailsBean taskDetailsBean) {
        if (taskDetailsBean != null) {
            lat = taskDetailsBean.getLat();
            lon = taskDetailsBean.getLon();
            orderStatus = Integer.parseInt(taskDetailsBean.getOrderStatus());
            //任务信息地址
            contactAddress = taskDetailsBean.getContactAddress();
            tvAddress.setText(contactAddress);
            //日常保洁那一行
            String serviceName = taskDetailsBean.getServiceName();
            if (StringUtils.isEmpty(serviceName)) {
                tvBeiZhu.setText("属性：" + taskDetailsBean.getServiceProperty());
            } else {
                tvBeiZhu.setText(serviceName + "  属性：" + taskDetailsBean.getServiceProperty());
            }
            //任务日期时间
            tvTime.setText(taskDetailsBean.getServiceTime());
            //距离
            distanceSearch(tvJuLi);
            //姓名
            tvContactInformationName.setText(taskDetailsBean.getContacts());
            //电话
            tvContactInformationMobile.setText(taskDetailsBean.getContactNo());
            //特殊备注
            tvContactInformationBeiZhu.setText(StringUtils.isEmpty(taskDetailsBean.getSpecialRequest()) ? "暂无备注" : taskDetailsBean.getSpecialRequest());
            //订单编号
            tvOrderInfoName.setText(taskDetailsBean.getOrderNo());
            //订单价格
            tvOrderInfoPrice.setText(taskDetailsBean.getServicePrice() + "元");
            tvOrderInfoServiceStatus.setText(getOrderStatusString(Integer.parseInt(taskDetailsBean.getOrderStatus())));
            tvContactInformationCallMobile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] permissions = {Manifest.permission.CALL_PHONE};
                    Disposable subscribe = new RxPermissions(TaskDetailsActivity.this).requestEach(permissions)
                            .subscribe(aBoolean -> {
                                if (aBoolean.granted) {
                                    callPhone(taskDetailsBean.getContactNo());
                                } else if (aBoolean.shouldShowRequestPermissionRationale) {
                                    callPhone(taskDetailsBean.getContactNo());
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
                                                    Uri uri = Uri.fromParts("package", TaskDetailsActivity.this.getPackageName(), null);
                                                    intent.setData(uri);
                                                    startActivity(intent);
                                                    popPermissionsTip.dismiss();
                                                }
                                            }).build(TaskDetailsActivity.this);
                                }
                            });
                }
            });

            String orderString = getOrderString(orderStatus);
            tvSubmit.setVisibility(StringUtils.isEmpty(orderString) ? View.GONE : View.VISIBLE);
            tvSubmit.setText(orderString);
        }
    }

    private String getOrderString(int intOrderStatus) {
        // 0新任务，1待服务，[2显示确认到达,3显示待客户确认,4显示扫前准备]2，3，4上门中，
        // [5显示确认完成，6显示待用户确认]5，6服务中，8售后，7已完成，9已取消
        String intOrderStatusString = "";
        switch (intOrderStatus) {
            case 0: {
                intOrderStatusString = "接单";
            }
            break;
            case 1: {
                intOrderStatusString = "出发";
            }
            break;
            case 2: {
                intOrderStatusString = "确认到达";
            }
            break;
            case 3: {
                //待用户确认
                intOrderStatusString = "";
            }
            break;
            case 4: {
                intOrderStatusString = "扫前准备";
            }
            break;
            case 5: {
                //点击跳转扫后拍照
                intOrderStatusString = "完成服务";
            }
            break;
            default:
        }
        return intOrderStatusString;
    }

    private void distanceSearch(TextView tvJuLi) {
        String userLon = SPUtils.getInstance().getString(GlobalApp.USER_LONGITUDE, "0");
        String userLat = SPUtils.getInstance().getString(GlobalApp.USER_LATITUDE, "0");
        LatLonPoint start = new LatLonPoint(Double.parseDouble(userLat), Double.parseDouble(userLon));
        LatLonPoint dest = new LatLonPoint(Double.parseDouble(lat), Double.parseDouble(lon));
        DistanceSearch distanceSearch = new DistanceSearch(TaskDetailsActivity.this);
        distanceSearch.setDistanceSearchListener(new DistanceSearch.OnDistanceSearchListener() {
            @Override
            public void onDistanceSearched(DistanceResult distanceResult, int i) {
                float distance = distanceResult.getDistanceResults().get(0).getDistance();
                if (distance > 1000) {
                    distance = distance / 1000;
                    tvJuLi.setText(distance + "km");
                }else{
                    tvJuLi.setText(distance + "m");
                }
            }
        });
        //设置起点和终点，其中起点支持多个
        List<LatLonPoint> latLonPoints = new ArrayList<LatLonPoint>();
        latLonPoints.add(start);
        DistanceSearch.DistanceQuery distanceQuery = new DistanceSearch.DistanceQuery();
        distanceQuery.setOrigins(latLonPoints);
        distanceQuery.setDestination(dest);
        //设置测量方式，支持直线和驾车
        distanceQuery.setType(DistanceSearch.TYPE_DRIVING_DISTANCE);
        distanceSearch.calculateRouteDistanceAsyn(distanceQuery);
    }

    @OnClick({R.id.tv_submit, R.id.tv_go_navigation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_go_navigation: {
                String userLon = SPUtils.getInstance().getString(GlobalApp.USER_LONGITUDE, "0");
                String userLat = SPUtils.getInstance().getString(GlobalApp.USER_LATITUDE, "0");
                Poi start = new Poi("当前位置", new LatLng(Double.parseDouble(userLat), Double.parseDouble(userLon)), "");
                /**终点传入的是北京站坐标,但是POI的ID "B000A83M61"对应的是北京西站，所以实际算路以北京西站作为终点**/
                Poi end = new Poi(contactAddress, new LatLng(Double.parseDouble(lat), Double.parseDouble(lon)), "");
                AmapNaviParams amapNaviParams = new AmapNaviParams(start, null, end, AmapNaviType.DRIVER);
                amapNaviParams.setUseInnerVoice(true).setMultipleRouteNaviMode(true).setNeedCalculateRouteWhenPresent(true);
                AmapNaviPage.getInstance().showRouteActivity(this, amapNaviParams, new INaviInfoCallback() {
                    @Override
                    public void onInitNaviFailure() {

                    }

                    @Override
                    public void onGetNavigationText(String s) {

                    }

                    @Override
                    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {

                    }

                    @Override
                    public void onArriveDestination(boolean b) {

                    }

                    @Override
                    public void onStartNavi(int i) {

                    }

                    @Override
                    public void onCalculateRouteSuccess(int[] ints) {

                    }

                    @Override
                    public void onCalculateRouteFailure(int i) {

                    }

                    @Override
                    public void onStopSpeaking() {

                    }

                    @Override
                    public void onReCalculateRoute(int i) {

                    }

                    @Override
                    public void onExitPage(int i) {

                    }

                    @Override
                    public void onStrategyChanged(int i) {

                    }

                    @Override
                    public View getCustomNaviBottomView() {
                        return null;
                    }

                    @Override
                    public View getCustomNaviView() {
                        return null;
                    }

                    @Override
                    public void onArrivedWayPoint(int i) {

                    }

                    @Override
                    public void onMapTypeChanged(int i) {

                    }

                    @Override
                    public View getCustomMiddleView() {
                        return null;
                    }

                    @Override
                    public void onNaviDirectionChanged(int i) {

                    }

                    @Override
                    public void onDayAndNightModeChanged(int i) {

                    }

                    @Override
                    public void onBroadcastModeChanged(int i) {

                    }

                    @Override
                    public void onScaleAutoChanged(boolean b) {

                    }
                });
            }
            break;
            case R.id.tv_submit: {
                Bundle bundle = new Bundle();
                bundle.putString("orderId", orderId);
                bundle.putString("orderStatus", orderStatus + "");
                // //订单状态：0待接单,1待服务,2上门中,3保洁员确认，4用户确认，5服务中,6保洁员扫后确认，7用户确认已完成，8售后单,9已取消
                switch (orderStatus) {
                    case 0: {
                        //接单"
                        goNext("接单确认", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                canCelPop();
                                mPresenter.taskReceive(orderId + "");
                            }
                        });
                    }
                    break;
                    case 1: {
                        //出发
                        goNext("是否确认出发", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                canCelPop();
                                mPresenter.taskGo(orderId + "");
                            }
                        });
                    }
                    break;
                    case 2: {
                        //确认到达 -- 变成扫前准备
                        goNext("是否确认到达", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                canCelPop();
                                mPresenter.arrive(orderId + "");

                            }
                        });
                    }
                    break;
                    case 4: {
                        //扫前准备
                        bundle.putBoolean("isBefore", true);
                        UiUtil.openActivity(TaskDetailsActivity.this, WorkReadyActivity.class, bundle);
                    }
                    break;
                    case 5: {
                        //完成服务
                        bundle.putBoolean("isBefore", false);
                        goNext("确认完成服务", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                canCelPop();
                                UiUtil.openActivity(TaskDetailsActivity.this, WorkReadyActivity.class, bundle);
                            }
                        });
                    }

                    break;
                    default:
                }
            }
            break;
            default:
        }
    }

    private void canCelPop() {
        if (popTip != null) {
            popTip.dismiss();
        }
    }

    private void goNext(String msg, View.OnClickListener onClickListener) {
        popTip = new PopTip.Builder()
                .setType(2)
                .setMsg(msg)
                .setSubmitClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popTip.dismiss();
                    }
                }).setCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popTip.dismiss();
                    }
                })
                .setYesClickListener(onClickListener)
                .build(TaskDetailsActivity.this);
        popTip.showPopupWindow();
    }


    @Override
    public void returnTaskReceive(String s) {


    }

    private int getOrderStatus(String title) {
        int intOrderStatus = 0;
        switch (title) {
            case "新任务": {
                intOrderStatus = 0;
            }
            break;
            case "待服务": {
                intOrderStatus = 1;
            }
            break;
            case "上门中": {
                intOrderStatus = 2;
            }
            break;
            case "服务中": {
                intOrderStatus = 5;
            }
            break;
            case "售后单": {
                intOrderStatus = 8;
            }
            break;
            case "已完成": {
                intOrderStatus = 7;
            }
            break;
            case "已取消": {
                intOrderStatus = 9;
            }
            break;
            default:
        }
        return intOrderStatus;
    }

    private String getOrderStatusString(int orderStatus) {
        // 0新任务，1待服务，[2显示确认到达,3显示待客户确认,4显示扫前准备]2，3，4上门中，
        // [5显示确认完成，6显示待用户确认]5，6服务中，8售后，7已完成，9已取消
        String orderStatusString = "";
        switch (orderStatus) {
            case 0: {
                orderStatusString = "新任务";
            }
            break;
            case 1: {
                orderStatusString = "待服务";
            }
            break;
            case 2: {
                orderStatusString = "确认到达";
            }
            break;
            case 3: {
                orderStatusString = "待客户确认";
            }
            break;
            case 4: {
                orderStatusString = "扫前准备";
            }
            break;
            case 5: {
                orderStatusString = "确认完成";
            }
            break;
            case 6: {
                orderStatusString = "服务中";
            }
            break;
            case 7: {
                orderStatusString = "已完成";
            }
            break;
            case 8: {
                orderStatusString = "售后";
            }
            break;
            case 9: {
                orderStatusString = "取消";
            }
            break;
            default:
        }
        return orderStatusString;
    }


    /**
     * 打电话
     */
    private void callPhone(final String phone) {
        popTip = new PopTip.Builder().
                setType(2).
                setTitle("提示").
                setMsg("确定拨打电话" + phone + "?").
                setSubmitClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popTip.dismiss();
                    }
                }).
                setCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popTip.dismiss();
                    }
                }).
                setYesClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        Uri data = Uri.parse("tel:" + phone);
//                        Uri data = Uri.parse("tel:15733125211"  );
                        intent.setData(data);
                        //不影响程序的运行
                        if (ActivityCompat.checkSelfPermission(TaskDetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        startActivity(intent);
                        popTip.dismiss();
                    }
                }).build(TaskDetailsActivity.this);
        popTip.showPopupWindow();
    }


}

