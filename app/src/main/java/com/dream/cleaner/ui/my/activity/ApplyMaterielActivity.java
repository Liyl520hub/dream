package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.dream.cleaner.R;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarBackTitle;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author : liyl
 * date   : 2020/8/26
 * desc   :申请物料
 */
public class ApplyMaterielActivity extends BaseActivity {
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_materiel_edit_type)
    TextView tvMaterielEditType;
    @BindView(R.id.tv_new_people)
    TextView tvNewPeople;
    @BindView(R.id.tv_routine)
    TextView tvRoutine;
    @BindView(R.id.tv_collect_time_title)
    TextView tvCollectTimeTitle;
    @BindView(R.id.tv_collect_time)
    TextView tvCollectTime;
    @BindView(R.id.ll_collect_time)
    LinearLayout llCollectTime;
    @BindView(R.id.tv_collect_num_title)
    TextView tvCollectNumTitle;
    @BindView(R.id.tv_collect_num)
    TextView tvCollectNum;
    @BindView(R.id.ll_collect_num)
    LinearLayout llCollectNum;
    @BindView(R.id.cl_apply_edit_info)
    ConstraintLayout clApplyEditInfo;
    @BindView(R.id.tv_materiel_id)
    TextView tvMaterielId;
    @BindView(R.id.tv_materiel_type)
    TextView tvMaterielType;
    @BindView(R.id.tv_materiel_collect_time)
    TextView tvMaterielCollectTime;
    @BindView(R.id.tv_materiel_collect_num)
    TextView tvMaterielCollectNum;
    @BindView(R.id.tv_apply_states)
    TextView tvApplyStates;
    @BindView(R.id.tv_collect_states)
    TextView tvCollectStates;
    @BindView(R.id.cl_apply_info)
    ConstraintLayout clApplyInfo;
    @BindView(R.id.tv_materiel_info_title)
    TextView tvMaterielInfoTitle;
    @BindView(R.id.tv_materiel_name)
    TextView tvMaterielName;
    @BindView(R.id.tv_materiel_num)
    TextView tvMaterielNum;
    @BindView(R.id.tv_ma_bu)
    TextView tvMaBu;
    @BindView(R.id.tv_dun_bu)
    TextView tvDunBu;
    @BindView(R.id.tv_shui_tong)
    TextView tvShuiTong;
    @BindView(R.id.et_ma_bu_num)
    EditText etMaBuNum;
    @BindView(R.id.et_dun_bu_num)
    EditText etDunBuNum;
    @BindView(R.id.et_shui_tong_num)
    EditText etShuiTongNum;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_apply_materiel;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "申请物料");
    }


    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }


    @OnClick({R.id.tv_new_people, R.id.tv_routine, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_new_people:
                break;
            case R.id.tv_routine:
                break;
            case R.id.tv_submit:
                break;
            default:
        }
    }
}
