package com.dream.cleaner.ui.my.adapter;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.LeaveBean;
import com.dream.cleaner.utils.ShapeUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author : liyl
 * date   : 2020/8/24
 * desc   :暂停接单列表适配器
 */
public class StopReceivingOrdersAdapter extends BaseQuickAdapter<LeaveBean.RecordsBean, BaseViewHolder> {

    public StopReceivingOrdersAdapter(@Nullable List<LeaveBean.RecordsBean> data) {
        super(R.layout.item_stop_receiving_orders, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, LeaveBean.RecordsBean item) {
        //审批状态；0->待审核；1->通过；2->拒绝；
        int status = item.getStatus();
        String statusString = "";
        int color = R.color.color_72BB38;
        if (status == 0) {
            statusString = "待审核";
            color = R.color.color_4986FA;
        } else if (status == 1) {
            statusString = "通过";
            color = R.color.color_72BB38;
        } else if (status == 2) {
            statusString = "拒绝";
            color = R.color.color_C50000;
        }
        TextView tvStatus = baseViewHolder.getView(R.id.tv_states);
        tvStatus.setText(statusString);
        tvStatus.setTextColor(ShapeUtils.getColor(color));
        baseViewHolder.setText(R.id.tv_start_time,"开始时间："+ item.getStartTime());
        baseViewHolder.setText(R.id.tv_end_time,"结束时间："+  item.getEndTime());
        baseViewHolder.setText(R.id.tv_apply_time, "申请时间："+ item.getCreateTime());


    }
}
