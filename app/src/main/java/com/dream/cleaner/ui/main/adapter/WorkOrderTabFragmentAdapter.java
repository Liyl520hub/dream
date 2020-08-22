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
public class WorkOrderTabFragmentAdapter extends BaseQuickAdapter<WorkOrderTabBean, BaseViewHolder> {
    public WorkOrderTabFragmentAdapter(@Nullable List<WorkOrderTabBean> data) {
        super(R.layout.item_work_order_tab, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, WorkOrderTabBean workOrderTabBean) {
        //赋值
        baseViewHolder.setText(R.id.tv_address,"dddd");
    }
}
