package com.dream.cleaner.ui.my;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.MyOrderListBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author : liyl
 * date   : 2020/8/23
 * desc   :我的工单列表bean
 */
public class MyOrderListAdapter extends BaseQuickAdapter<MyOrderListBean, BaseViewHolder> {
    public MyOrderListAdapter(@Nullable List<MyOrderListBean> data) {
        super(R.layout.item_my_order_list, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, MyOrderListBean myIncomeBean) {

    }
}
