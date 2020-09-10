package com.dream.cleaner.ui.main.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import com.dream.cleaner.R;
import com.dream.cleaner.ui.main.adapter.WorkOrderFragmentTabLayoutAdapter;
import com.dream.cleaner.widget.DataGenerator;
import com.dream.common.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :工单
 */
public class WorkOrderFragment extends BaseFragment {


    @BindView(R.id.my_view_pager)
    ViewPager2 myViewPager;
    @BindView(R.id.my_tab_layout)
    TabLayout myTabLayout;

    private String[] tabTitles = new String[]{"新任务", "待服务", "上门中", "服务中", "售后单", "已完成", "已取消"};


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_order;
    }

    @Override
    protected void initPresenter() {

    }


    @Override
    protected void initView() {
        if (getActivity() != null) {
            WorkOrderFragmentTabLayoutAdapter mainAdapter = new WorkOrderFragmentTabLayoutAdapter(getActivity(), getFragments());
            myViewPager.setAdapter(mainAdapter);
            myViewPager.setOffscreenPageLimit(getFragments().size());
            initTabLayout();
        }
    }

    private void initTabLayout() {
        //设置关联
        new TabLayoutMediator(myTabLayout, myViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabTitles[position]);
            }
        }).attach();


    }

    private ArrayList<WorkOrderTabFragment> getFragments() {
        ArrayList<WorkOrderTabFragment> fragments = new ArrayList<>();
        int length = tabTitles.length;
        for (int i = 0; i < length; i++) {
            WorkOrderTabFragment workOrderTabFragment = new WorkOrderTabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", tabTitles[i]);
            workOrderTabFragment.setArguments(bundle);
            fragments.add(workOrderTabFragment);
        }
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
}
