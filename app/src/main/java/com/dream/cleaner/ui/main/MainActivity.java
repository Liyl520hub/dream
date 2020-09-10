package com.dream.cleaner.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.blankj.utilcode.util.BusUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.BusBean;
import com.dream.cleaner.ui.main.adapter.MainAdapter;
import com.dream.cleaner.ui.main.fragment.WorkOrderFragment;
import com.dream.cleaner.ui.my.fragment.UserFragment;
import com.dream.cleaner.ui.news.fragment.NewsFragment;
import com.dream.cleaner.ui.plan.fragment.PlanFragment;
import com.dream.cleaner.widget.DataGenerator;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarTitle;
import com.dream.common.widget.ToolbarTitleLeftTv;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author Liyalei
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.my_view_pager)
    ViewPager2 myViewPager;
    @BindView(R.id.my_tab_layout)
    TabLayout myTabLayout;
    private ToolbarTitleLeftTv toolbarTitle;
    public String leftText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
    }


    @Override
    protected MyToolbar getMyToolbar() {
        toolbarTitle = new ToolbarTitleLeftTv(this, "壹佳保洁");
        return toolbarTitle;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        setDoubleClickExit(true);
        BusUtils.register(this);
        MainAdapter mainAdapter = new MainAdapter(this, getFragments());
        myViewPager.setAdapter(mainAdapter);
        myViewPager.setUserInputEnabled(false);
        myViewPager.setOffscreenPageLimit(4);
        initTabLayout();

    }

    private void initTabLayout() {
        //设置关联
        new TabLayoutMediator(myTabLayout, myViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setCustomView(DataGenerator.getTabView(MainActivity.this, position, position == 0));
            }
        }).attach();
        //设置点击切换状态
        myTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0: {
                        toolbarTitle.setTitle("壹佳保洁");
                        toolbarTitle.setLiftTitle("");
                    }
                    break;
                    case 1: {
                        toolbarTitle.setTitle("计划");
                        toolbarTitle.setLiftTitle(leftText);
                    }
                    break;
                    case 2: {
                        toolbarTitle.setTitle("消息通知");
                        toolbarTitle.setLiftTitle("");
                    }
                    break;
                    case 3: {
                        toolbarTitle.setTitle("个人中心");
                        toolbarTitle.setLiftTitle("");
                    }
                    break;
                    default:
                }

                if (position == 3) {

                }
                setTabState(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        WorkOrderFragment workOrderFragment = new WorkOrderFragment();
        PlanFragment planFragment = new PlanFragment();
        NewsFragment newsFragment = new NewsFragment();
        UserFragment userFragment = new UserFragment();
        fragments.add(workOrderFragment);
        fragments.add(planFragment);
        fragments.add(newsFragment);
        fragments.add(userFragment);
        return fragments;
    }

    /**
     * @param tabPosition 设置tab状态
     */
    private void setTabState(int tabPosition) {
        for (int i = 0; i < myTabLayout.getTabCount(); i++) {
            TabLayout.Tab tabAt = myTabLayout.getTabAt(i);
            if (tabAt != null) {
                View view = tabAt.getCustomView();
                if (view != null) {
                    ImageView icon = view.findViewById(R.id.tab_content_image);
                    TextView tabContentText = view.findViewById(R.id.tab_content_text);
                    if (i == tabPosition) {
                        // 选中状态
                        icon.setImageResource(DataGenerator.mTabRes[i]);
                        tabContentText.setSelected(true);
                    } else {// 未选中状态
                        icon.setImageResource(DataGenerator.mTabResPressed[i]);
                        tabContentText.setSelected(false);

                    }
                }
            }
        }
    }

    @BusUtils.Bus(tag = GlobalApp.BUS_FRAGMENT_PLAN)
    public void postBusListener(BusBean busBean) {
        leftText = busBean.getName();
        toolbarTitle.setLiftTitle(busBean.getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusUtils.unregister(this);
    }
}
