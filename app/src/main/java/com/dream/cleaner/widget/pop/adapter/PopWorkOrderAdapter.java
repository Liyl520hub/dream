package com.dream.cleaner.widget.pop.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.workorder.PopWorkOrderBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :工单pop适配器
 */
public class PopWorkOrderAdapter extends BaseQuickAdapter<PopWorkOrderBean, BaseViewHolder> {
    private boolean isOrderType;

    public PopWorkOrderAdapter(@Nullable List<PopWorkOrderBean> data, boolean isOrderType) {
        super(R.layout.pop_item_work_order, data);
        this.isOrderType = isOrderType;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, PopWorkOrderBean popWorkOrderBean) {
        if (isOrderType) {
            baseViewHolder.setText(R.id.tv_name, popWorkOrderBean.getName());
        }else{
            baseViewHolder.setText(R.id.tv_name, popWorkOrderBean.getCategoryName());
        }
    }
}
