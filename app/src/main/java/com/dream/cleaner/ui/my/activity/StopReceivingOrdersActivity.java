package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.StopReceivingOrdersBean;
import com.dream.cleaner.ui.my.adapter.StopReceivingOrdersAdapter;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarBackTitle;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author : liyl
 * date   : 2020/8/24
 * desc   :暂停接单
 */
public class StopReceivingOrdersActivity extends BaseActivity {

    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.my_rv)
    RecyclerView myRv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_stop_receiving_orders;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "暂停接单");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

        ArrayList<StopReceivingOrdersBean> stopReceivingOrdersBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            stopReceivingOrdersBeans.add(new StopReceivingOrdersBean());

        }
        StopReceivingOrdersAdapter stopReceivingOrdersAdapter = new StopReceivingOrdersAdapter(stopReceivingOrdersBeans);
        myRv.setLayoutManager(new LinearLayoutManager(this));
        myRv.setAdapter(stopReceivingOrdersAdapter);
    }
}
