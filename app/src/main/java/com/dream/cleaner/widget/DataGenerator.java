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


    /**
     * 获取Tab 显示的内容
     *
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position,boolean isSelected) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_home_content, null);
        ImageView tabIcon = view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(isSelected?DataGenerator.mTabRes[position]:DataGenerator.mTabResPressed[position]);
        TextView tabText = view.findViewById(R.id.tab_content_text);
        tabText.setText(tabTitles[position]);
        return view;
    }

}
