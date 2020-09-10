package com.dream.cleaner.ui.main.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.workorder.WorkOrderTabBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * author : liyl
 * date   : 2020/8/20
 * desc   : 工单各个tab标签下rv数据适配器
 * @author joy
 */
public class WorkOrderTabFragmentAdapter extends BaseQuickAdapter<WorkOrderTabBean.RecordsBean, BaseViewHolder> {
    public WorkOrderTabFragmentAdapter(@Nullable List<WorkOrderTabBean.RecordsBean> data) {
        super(R.layout.item_work_order_tab, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, WorkOrderTabBean.RecordsBean workOrderTabBean) {
        //赋值
        baseViewHolder.setText(R.id.tv_order_type,workOrderTabBean.getOrderStatusStr());
        baseViewHolder.setText(R.id.tv_address,workOrderTabBean.getContactAddress());
        baseViewHolder.setText(R.id.tv_time,workOrderTabBean.getServiceTime());
        baseViewHolder.setText(R.id.tv_order_price,workOrderTabBean.getServicePrice()+"元");
        baseViewHolder.setText(R.id.tv_bei_zhu,workOrderTabBean.getServiceProperty());
    }
}
