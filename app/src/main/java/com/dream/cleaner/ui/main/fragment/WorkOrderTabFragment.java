package com.dream.cleaner.ui.main.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapNaviParams;
import com.amap.api.navi.AmapNaviType;
import com.blankj.utilcode.util.BusUtils;
import com.blankj.utilcode.util.SPUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.BusBean;
import com.dream.cleaner.beans.workorder.WorkOrderTabBean;
import com.dream.cleaner.ui.main.MyINaviInfoCallback;
import com.dream.cleaner.ui.main.activity.TaskDetailsActivity;
import com.dream.cleaner.ui.main.activity.WorkReadyActivity;
import com.dream.cleaner.ui.main.adapter.WorkOrderTabFragmentAdapter;
import com.dream.cleaner.ui.main.contract.WorkOrderTabFragmentContract;
import com.dream.cleaner.ui.main.presenter.WorkOrderTabFragmentPresenter;
import com.dream.cleaner.utils.LocationUtils;
import com.dream.cleaner.utils.UiUtil;
import com.dream.cleaner.widget.EmptyLayout;
import com.dream.cleaner.widget.pop.PopTip;
import com.dream.common.base.BaseFragment;
import com.dream.common.http.error.ErrorType;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :工单tab
 *
 * @author joy
 */
public class WorkOrderTabFragment extends BaseFragment<WorkOrderTabFragmentPresenter> implements WorkOrderTabFragmentContract {


