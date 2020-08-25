package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.dream.cleaner.R;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarBackTitle;

import butterknife.BindView;

/**
 * @author : liyl
 * date   : 2020/8/26
 * desc   :暂停接单详情
 */
public class StopReceivingDetailActivity extends BaseActivity {

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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_stop_receiving_detail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "申请详情");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }

}
