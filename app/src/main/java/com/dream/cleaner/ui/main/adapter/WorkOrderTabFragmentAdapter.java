package com.dream.cleaner.ui.main.adapter;

import android.view.View;
import android.widget.TextView;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.workorder.WorkOrderTabBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * author : liyl
 * date   : 2020/8/20
 * desc   : 工单各个tab标签下rv数据适配器
 *
 * @author joy
 */
public class WorkOrderTabFragmentAdapter extends BaseQuickAdapter<WorkOrderTabBean.RecordsBean, BaseViewHolder> {
    public WorkOrderTabFragmentAdapter(@Nullable List<WorkOrderTabBean.RecordsBean> data) {
        super(R.layout.item_work_order_tab, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, WorkOrderTabBean.RecordsBean workOrderTabBean) {
        //赋值
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
//        double i = Double.parseDouble(distance);
//        String formatDistance = i + "m";
//        if (i > 1000) {
//            double doubleDistance = i / 1000.0;
//            formatDistance = doubleDistance + "km";
//        }
//        tvJuLi.setText(formatDistance);

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
