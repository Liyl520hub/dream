package com.dream.cleaner.ui.plan.fragment;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.BusUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.BusBean;
import com.dream.cleaner.beans.PlanBean;
import com.dream.cleaner.beans.PlanSectionBean;
import com.dream.cleaner.ui.plan.adapter.PlanFragmentAdapter;
import com.dream.cleaner.ui.plan.contract.PlanFragmentContract;
import com.dream.cleaner.ui.plan.presenter.PlanFragmentPresenter;
import com.dream.common.base.BaseFragment;
import com.dream.common.http.error.ErrorType;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * date   : 2020/8/19
 * desc   :计划
 *
 * @author Liyalei
 */
public class PlanFragment extends BaseFragment<PlanFragmentPresenter> implements PlanFragmentContract {
    @BindView(R.id.my_calendar)
    CalendarView mCalendarView;
    @BindView(R.id.my_rv)
    RecyclerView myRv;
    private int oldMonth;
    private String oldPlanTime = "";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_plan;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected void initView() {
        BusUtils.register(this);
        mCalendarView.setOnCalendarSelectListener(new CalendarView.OnCalendarSelectListener() {
            @Override
            public void onCalendarOutOfRange(Calendar calendar) {

            }

            @Override
            public void onCalendarSelect(Calendar calendar, boolean isClick) {
                BusUtils.post(GlobalApp.BUS_FRAGMENT_PLAN, new BusBean(calendar.getYear() + "年" + calendar.getMonth() + "月"));
                int year = calendar.getYear();
                int month = calendar.getMonth();
                int day = calendar.getDay();
                setCurrentDayPlan(year, month, day);
                if (month != oldMonth) {
                    mPresenter.getCleanerPlan(year + "", month + "");
                    oldMonth = month;
                }
            }


        });
    }

    private void setCurrentDayPlan(int year, int month, int day) {
        String planTime = year + "-" + (month <= 9 ? "0" : "") + month + "-" + (day <= 9 ? "0" : "") + day;
        if (!oldPlanTime.equals(planTime)) {
            mPresenter.getCleanerPlanDay(planTime);
            oldPlanTime = planTime;
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        BusUtils.post(GlobalApp.BUS_FRAGMENT_PLAN, new BusBean(mCalendarView.getCurYear() + "年" + mCalendarView.getCurMonth() + "月"));
        mPresenter.getCleanerPlan(mCalendarView.getCurYear() + "", mCalendarView.getCurMonth() + "");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        BusUtils.unregister(this);
    }


    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        //如果单独标记颜色、则会使用这个颜色
        calendar.setSchemeColor(color);
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(0xFF008800, "假");
        calendar.addScheme(0xFF008800, "节");
        return calendar;
    }

    @Override
    public void returnCleanerPlan(List<PlanBean> list) {
        int size = list.size();
        Map<String, Calendar> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            PlanBean planBean = list.get(i);
            String planDate = planBean.getPlanDate();
            //0 无  1为订单，2为请假
            String type = planBean.getType();
            if (!"0".equals(type)) {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                Date date = TimeUtils.string2Date(planDate, "yyyy-MM-dd");
                if (date != null) {
                    calendar.setTime(date);
                    int year = calendar.get(java.util.Calendar.YEAR);
                    int month = calendar.get(java.util.Calendar.MONTH);
                    int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
                    String text = "1".equals(type) ? "单" : "假";
                    map.put(getSchemeCalendar(year, month + 1, day, 0xFF40db25, text).toString(),
                            getSchemeCalendar(year, month + 1, day, 0xFF40db25, text));
                }
            }
        }
        //此方法在巨大的数据量上不影响遍历性能，推荐使用
        mCalendarView.setSchemeDate(map);
        int year = mCalendarView.getCurYear();
        int month = mCalendarView.getCurMonth();
        int day = mCalendarView.getCurDay();
        setCurrentDayPlan(year, month, day);
    }

    @Override
    public void returnCleanerPlanDay(List<PlanBean.CleanerPlanItemsBean> list) {
        int size = list.size();
        ArrayList<PlanSectionBean> planSectionBeans = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            PlanBean.CleanerPlanItemsBean cleanerPlanItemsBean = list.get(i);
            String startTime = cleanerPlanItemsBean.getStartTime();
            Date date = TimeUtils.string2Date(startTime);
            String s = TimeUtils.date2String(date, "HH:mm");
            planSectionBeans.add(new PlanSectionBean<>(true, s));
            planSectionBeans.add(new PlanSectionBean<>(cleanerPlanItemsBean));
        }
        PlanFragmentAdapter planFragmentAdapter = new PlanFragmentAdapter(planSectionBeans);
        myRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRv.setAdapter(planFragmentAdapter);

    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }


}
