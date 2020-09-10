package com.dream.cleaner.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.dream.cleaner.R;
import com.dream.cleaner.beans.workorder.TaskDetailsBean;
import com.dream.cleaner.ui.main.contract.TaskDetailsActivityContract;
import com.dream.cleaner.ui.main.presenter.TaskDetailsActivityPresenter;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.ToolbarBackTitle;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    private String title;
    private int orderStatus;
    private String id;

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
            title = intent.getStringExtra("title");
            id = intent.getStringExtra("id");
            orderStatus = getOrderStatus(title);
            mPresenter.taskInfoId(id);
        }
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void returnTaskDetail(TaskDetailsBean taskDetailsBean) {
        if (taskDetailsBean != null) {
            //任务信息地址
            tvAddress.setText(taskDetailsBean.getContactAddress());
            //日常保洁那一行
            tvBeiZhu.setText(taskDetailsBean.getServiceProperty());
            //任务日期时间
            tvTime.setText(taskDetailsBean.getServiceTime());
            //距离
            tvJuLi.setText("2.1KM");
            //姓名
            tvContactInformationName.setText(taskDetailsBean.getContacts());
            //电话
            tvContactInformationMobile.setText(taskDetailsBean.getContactNo());
            //特殊备注
            tvContactInformationBeiZhu.setText(taskDetailsBean.getSpecialRequest());
            //订单编号
            tvOrderInfoName.setText(taskDetailsBean.getOrderNo());
            //订单价格
            tvOrderInfoPrice.setText(taskDetailsBean.getServicePrice() + "元");
            tvOrderInfoServiceStatus.setText(getOrderStatusString(taskDetailsBean.getOrderStatus()));
        }


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

}
