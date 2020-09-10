package com.dream.cleaner.ui.main.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.dream.cleaner.ui.main.fragment.WorkOrderTabFragment;

import java.util.ArrayList;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :工单tab fragment适配器
 * @author joy
 */
public class WorkOrderFragmentTabLayoutAdapter extends FragmentStateAdapter {

    private ArrayList<WorkOrderTabFragment> fragments;

    public WorkOrderFragmentTabLayoutAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<WorkOrderTabFragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public WorkOrderTabFragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }


}
