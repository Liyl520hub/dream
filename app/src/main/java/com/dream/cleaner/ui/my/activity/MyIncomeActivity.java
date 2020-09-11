package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.MyIncomeBean;
import com.dream.cleaner.beans.my.MyOrderListBean;
import com.dream.cleaner.ui.my.MyOrderListAdapter;
import com.dream.cleaner.ui.my.contract.MyIncomeActivityContract;
import com.dream.cleaner.ui.my.presenter.MyIncomeActivityPresenter;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.ToolbarBackTitle;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author : liyl
 * date   : 2020/8/23
 * desc   :
 */
public class MyIncomeActivity extends BaseActivity<MyIncomeActivityPresenter> implements MyIncomeActivityContract {
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
    @BindView(R.id.tv_net_wages)
    TextView tvNetWages;
    @BindView(R.id.tv_deduction_wages)
    TextView tvDeductionWages;
    @BindView(R.id.ll_head)
    LinearLayout llHead;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_income;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "我的收益");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mPresenter.myIncome();
        ArrayList<MyOrderListBean> myOrderListBeans = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            myOrderListBeans.add(new MyOrderListBean());
        }
        MyOrderListAdapter myOrderListAdapter = new MyOrderListAdapter(myOrderListBeans);
        rvOrderList.setLayoutManager(new LinearLayoutManager(this));
        rvOrderList.setAdapter(myOrderListAdapter);


    }


    @Override
    public void returnMyIncome(MyIncomeBean myIncomeBean) {
        if (myIncomeBean != null) {
            //总收入
            tvNum.setText(myIncomeBean.getTotalWages() + "元");
            //月份
            tvMouth.setText(myIncomeBean.getMonth() + "月");
            //订单数
            tvOrderNum.setText(myIncomeBean.getOrderNum() + "单");
            //实收
            tvNetWages.setText("+" + myIncomeBean.getNetWages() + "元");
            //扣款
            tvDeductionWages.setText("-" + myIncomeBean.getDeductionWages() + "元");
        }

    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}
