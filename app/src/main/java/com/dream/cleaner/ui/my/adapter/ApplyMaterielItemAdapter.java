package com.dream.cleaner.ui.my.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ResourceUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.ApplyMaterielBean;
import com.dream.cleaner.beans.my.MaterielBean;
import com.dream.cleaner.beans.my.MaterielTypeBean;
import com.dream.cleaner.utils.ShapeUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author : liyl
 * date   : 2020/8/26
 * desc   :申请物料明细适配器
 */
public class ApplyMaterielItemAdapter extends BaseQuickAdapter<MaterielTypeBean, BaseViewHolder> {
    private boolean isDetail;
    private boolean isNew;

    public ApplyMaterielItemAdapter(@Nullable List<MaterielTypeBean> data, boolean isDetail,boolean isNew) {
        super(R.layout.item_materiel_info, data);
        this.isDetail = isDetail;
        this.isNew = isNew;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, MaterielTypeBean item) {
        TextView textView = baseViewHolder.getView(R.id.tv_materiel_num);
        textView.setText(item.getMaterielName());
        EditText editText = baseViewHolder.getView(R.id.et_ma_bu_num);
        //是查看详情  不可编辑 取值getApplyNum
        if (isDetail) {
            editText.setBackground(null);
            editText.setFocusable(false);
            editText.setClickable(false);
            editText.setText(item.getApplyNum() + "");
        } else {
            //不是查看详情 且 是新人 不可编辑 取值 defaultBase
            if (isNew) {
                editText.setBackground(null);
                editText.setFocusable(false);
                editText.setClickable(false);
                editText.setText(item.getDefaultBase() + "");
            }else {
                editText.setClickable(true);
                editText.setBackground(ResourceUtils.getDrawable(R.drawable.login_bg_edit_text));
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        item.setApplyNum(s.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
        }
    }

    /**
     * @return 获取物料id和输入的数量
     */
    public JsonArray getMaterielItem() {
        JsonArray jsonArray = new JsonArray();
        List<MaterielTypeBean> data = getData();
        int size = data.size();
        for (int i = 0; i < size; i++) {
            MaterielTypeBean materielTypeBean = data.get(i);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("applyNum", materielTypeBean.getApplyNum());
            jsonObject.addProperty("materielId", materielTypeBean.getId());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
