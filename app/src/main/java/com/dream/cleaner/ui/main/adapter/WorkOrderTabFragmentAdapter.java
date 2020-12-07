package com.dream.cleaner.ui.main.adapter;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.workorder.WorkOrderTabBean;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.cleaner.widget.pop.PopTip;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * author : liyl
 * date   : 2020/8/20
 * desc   : 工单各个tab标签下rv数据适配器
 *
 * @author joy
 */
public class WorkOrderTabFragmentAdapter extends BaseQuickAdapter<WorkOrderTabBean.RecordsBean, BaseViewHolder> {

    private PopTip popTip;

    public WorkOrderTabFragmentAdapter(@Nullable List<WorkOrderTabBean.RecordsBean> data) {
        super(R.layout.item_work_order_tab, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, WorkOrderTabBean.RecordsBean workOrderTabBean) {
        //赋值
        String cycleFlag = workOrderTabBean.getCycleFlag();
        baseViewHolder.setText(R.id.tv_order_type_imge, "0".equals(cycleFlag) ? "单次单" : "周期服务单");
        baseViewHolder.setText(R.id.tv_order_type, workOrderTabBean.getOrderStatusStr());
        baseViewHolder.setText(R.id.tv_address, workOrderTabBean.getContactAddress());
        baseViewHolder.setText(R.id.tv_time, workOrderTabBean.getServiceTime());
        baseViewHolder.setText(R.id.tv_order_price, workOrderTabBean.getServicePrice() + "元");
        String serviceItemsName = workOrderTabBean.getServiceItemsName();
        if (StringUtils.isEmpty(serviceItemsName)) {
            baseViewHolder.setText(R.id.tv_bei_zhu, "属性：" + workOrderTabBean.getServiceProperty());
        } else {
            baseViewHolder.setText(R.id.tv_bei_zhu, serviceItemsName + "  属性：" + workOrderTabBean.getServiceProperty());
        }
        TextView tvJuLi = baseViewHolder.getView(R.id.tv_ju_li);
        TextView tvSubmit = baseViewHolder.getView(R.id.tv_submit);
        //订单状态：0待接单,1待服务,2上门中,3保洁员确认，4用户确认，5服务中,6保洁员扫后确认，7用户确认已完成，8售后单,9已取消
        int orderStatus = Integer.parseInt(workOrderTabBean.getOrderStatus());
        String orderString = getOrderString(orderStatus);
        tvSubmit.setVisibility(StringUtils.isEmpty(orderString) ? View.GONE : View.VISIBLE);
        tvSubmit.setText(orderString);
        String distance = workOrderTabBean.getDistance();
        tvJuLi.setText(distance + "km");
        TextView tvGoNavigation = baseViewHolder.getView(R.id.tv_go_navigation);
        TextView tvContactInformationName = baseViewHolder.getView(R.id.tv_contact_information_name);
        TextView tvContactInformationCallMobile = baseViewHolder.getView(R.id.tv_contact_information_call_mobile);
        //待服务和上门中显示导航跟打电话按钮
        tvContactInformationName.setText(workOrderTabBean.getContacts() + "  " + workOrderTabBean.getContactNo() + "  ");
        if (orderStatus == 2 || orderStatus == 3 || orderStatus == 4) {
            tvGoNavigation.setBackground(ShapeUtils.getDiyGradientDrawable(R.color.white, 0, ConvertUtils.dp2px(1), R.color.color_4986FA));
            tvContactInformationCallMobile.setBackground(ShapeUtils.getDiyGradientDrawable(R.color.white, 0, ConvertUtils.dp2px(1), R.color.color_F6B351));
            tvGoNavigation.setVisibility(View.VISIBLE);
            tvContactInformationName.setVisibility(View.VISIBLE);
            tvContactInformationCallMobile.setVisibility(View.VISIBLE);
        } else {
            if (orderStatus == 5 || orderStatus == 6) {
                tvContactInformationName.setVisibility(View.VISIBLE);
            } else {
                tvContactInformationName.setVisibility(View.GONE);
            }
            tvGoNavigation.setVisibility(View.GONE);
            tvContactInformationCallMobile.setVisibility(View.GONE);
        }
        //控制星级评价
        TextView tvZongTiPingJia = baseViewHolder.getView(R.id.tv_zong_ti_ping_jia);
        TextView tvPingJia = baseViewHolder.getView(R.id.tv_ping_jia);
        RatingBar rbStar1 = baseViewHolder.getView(R.id.rb_star_1);
        RatingBar rbStar2 = baseViewHolder.getView(R.id.rb_star_2);
        tvZongTiPingJia.setVisibility(orderStatus == 7 ? View.VISIBLE : View.GONE);
        tvPingJia.setVisibility(orderStatus == 7 ? View.VISIBLE : View.GONE);
        rbStar1.setVisibility(orderStatus == 7 ? View.VISIBLE : View.GONE);
        rbStar2.setVisibility(orderStatus == 7 ? View.VISIBLE : View.GONE);
        if (orderStatus == 7) {
            WorkOrderTabBean.RecordsBean.PmsServiceEvaluation pmsServiceEvaluation = workOrderTabBean.getPmsServiceEvaluation();
            String serviceScore = pmsServiceEvaluation.getServiceScore();
            String cleanerScore = pmsServiceEvaluation.getCleanerScore();
            rbStar1.setRating(Integer.parseInt(serviceScore));
            rbStar2.setRating(Integer.parseInt(cleanerScore));
        }
        baseViewHolder.getView(R.id.tv_no_pay_status).setVisibility(workOrderTabBean.getCycleNoPayStatus().equals("1") ? View.VISIBLE : View.GONE);

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


}