    @BindView(R.id.my_recyclerview)
    RecyclerView myRecyclerview;
    @BindView(R.id.my_smart_refresh)
    SmartRefreshLayout mySmartRefresh;
    private PopTip popTip;
    private String title;
    private WorkOrderTabFragmentAdapter workOrderTabFragmentAdapter;
    private String orderTypeId = "";
    private String serviceTypeId = "";
    private int page = 1;
    private int pageSize = 10;
    private List<WorkOrderTabBean.RecordsBean> records = new ArrayList<>();
    private PopTip popPermissionsTip;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_order_tab;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected void initView() {
        BusUtils.register(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            title = arguments.getString("title");
        }
        mySmartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                initData(orderTypeId, serviceTypeId);
            }
        }).setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData(orderTypeId, serviceTypeId);
            }
        });
        initAdapter();

    }

    private void initAdapter() {
        workOrderTabFragmentAdapter = new WorkOrderTabFragmentAdapter(records);
        myRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerview.setAdapter(workOrderTabFragmentAdapter);
        EmptyLayout emptyLayout = new EmptyLayout(getActivity());
        emptyLayout.setErrorType(3);
        workOrderTabFragmentAdapter.setEmptyView(emptyLayout);
        workOrderTabFragmentAdapter.addChildClickViewIds(R.id.cl_top, R.id.tv_submit, R.id.tv_go_navigation, R.id.tv_contact_information_call_mobile);
        workOrderTabFragmentAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                WorkOrderTabBean.RecordsBean item = workOrderTabFragmentAdapter.getItem(position);
                int orderStatus = Integer.parseInt(item.getOrderStatus());
                int id = item.getId();
                Bundle bundle = new Bundle();
                bundle.putString("orderId", id + "");
                bundle.putString("orderStatus", orderStatus + "");
                switch (view.getId()) {
                    case R.id.cl_top: {
                        UiUtil.openActivity(getActivity(), TaskDetailsActivity.class, bundle);
                    }
                    break;

                    case R.id.tv_submit: {
                        // //订单状态：0待接单,1待服务,2上门中,3保洁员确认，4用户确认，5服务中,6保洁员扫后确认，7用户确认已完成，8售后单,9已取消
                        switch (orderStatus) {
                            case 0: {
                                //接单"
                                goNext("接单确认", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        canCelPop();
                                        LocationUtils.initLocation(AMapLocationClientOption.AMapLocationPurpose.SignIn, 0, new AMapLocationListener() {
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
                                                        mPresenter.taskReceive(id + "");
                                                    } else {
                                                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                                                        Log.e("AmapError", "location Error, ErrCode:"
                                                                + aMapLocation.getErrorCode() + ", errInfo:"
                                                                + aMapLocation.getErrorInfo());
                                                    }
                                                }
                                            }
                                        });

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
                                        LocationUtils.initLocation(AMapLocationClientOption.AMapLocationPurpose.SignIn, 0, new AMapLocationListener() {
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
                                                        mPresenter.taskGo(id + "");
                                                    } else {
                                                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                                                        Log.e("AmapError", "location Error, ErrCode:"
                                                                + aMapLocation.getErrorCode() + ", errInfo:"
                                                                + aMapLocation.getErrorInfo());
                                                    }
                                                }
                                            }
                                        });

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
                                        LocationUtils.initLocation(AMapLocationClientOption.AMapLocationPurpose.SignIn, 0, new AMapLocationListener() {
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
                                                        mPresenter.arrive(id + "");
                                                    } else {
                                                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                                                        Log.e("AmapError", "location Error, ErrCode:"
                                                                + aMapLocation.getErrorCode() + ", errInfo:"
                                                                + aMapLocation.getErrorInfo());
                                                    }
                                                }
                                            }
                                        });

                                    }
                                });
                            }
                            break;
                            case 4: {
                                //扫前准备
                                bundle.putBoolean("isBefore", true);
                                UiUtil.openActivity(getActivity(), WorkReadyActivity.class, bundle);
                            }
                            break;
                            case 5: {
                                //完成服务
                                bundle.putBoolean("isBefore", false);
                                goNext("确认完成服务", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        canCelPop();
                                        UiUtil.openActivity(getActivity(), WorkReadyActivity.class, bundle);
                                    }
                                });
                            }

                            break;
                            default:
                        }

                    }
                    break;

                    case R.id.tv_contact_information_call_mobile: {
                        goCallPhone(item.getContactNo());
                    }
                    break;
                    case R.id.tv_go_navigation: {
                        String lat = item.getLat();
                        String lon = item.getLon();
                        String userLon = SPUtils.getInstance().getString(GlobalApp.USER_LONGITUDE, "0");
                        String userLat = SPUtils.getInstance().getString(GlobalApp.USER_LATITUDE, "0");
                        Poi start = new Poi("当前位置", new LatLng(Double.parseDouble(userLat), Double.parseDouble(userLon)), "");
                        /**终点传入的是北京站坐标,但是POI的ID "B000A83M61"对应的是北京西站，所以实际算路以北京西站作为终点**/
                        Poi end = new Poi(item.getContactAddress(), new LatLng(Double.parseDouble(lat), Double.parseDouble(lon)), "");
                        AmapNaviParams amapNaviParams = new AmapNaviParams(start, null, end, AmapNaviType.DRIVER);
                        amapNaviParams.setUseInnerVoice(true).setMultipleRouteNaviMode(true).setNeedCalculateRouteWhenPresent(true);
                        AmapNaviPage.getInstance().showRouteActivity(getActivity(), amapNaviParams, new MyINaviInfoCallback());
                    }
                    break;

                    default:
                }


            }


        });
    }


    @Override
    public void onResume() {
        super.onResume();
        if (workOrderTabFragmentAdapter == null) {
            mySmartRefresh.autoRefresh();
        } else {
            if (workOrderTabFragmentAdapter.getData().size() == 0) {
                mySmartRefresh.autoRefresh();
            }
        }
    }

    private void initData(String orderType, String serviceType) {
        orderTypeId = orderType;
        serviceTypeId = serviceType;
        LocationUtils.initLocation(AMapLocationClientOption.AMapLocationPurpose.SignIn, 0, new AMapLocationListener() {
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
                        mPresenter.taskList(page + "", pageSize + "", getOrderStatus(title), orderTypeId, serviceTypeId);
                    } else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError", "location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        });
    }


    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {
        if (page <= 1) {
            mySmartRefresh.finishRefresh();
        } else {
            mySmartRefresh.finishLoadMore();
        }
    }

    @Override
    public void returnTaskList(WorkOrderTabBean workOrderTabBean) {
        List<WorkOrderTabBean.RecordsBean> newRecords = workOrderTabBean.getRecords();
        //刷新
        if (page == 1) {
            workOrderTabFragmentAdapter.setNewInstance(newRecords);
            mySmartRefresh.finishRefresh();
        } else {
            workOrderTabFragmentAdapter.addData(newRecords);
            mySmartRefresh.finishLoadMore();

        }
    }

    private void canCelPop() {
        if (popTip != null) {
            popTip.dismiss();
        }
    }

    @Override
    public void returnTaskReceive(String s) {
        //刷新当前页面
        page = 1;
        pageSize = page * 10;
        initData(orderTypeId, serviceTypeId);
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
                .build(getActivity());
        popTip.showPopupWindow();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        BusUtils.unregister(this);
    }

    @BusUtils.Bus(tag = GlobalApp.BUS_FRAGMENT_WORK_TAB)
    public void postBusListener(BusBean busBean) {
        serviceTypeId = busBean.getServiceTypeId();
        orderTypeId = busBean.getOrderTypeId();
        initData(busBean.getOrderTypeId(), busBean.getServiceTypeId());
    }

    private int getOrderStatus(String title) {
        // 订单状态，查询0新任务，1待服务，2上门中，5服务中，8售后，7已完成，9已取消
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


    private void goCallPhone(String mobile) {

        String[] permissions = {Manifest.permission.CALL_PHONE};
        Disposable subscribe = new RxPermissions(getActivity()).requestEach(permissions)
                .subscribe(aBoolean -> {
                    if (aBoolean.granted) {
                        callPhone(mobile);
                    } else if (aBoolean.shouldShowRequestPermissionRationale) {
                        goCallPhone(mobile);
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
                                        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                                        intent.setData(uri);
                                        startActivity(intent);
                                        popPermissionsTip.dismiss();
                                    }
                                }).build(getActivity());
                    }
                });
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
                        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
                }).build(getActivity());
        popTip.showPopupWindow();
    }

}
