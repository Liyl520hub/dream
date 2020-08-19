package com.dream.cleaner.widget.pop;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dream.cleaner.R;
import com.dream.cleaner.beans.workorder.PopWorkOrderBean;
import com.dream.cleaner.widget.pop.adapter.PopWorkOrderAdapter;

import java.util.ArrayList;

import razerdp.basepopup.BasePopupWindow;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :工单下拉框
 *
 * @author joy
 */
public class PopWorkOrder extends BasePopupWindow {
    private ArrayList<PopWorkOrderBean> popWorkOrderBeans;
    private PopWorkOrderAdapter popWorkOrderAdapter;

    public PopWorkOrder(Fragment fragment, ArrayList<PopWorkOrderBean> popWorkOrderBeans) {
        super(fragment);
        this.popWorkOrderBeans = popWorkOrderBeans;
        initView(fragment);
    }


    private void initView(Fragment fragment) {
        RecyclerView myRv = findViewById(R.id.my_rv);
        popWorkOrderAdapter = new PopWorkOrderAdapter(popWorkOrderBeans);
        myRv.setLayoutManager(new LinearLayoutManager(fragment.getContext()));
        myRv.setAdapter(popWorkOrderAdapter);
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.pop_work_order);
    }

    public PopWorkOrderAdapter getPopWorkOrderAdapter() {
        return popWorkOrderAdapter;
    }
}
