package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.MyOrderListBean;
import com.dream.cleaner.ui.my.MyOrderListAdapter;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarBackTitle;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author : liyl
 * date   : 2020/8/23
 * desc   :
 */
public class MyIncomeActivity extends BaseActivity {
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_mouth)
    TextView tvMouth;
    @BindView(R.id.tv_order_num)
    TextView tvOrderNum;
    @BindView(R.id.ll_order)
    LinearLayout llOrder;
    @BindView(R.id.tv_income_info)
    TextView tvIncomeInfo;
    @BindView(R.id.ll_income_info_title)
    LinearLayout llIncomeInfoTitle;
    @BindView(R.id.ll_income_info)
    LinearLayout llIncomeInfo;
    @BindView(R.id.tv_order_list)
    TextView tvOrderList;
    @BindView(R.id.rv_order_list)
    RecyclerView rvOrderList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_income;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "我的收益");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        ArrayList<MyOrderListBean> myOrderListBeans = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            myOrderListBeans.add(new MyOrderListBean());
        }
        MyOrderListAdapter myOrderListAdapter = new MyOrderListAdapter(myOrderListBeans);
        rvOrderList.setLayoutManager(new LinearLayoutManager(this));
        rvOrderList.setAdapter(myOrderListAdapter);



    }


}
