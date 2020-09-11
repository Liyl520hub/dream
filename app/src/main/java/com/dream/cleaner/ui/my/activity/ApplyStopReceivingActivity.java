package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.LeaveBean;
import com.dream.cleaner.ui.my.contract.StopReceivingOrdersActivityContract;
import com.dream.cleaner.ui.my.presenter.StopReceivingOrdersActivityPresenter;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.SuperToast;
import com.dream.common.widget.ToolbarBackTitle;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author : liyl
 * date   : 2020/8/26
 * desc   :申请暂停接单
 */
public class ApplyStopReceivingActivity extends BaseActivity<StopReceivingOrdersActivityPresenter> implements StopReceivingOrdersActivityContract {
    @BindView(R.id.tv_start_time_title)
    TextView tvStartTimeTitle;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.ll_start_time)
    LinearLayout llStartTime;
    @BindView(R.id.tv_end_time_title)
    TextView tvEndTimeTitle;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.ll_end_time)
    LinearLayout llEndTime;
    @BindView(R.id.tv_reason_title)
    TextView tvReasonTitle;
    @BindView(R.id.et_reason)
    EditText etReason;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_apply_stop_receiving;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "申请暂停接单");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }


    @OnClick({R.id.tv_start_time, R.id.tv_end_time, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_start_time:
                showTimePickerView(true);
                break;
            case R.id.tv_end_time:
                showTimePickerView(false);
                break;
            case R.id.tv_submit:
                String reason = etReason.getText().toString();
                if (StringUtils.isEmpty(reason)) {
                    SuperToast.showShortMessage("请假理由不能为空");
                    return;
                }
                String startTime = tvStartTime.getText().toString();
                if (StringUtils.isEmpty(startTime)) {
                    SuperToast.showShortMessage("请选择请假开始时间");
                    return;
                }
                String endTime = tvEndTime.getText().toString();
                if (StringUtils.isEmpty(endTime)) {
                    SuperToast.showShortMessage("请选择请假结束时间");
                    return;
                }
                mPresenter.leaveApply(startTime, endTime, reason);
                break;
            default:
        }
    }

    private void showTimePickerView(boolean isStart) {
        //时间选择器
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                setTvValue(isStart, TimeUtils.date2String(date));
            }
        }).setType(new boolean[]{true, true, true, true, true, true}).build();
        // pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }


    /**
     * 给开始时间和结束时间赋值
     *
     * @param isStart
     * @param date
     */
    private void setTvValue(boolean isStart, String date) {
        if (isStart) {
            if (!StringUtils.isEmpty(tvEndTime.getText().toString()) && TimeUtils.getTimeSpan(date, tvEndTime.getText().toString(), TimeConstants.MIN) > 1) {
                SuperToast.showShortMessage("开始时间不能大于结束时间");
            } else {
                tvStartTime.setHint("");
                tvStartTime.setText(date);
            }

        } else {
            if (!StringUtils.isEmpty(tvStartTime.getText().toString()) && TimeUtils.getTimeSpan(date, tvStartTime.getText().toString(), TimeConstants.MIN) < 1) {
                SuperToast.showShortMessage("结束时间不能小于开始时间");

            } else {
                tvEndTime.setHint("");
                tvEndTime.setText(date);
            }
        }
    }

    /**
     * 将小于10的补充0
     *
     * @return
     */
    private static String getFormatValue(int value) {
        if (value < 10) {
            return "0" + value;
        }
        return value + "";
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    @Override
    public void returnLeaveBean(LeaveBean leaveBean) {

    }

    @Override
    public void returnApply(String leaveBean) {
        finish();
    }

    @Override
    public void returnLeaveRecordsBean(LeaveBean.RecordsBean leaveBean) {

    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}
