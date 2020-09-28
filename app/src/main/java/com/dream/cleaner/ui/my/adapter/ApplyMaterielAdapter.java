package com.dream.cleaner.ui.my.adapter;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.ApplyMaterielBean;
import com.dream.cleaner.utils.ShapeUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author : liyl
 * date   : 2020/8/26
 * desc   :申请物料列表适配器
 */
public class ApplyMaterielAdapter extends BaseQuickAdapter<ApplyMaterielBean.RecordsBean, BaseViewHolder> {

    public ApplyMaterielAdapter(@Nullable List<ApplyMaterielBean.RecordsBean> data) {
        super(R.layout.item_apply_materiel, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ApplyMaterielBean.RecordsBean item) {
        TextView tvStates = baseViewHolder.getView(R.id.tv_states);
        //审批状态；1->待审批；2->审核通过；3->拒绝；
        String status = item.getStatus();
        String statusString = "";
        int color = R.color.color_72BB38;
        if ("1".equals(status)) {
            statusString = "待审批";
            color = R.color.color_4986FA;
        } else if ("2".equals(status)) {
            statusString = "审核通过";
            color = R.color.color_72BB38;
        } else if ("3".equals(status)) {
            statusString = "拒绝";
            color = R.color.color_C50000;
        }
        baseViewHolder.setText(R.id.tv_materiel_id, "申请编号：" + item.getApplyNo());
        baseViewHolder.setText(R.id.tv_materiel_type, "物料类型：" + item.getApplyTypeName());
        baseViewHolder.setText(R.id.tv_apply_time, "申请时间：" + item.getApplyTime());
        tvStates.setText(statusString);
        tvStates.setTextColor(ShapeUtils.getColor(color));
        //拒绝的话 填写拒绝原因
        baseViewHolder.setText(R.id.tv_reason, "拒绝理由：" + item.getAuditReason());
    }
}
