package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.LeaveBean;
import com.dream.cleaner.ui.my.adapter.StopReceivingOrdersAdapter;
import com.dream.cleaner.ui.my.contract.StopReceivingOrdersActivityContract;
import com.dream.cleaner.ui.my.presenter.StopReceivingOrdersActivityPresenter;
import com.dream.cleaner.utils.UiUtil;
import com.dream.cleaner.widget.EmptyLayout;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.ToolbarBackTitle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author : liyl
 * date   : 2020/8/24
 * desc   :暂停接单
 */
public class StopReceivingOrdersActivity extends BaseActivity<StopReceivingOrdersActivityPresenter> implements StopReceivingOrdersActivityContract {

    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.my_rv)
    RecyclerView myRv;
    private StopReceivingOrdersAdapter stopReceivingOrdersAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_stop_receiving_orders;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "暂停接单");
    }

    @OnClick({R.id.tv_submit})
    public void onViewClicked(View view) {
        UiUtil.openActivity(this, ApplyStopReceivingActivity.class);
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mPresenter.leaveApplyList("1", "1000");
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mPresenter.leaveApplyList("1", "1000");
    }

    @Override
    public void returnLeaveBean(LeaveBean leaveBean) {
        if (leaveBean != null) {
            List<LeaveBean.RecordsBean> records = leaveBean.getRecords();
            stopReceivingOrdersAdapter = new StopReceivingOrdersAdapter(records);
            EmptyLayout emptyLayout = new EmptyLayout(this);
            emptyLayout.setErrorType(3);
            stopReceivingOrdersAdapter.setEmptyView(emptyLayout);
            stopReceivingOrdersAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                    int id = stopReceivingOrdersAdapter.getItem(position).getId();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", id + "");
                    UiUtil.openActivity(StopReceivingOrdersActivity.this, StopReceivingDetailActivity.class,bundle);
                }
            });
            myRv.setLayoutManager(new LinearLayoutManager(this));
            myRv.setAdapter(stopReceivingOrdersAdapter);

        }
    }

    @Override
    public void returnApply(String leaveBean) {

    }

    @Override
    public void returnLeaveRecordsBean(LeaveBean.RecordsBean leaveBean) {

    }
}
