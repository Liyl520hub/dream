package com.dream.cleaner.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dream.cleaner.R;


/**
 * @author Liyalei
 */
public class DataGenerator {
    public static final int[] mTabRes = new int[]{R.mipmap.menu_work_order, R.mipmap.menu_plan, R.mipmap.menu_news, R.mipmap.menu_my};
    public static final int[] mTabResPressed = new int[]{R.mipmap.menu_work_order_uncheck, R.mipmap.menu_plan_uncheck, R.mipmap.menu_news_uncheck, R.mipmap.menu_my_uncheck};
    private static String[] tabTitles = new String[]{"工单", "计划", "消息", "我的"};


    public static final int[] mNewsNoSelect = new int[]{R.mipmap.check_ungroup, R.mipmap.menu_work_order_uncheck, R.mipmap.check_notifal_uncheck, R.mipmap.check_leave_uncheck};
    public static final int[] mNewsResSelect = new int[]{R.mipmap.check_grouping, R.mipmap.menu_work_order, R.mipmap.news_notifal, R.mipmap.news_leave};
    private static String[] tabNewsTitles = new String[]{"全部", "工单", "公告", "请假"};


    /**
     * 获取Tab 显示的内容
     *
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position, boolean isSelected) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_home_content, null);
        ImageView tabIcon = view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(isSelected ? DataGenerator.mTabRes[position] : DataGenerator.mTabResPressed[position]);
        TextView tabText = view.findViewById(R.id.tab_content_text);
        tabText.setText(tabTitles[position]);
        return view;
    }

    public static View getTabNewsView(Context context, int position, boolean isSelected) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_home_content, null);
        ImageView tabIcon = view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(isSelected ? DataGenerator.mNewsResSelect[position] : DataGenerator.mNewsNoSelect[position]);
        TextView tabText = view.findViewById(R.id.tab_content_text);
        tabText.setText(tabNewsTitles[position]);
        return view;
    }

}
