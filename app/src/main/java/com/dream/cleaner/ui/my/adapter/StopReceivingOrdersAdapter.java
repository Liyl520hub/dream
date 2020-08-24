package com.dream.cleaner.ui.my.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.StopReceivingOrdersBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author : liyl
 * date   : 2020/8/24
 * desc   :
 */
public class StopReceivingOrdersAdapter extends BaseQuickAdapter<StopReceivingOrdersBean,BaseViewHolder> {

    public StopReceivingOrdersAdapter(@Nullable List<StopReceivingOrdersBean> data) {
        super(R.layout.item_stop_receiving_orders, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, StopReceivingOrdersBean stopReceivingOrdersBean) {

    }
}
