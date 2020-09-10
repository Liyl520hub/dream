package com.dream.cleaner.ui.plan.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.PlanBean;
import com.dream.cleaner.beans.PlanSectionBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author : Liyalei
 * date   : 2020/9/1
 * desc   :
 */
public class PlanFragmentAdapter extends BaseSectionQuickAdapter<PlanSectionBean, BaseViewHolder> {


    public PlanFragmentAdapter(@Nullable List<PlanSectionBean> data) {
        super(R.layout.item_plan_fragment_header, data);
        // 设置普通item布局（如果item类型只有一种，使用此方法）
        setNormalLayout(R.layout.item_plan_fragment);
    }

    @Override
    protected void convertHeader(@NotNull BaseViewHolder baseViewHolder, @NotNull PlanSectionBean planSectionBean) {
        baseViewHolder.setText(R.id.tv_data, planSectionBean.header);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, PlanSectionBean planSectionBean) {
        PlanBean.CleanerPlanItemsBean item = (PlanBean.CleanerPlanItemsBean) planSectionBean.getItem();
        //1为订单，2为请假
        int type = item.getType();
        if (type != 0) {
            baseViewHolder.setText(R.id.tv_content, item.getType() == 1 ? "订单" : "请假");
        }


    }
}
