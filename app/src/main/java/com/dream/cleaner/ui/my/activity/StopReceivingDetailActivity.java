package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.LeaveBean;
import com.dream.cleaner.ui.my.contract.StopReceivingOrdersActivityContract;
import com.dream.cleaner.ui.my.presenter.StopReceivingOrdersActivityPresenter;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.ToolbarBackTitle;

import butterknife.BindView;

/**
 * @author : liyl
 * date   : 2020/8/26
 * desc   :暂停接单详情
 */
public class StopReceivingDetailActivity extends BaseActivity<StopReceivingOrdersActivityPresenter> implements StopReceivingOrdersActivityContract {

    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.tv_apply_time)
    TextView tvApplyTime;
    @BindView(R.id.tv_states)
    TextView tvStates;
    @BindView(R.id.tv_reason_title)
    TextView tvReasonTitle;
    @BindView(R.id.tv_reason)
    TextView tvReason;
    private String id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_stop_receiving_detail;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "申请详情");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        if (getIntent() != null) {
            id = getIntent().getStringExtra("id");

        }
        mPresenter.leaveApplyList(id);
    }

    @Override
    public void returnLeaveBean(LeaveBean leaveBean) {

    }

    @Override
    public void returnApply(String leaveBean) {

    }

    @Override
    public void returnLeaveRecordsBean(LeaveBean.RecordsBean item) {
        if (item != null) {
            tvStartTime.setText("开始时间：" + item.getStartTime());
            tvEndTime.setText("结束时间：" + item.getStartTime());
            tvApplyTime.setText("申请时间：" + item.getCreateTime());
            int status = item.getStatus();
            String statusString = "";
            if (status == 0) {
                statusString = "待审核";
            } else if (status == 1) {
                statusString = "通过";
            } else if (status == 2) {
                statusString = "拒绝";
            }
            tvStates.setText("审批状态:" + statusString);
            tvReason.setText(item.getReason());
        }
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}
