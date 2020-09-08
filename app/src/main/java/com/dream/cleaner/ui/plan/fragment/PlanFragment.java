package com.dream.cleaner.ui.plan.fragment;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.BusUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.BusBean;
import com.dream.cleaner.beans.PlanBean;
import com.dream.cleaner.beans.PlanSectionBean;
import com.dream.cleaner.ui.plan.adapter.PlanFragmentAdapter;
import com.dream.common.base.BaseFragment;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * date   : 2020/8/19
 * desc   :计划
 *
 * @author Liyalei
 */
public class PlanFragment extends BaseFragment implements CalendarView.OnCalendarSelectListener, CalendarView.OnYearChangeListener {
    @BindView(R.id.my_calendar)
    CalendarView mCalendarView;
    @BindView(R.id.my_rv)
    RecyclerView myRv;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_plan;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        BusUtils.register(this);
        mCalendarView.setOnCalendarSelectListener(this);
        mCalendarView.setOnYearChangeListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        BusUtils.post(GlobalApp.BUS_FRAGMENT_PLAN, new BusBean(mCalendarView.getCurYear()+"年"+mCalendarView.getCurMonth() + "月"));
        initData();
    }

    private void initData() {
        int year = mCalendarView.getCurYear();
        int month = mCalendarView.getCurMonth();

        Map<String, Calendar> map = new HashMap<>();
        map.put(getSchemeCalendar(year, month, 3, 0xFF40db25, "假").toString(),
                getSchemeCalendar(year, month, 3, 0xFF40db25, "假"));
        map.put(getSchemeCalendar(year, month, 6, 0xFFe69138, "事").toString(),
                getSchemeCalendar(year, month, 6, 0xFFe69138, "事"));
        map.put(getSchemeCalendar(year, month, 9, 0xFFdf1356, "议").toString(),
                getSchemeCalendar(year, month, 9, 0xFFdf1356, "议"));
        map.put(getSchemeCalendar(year, month, 13, 0xFFedc56d, "记").toString(),
                getSchemeCalendar(year, month, 13, 0xFFedc56d, "记"));
        map.put(getSchemeCalendar(year, month, 14, 0xFFedc56d, "记").toString(),
                getSchemeCalendar(year, month, 14, 0xFFedc56d, "记"));
        map.put(getSchemeCalendar(year, month, 15, 0xFFaacc44, "假").toString(),
                getSchemeCalendar(year, month, 15, 0xFFaacc44, "假"));
        map.put(getSchemeCalendar(year, month, 18, 0xFFbc13f0, "记").toString(),
                getSchemeCalendar(year, month, 18, 0xFFbc13f0, "记"));
        map.put(getSchemeCalendar(year, month, 25, 0xFF13acf0, "假").toString(),
                getSchemeCalendar(year, month, 25, 0xFF13acf0, "假"));
        map.put(getSchemeCalendar(year, month, 27, 0xFF13acf0, "多").toString(),
                getSchemeCalendar(year, month, 27, 0xFF13acf0, "多"));
        //此方法在巨大的数据量上不影响遍历性能，推荐使用
        mCalendarView.setSchemeDate(map);

        ArrayList<PlanSectionBean> planSectionBeans = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            planSectionBeans.add(new PlanSectionBean<>(true, "7:00"));
            planSectionBeans.add(new PlanSectionBean<>(new PlanBean("上班")));
        }

        PlanFragmentAdapter planFragmentAdapter = new PlanFragmentAdapter(planSectionBeans);
        myRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRv.setAdapter(planFragmentAdapter);
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
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
      BusUtils.post(GlobalApp.BUS_FRAGMENT_PLAN,new BusBean(calendar.getYear()+"年"+calendar.getMonth() + "月"));
    }

    @Override
    public void onYearChange(int year) {

    }
}
