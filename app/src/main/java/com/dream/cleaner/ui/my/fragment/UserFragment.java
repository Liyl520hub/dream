package com.dream.cleaner.ui.my.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.dream.cleaner.R;
import com.dream.cleaner.ui.my.activity.MaterielApplyActivity;
import com.dream.cleaner.ui.my.activity.MyIncomeActivity;
import com.dream.cleaner.ui.my.activity.SettingActivity;
import com.dream.cleaner.ui.my.activity.StopReceivingOrdersActivity;
import com.dream.cleaner.ui.my.activity.UserInfoActivity;
import com.dream.cleaner.utils.UiUtil;
import com.dream.common.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :
 *
 * @author joy
 */
public class UserFragment extends BaseFragment {

    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_mobile)
    TextView tvMobile;
    @BindView(R.id.rb_star)
    RatingBar rbStar;
    @BindView(R.id.cl_user_info)
    ConstraintLayout clUserInfo;
    @BindView(R.id.tv_month_order)
    TextView tvMonthOrder;
    @BindView(R.id.tv_day_order)
    TextView tvDayOrder;
    @BindView(R.id.tv_order_wan_cheng_num)
    TextView tvOrderWanChengNum;
    @BindView(R.id.tv_order_cancel_num)
    TextView tvOrderCancelNum;
    @BindView(R.id.tv_order_shou_hou_num)
    TextView tvOrderShouHouNum;
    @BindView(R.id.ll_order)
    LinearLayout llOrder;
    @BindView(R.id.tv_income)
    TextView tvIncome;
    @BindView(R.id.ll_income)
    LinearLayout llIncome;
    @BindView(R.id.tv_wu_liao)
    TextView tvWuLiao;
    @BindView(R.id.ll_wu_liao)
    LinearLayout llWuLiao;
    @BindView(R.id.tv_zan_ting)
    TextView tvZanTing;
    @BindView(R.id.ll_zan_ting)
    LinearLayout llZanTing;
    @BindView(R.id.tv_setting)
    TextView tvSetting;
    @BindView(R.id.ll_setting)
    LinearLayout llSetting;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {

    }


    @OnClick({R.id.tv_month_order, R.id.tv_day_order, R.id.ll_income, R.id.ll_wu_liao, R.id.ll_zan_ting,
            R.id.ll_setting, R.id.cl_user_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cl_user_info:
                UiUtil.openActivity(getActivity(), UserInfoActivity.class);
                break;
            case R.id.tv_month_order:
                break;
            case R.id.tv_day_order:
                break;
            case R.id.ll_income:
                UiUtil.openActivity(getActivity(), MyIncomeActivity.class);
                break;
            case R.id.ll_wu_liao:
                UiUtil.openActivity(getActivity(), MaterielApplyActivity.class);
                break;
            case R.id.ll_zan_ting:
                UiUtil.openActivity(getActivity(), StopReceivingOrdersActivity.class);
                break;
            case R.id.ll_setting:
                UiUtil.openActivity(getActivity(), SettingActivity.class);
                break;
            default:
        }
    }
}
