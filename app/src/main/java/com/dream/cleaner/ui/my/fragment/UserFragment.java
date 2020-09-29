package com.dream.cleaner.ui.my.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.TimeUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.CleanerOrderCountBean;
import com.dream.cleaner.ui.my.activity.MaterielApplyListActivity;
import com.dream.cleaner.ui.my.activity.MyIncomeActivity;
import com.dream.cleaner.ui.my.activity.SettingActivity;
import com.dream.cleaner.ui.my.activity.StopReceivingOrdersActivity;
import com.dream.cleaner.ui.my.activity.UserInfoActivity;
import com.dream.cleaner.ui.my.contract.UserFragmentContract;
import com.dream.cleaner.ui.my.presenter.UserFragmentPresenter;
import com.dream.cleaner.utils.ImageLoaderUtils;
import com.dream.cleaner.utils.InfoUtils;
import com.dream.cleaner.utils.UiUtil;
import com.dream.common.base.BaseFragment;
import com.dream.common.http.error.ErrorType;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :
 *
 * @author joy
 */
public class UserFragment extends BaseFragment<UserFragmentPresenter> implements UserFragmentContract {

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
    /**
     * 默认今日订单
     */
    private boolean isDayOrder = true;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected void initView() {
        ImageLoaderUtils.loadImgCircle(InfoUtils.getHeadIcPath(), ivHead);
        tvName.setText(InfoUtils.getName());
        tvMobile.setText(InfoUtils.getPhone());
        setLevel();
        String nowString = TimeUtils.getNowString(TimeUtils.getSafeDateFormat("yyyy-MM-dd"));
        mPresenter.getCleanerOrderCount(nowString);
    }

    /**
     * 设置用户星级
     */
    private void setLevel() {
        String userLevel = InfoUtils.getUserLevel();
        if ("一星".equals(userLevel)) {
            rbStar.setRating(1);
        } else if ("二星".equals(userLevel)) {
            rbStar.setRating(2);
        } else if ("三星".equals(userLevel)) {
            rbStar.setRating(3);
        } else if ("四星".equals(userLevel)) {
            rbStar.setRating(4);
        } else if ("五星".equals(userLevel)) {
            rbStar.setRating(5);
        }
    }


    @OnClick({R.id.tv_month_order, R.id.tv_day_order, R.id.ll_income, R.id.ll_wu_liao, R.id.ll_zan_ting,
            R.id.ll_setting, R.id.cl_user_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cl_user_info:
                UiUtil.openActivity(getActivity(), UserInfoActivity.class);
                break;
            case R.id.tv_month_order:
                isDayOrder = false;
                showTimePickerView();
                break;
            case R.id.tv_day_order:
                isDayOrder = true;
                showTimePickerView();
                break;
            case R.id.ll_income:
                UiUtil.openActivity(getActivity(), MyIncomeActivity.class);
                break;
            case R.id.ll_wu_liao:
                UiUtil.openActivity(getActivity(), MaterielApplyListActivity.class);
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

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void returnCleanerOrderCountBean(CleanerOrderCountBean cleanerOrderCountBean) {
        if (cleanerOrderCountBean != null) {
            tvOrderWanChengNum.setText(cleanerOrderCountBean.getFinishOrderCount() + "单");
            tvOrderCancelNum.setText(cleanerOrderCountBean.getCancelOrderCount() + "单");
            tvOrderShouHouNum.setText(cleanerOrderCountBean.getAfterOrderCount() + "单");
        }
    }


    private void showTimePickerView() {
        //时间选择器
        TimePickerBuilder timePickerBuilder = new TimePickerBuilder(getActivity(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                String time = "";
                if (isDayOrder) {
                    time = TimeUtils.date2String(date, "yyyy-MM-dd");
                } else {
                    time = TimeUtils.date2String(date, "yyyy-MM");
                }
                mPresenter.getCleanerOrderCount(time);
            }
        });
        if (isDayOrder) {
            timePickerBuilder.setType(new boolean[]{true, true, true, false, false, false});
        } else {
            timePickerBuilder.setType(new boolean[]{true, true, false, false, false, false});
        }
        TimePickerView pvTime = timePickerBuilder.build();
        // pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }

}
