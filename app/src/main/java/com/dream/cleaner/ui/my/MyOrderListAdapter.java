package com.dream.cleaner.ui.my;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.MyIncomeListBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author : liyl
 * date   : 2020/8/23
 * desc   :我的工单列表bean
 */
public class MyOrderListAdapter extends BaseQuickAdapter<MyIncomeListBean.RecordsBean, BaseViewHolder> {
    public MyOrderListAdapter(@Nullable List<MyIncomeListBean.RecordsBean> data) {
        super(R.layout.item_my_order_list, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, MyIncomeListBean.RecordsBean item) {
        baseViewHolder.setText(R.id.tv_order_id,item.getOrderNo() );
        baseViewHolder.setText(R.id.tv_order_time,item.getServiceTime());
        baseViewHolder.setText(R.id.tv_server_type,item.getServiceTypeName() );
        baseViewHolder.setText(R.id.tv_order_price,item.getServicePrice()+"元" );
    }
}
