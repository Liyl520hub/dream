package com.dream.cleaner.ui.my.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.ResourceUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.ApplyMaterielBean;
import com.dream.cleaner.beans.my.MaterielBean;
import com.dream.cleaner.beans.my.MaterielTypeBean;
import com.dream.cleaner.ui.my.adapter.ApplyMaterielItemAdapter;
import com.dream.cleaner.ui.my.contract.ApplyMaterielContract;
import com.dream.cleaner.ui.my.presenter.ApplyMaterielPresenter;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.SuperToast;
import com.dream.common.widget.ToolbarBackTitle;
import com.google.gson.JsonArray;

import java.util.Date;
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
    @BindView(R.id.et_collect_num)
    EditText etCollectNum;
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
    @BindView(R.id.rv_item)
    RecyclerView rvItem;
    private String id;
    /**
     * 1 详情
     * 2 申请
     */
    private String type;
    private boolean isNew;
    private ApplyMaterielItemAdapter applyMaterielItemAdapter;

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
            } else {
                //默认获取新人物料
                setMaterielType(true);
            }
            tvSubmit.setVisibility("1".equals(type) ? View.GONE : View.VISIBLE);
            clApplyEditInfo.setVisibility("2".equals(type) ? View.VISIBLE : View.GONE);
            clApplyInfo.setVisibility("2".equals(type) ? View.GONE : View.VISIBLE);
        }
    }

    private void setMaterielType(boolean isNewPeople) {
        isNew = isNewPeople;
        Drawable check = ResourceUtils.getDrawable(R.mipmap.checkbox_login_check);
        check.setBounds(0, 0, check.getMinimumWidth(), check.getMinimumHeight());
        Drawable unCheck = ResourceUtils.getDrawable(R.mipmap.checkbox_login_uncheck);
        unCheck.setBounds(0, 0, unCheck.getMinimumWidth(), unCheck.getMinimumHeight());
        if (isNew) {
            llCollectNum.setVisibility(View.VISIBLE);
            mPresenter.materielList("01");
            tvNewPeople.setCompoundDrawables(check, null, null, null);
            tvRoutine.setCompoundDrawables(unCheck, null, null, null);
        } else {
            llCollectNum.setVisibility(View.GONE);
            tvNewPeople.setCompoundDrawables(unCheck, null, null, null);
            tvRoutine.setCompoundDrawables(check, null, null, null);
            mPresenter.materielList("02");
        }
    }


    @OnClick({R.id.tv_new_people, R.id.tv_routine, R.id.tv_submit, R.id.tv_collect_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_collect_time:
                showTimePickerView();
                break;
            case R.id.tv_new_people:
                setMaterielType(true);
                break;
            case R.id.tv_routine:
                setMaterielType(false);
                break;
            case R.id.tv_submit:
                if ("1".equals(type)) {
                    //立即领取
                    mPresenter.collectId(id);
                } else {
                    //申请
                    String time = tvCollectTime.getText().toString();
                    if (StringUtils.isEmpty(time)) {
                        SuperToast.showShortMessage("请选择领用时间");
                        return;
                    }
                    String num = etCollectNum.getText().toString();
                    if (isNew) {
                        if (StringUtils.isEmpty(num)) {
                            SuperToast.showShortMessage("请输入领取数量");
                            return;
                        }
                    }
                    if (applyMaterielItemAdapter != null) {
                        JsonArray jsonArray = applyMaterielItemAdapter.getMaterielItem();
                        mPresenter.submitMateriel(isNew ? "01" : "02", num, time, jsonArray);
                    }
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
        String status = materielBean.getStatus();
        String statusString = "";
        if ("1".equals(status)) {
            statusString = "待审批";
            tvSubmit.setVisibility(View.GONE);
        } else if ("2".equals(status)) {
            statusString = "审核通过";
            tvSubmit.setText("立即领取");
            tvSubmit.setVisibility(View.VISIBLE);
        } else if ("3".equals(status)) {
            statusString = "拒绝";
            tvSubmit.setVisibility(View.GONE);
        }
        tvMaterielId.setText("申请编号：" + materielBean.getApplyNo());
        String applyType = materielBean.getApplyType();
        //01  新人物料，  02常规物料
        if ("01".equals(applyType)) {
            applyType = "新人物料";
            tvMaterielCollectNum.setVisibility(View.VISIBLE);
        } else if ("02".equals(applyType)) {
            applyType = "常规物料";
            tvMaterielCollectNum.setVisibility(View.GONE);
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
        List<MaterielTypeBean> items = materielBean.getItems();
        ApplyMaterielItemAdapter applyMaterielItemAdapter = new ApplyMaterielItemAdapter(items, true, isNew);
        rvItem.setLayoutManager(new LinearLayoutManager(this));
        rvItem.setAdapter(applyMaterielItemAdapter);

    }

    @Override
    public void returnCollect(String string) {

    }

    @Override
    public void returnApplyMaterielBean(String s) {
        finish();
    }

    @Override
    public void returnMaterielTypeBeans(List<MaterielTypeBean> list) {
        applyMaterielItemAdapter = new ApplyMaterielItemAdapter(list, false, isNew);
        rvItem.setLayoutManager(new LinearLayoutManager(this));
        rvItem.setAdapter(applyMaterielItemAdapter);
    }

    private void showTimePickerView() {
        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                tvCollectTime.setText(TimeUtils.date2String(date, "yyyy-MM-dd"));
            }
        }).setType(new boolean[]{true, true, true, false, false, false}).build();
        // pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }

}
