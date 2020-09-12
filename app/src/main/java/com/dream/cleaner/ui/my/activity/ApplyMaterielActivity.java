package com.dream.cleaner.ui.my.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.blankj.utilcode.util.StringUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.ApplyMaterielBean;
import com.dream.cleaner.beans.my.MaterielBean;
import com.dream.cleaner.beans.my.MaterielTypeBean;
import com.dream.cleaner.ui.my.contract.ApplyMaterielContract;
import com.dream.cleaner.ui.my.presenter.ApplyMaterielPresenter;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.ToolbarBackTitle;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author : liyl
 * date   : 2020/8/26
 * desc   :申请物料界面&物料详情界面
 */
public class ApplyMaterielActivity extends BaseActivity<ApplyMaterielPresenter> implements ApplyMaterielContract {
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
    private String id;
    /**
     * 1 详情
     * 2 申请
     */
    private String type;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_apply_materiel;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "申请物料");
    }


    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        if (getIntent() != null) {
            Intent intent = getIntent();
            id = intent.getStringExtra("id");
            type = intent.getStringExtra("type");
            if ("1".equals(type)) {
                //详情
                mPresenter.materielApplyInfoId(id);
            }
            tvSubmit.setVisibility("1".equals(type) ? View.GONE : View.VISIBLE);
            clApplyEditInfo.setVisibility("2".equals(type) ? View.VISIBLE : View.GONE);
        }
    }


    @OnClick({R.id.tv_new_people, R.id.tv_routine, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_new_people:
                break;
            case R.id.tv_routine:
                break;
            case R.id.tv_submit:
                if ("1".equals(type)) {
                    //立即领取
                    mPresenter.collectId(id);
                } else {
                    //申请

                }
                break;
            default:
        }
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void returnMaterielBean(MaterielBean materielBean) {
        //审批状态；1->待审批；2->审核通过；3->拒绝；
        int status = materielBean.getStatus();
        String statusString = "";
        if (status == 1) {
            statusString = "待审批";
            tvSubmit.setVisibility(View.GONE);
        } else if (status == 2) {
            statusString = "审核通过";
            tvSubmit.setText("立即领取");
            tvSubmit.setVisibility(View.VISIBLE);
        } else if (status == 3) {
            statusString = "拒绝";
            tvSubmit.setVisibility(View.GONE);
        }
        tvMaterielId.setText("申请编号：" + materielBean.getApplyNo());
        String applyType = materielBean.getApplyType();
        //01  新人物料，  02常规物料
        if ("01".equals(applyType)) {
            applyType = "新人物料";
        } else if ("02".equals(applyType)) {
            applyType = "常规物料";
        }
        tvMaterielType.setText("物料类型：" + applyType);
        tvMaterielCollectTime.setText("领用时间：" + materielBean.getCollectTime());
        tvMaterielCollectNum.setText("领用数量：" + materielBean.getApplyNums() + "套");
        tvApplyStates.setText("审批状态：" + statusString);
        if (StringUtils.isEmpty(materielBean.getCollectTime())) {
            tvMaterielCollectTime.setVisibility(View.GONE);
            tvCollectStates.setText("领用状态：未领取");
        } else {
            tvMaterielCollectTime.setVisibility(View.VISIBLE);
            tvCollectStates.setText("领用状态：已领取");
            tvSubmit.setVisibility(View.GONE);
        }

    }

    @Override
    public void returnCollect(String string) {

    }

    @Override
    public void returnApplyMaterielBean(String s) {

    }

    @Override
    public void returnMaterielTypeBeans(List<MaterielTypeBean> list) {


    }
}
