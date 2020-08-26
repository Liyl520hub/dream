package com.dream.cleaner.ui.my.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.ApplyMaterielBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author : liyl
 * date   : 2020/8/26
 * desc   :申请物料列表适配器
 */
public class ApplyMaterielAdapter extends BaseQuickAdapter<ApplyMaterielBean,BaseViewHolder> {

    public ApplyMaterielAdapter(@Nullable List<ApplyMaterielBean> data) {
        super(R.layout.item_apply_materiel, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ApplyMaterielBean stopReceivingOrdersBean) {

    }
}
