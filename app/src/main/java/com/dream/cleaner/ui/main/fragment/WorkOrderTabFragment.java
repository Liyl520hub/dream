package com.dream.cleaner.ui.main.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.workorder.PopWorkOrderBean;
import com.dream.cleaner.beans.workorder.WorkOrderTabBean;
import com.dream.cleaner.ui.main.adapter.WorkOrderTabFragmentAdapter;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.cleaner.widget.pop.PopTip;
import com.dream.cleaner.widget.pop.PopWorkOrder;
import com.dream.common.base.BaseFragment;
import com.dream.common.widget.SuperToast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import razerdp.basepopup.BasePopupWindow;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :工单tab
 *
 * @author joy
 */
public class WorkOrderTabFragment extends BaseFragment {


    @BindView(R.id.tv_order_type)
    TextView tvOrderType;
    @BindView(R.id.tv_server_type)
    TextView tvServerType;
    @BindView(R.id.ll_menu)
    LinearLayout llMenu;
    @BindView(R.id.my_recyclerview)
    RecyclerView myRecyclerview;
    private PopTip popTip;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_order_tab;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String title = arguments.getString("title");
            Log.e("title", title + "");
        }
        ArrayList<WorkOrderTabBean> workOrderTabBeans = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            workOrderTabBeans.add(new WorkOrderTabBean());
        }
        WorkOrderTabFragmentAdapter workOrderTabFragmentAdapter = new WorkOrderTabFragmentAdapter(workOrderTabBeans);
        myRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerview.setAdapter(workOrderTabFragmentAdapter);
        workOrderTabFragmentAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                popTip = new PopTip.Builder()
                        .setType(1)
                        .setMsg(
                                "您还未达到用户指定地址" +
                                "请您尽快到达，才能继续操作")
                        .setSubmitClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                popTip.dismiss();
                            }
                        }).build(getActivity());
                popTip.showPopupWindow();

            }
        });
    }


    @OnClick({R.id.tv_order_type, R.id.tv_server_type})
    public void onViewClicked(View view) {
        BasePopupWindow.OnDismissListener onDismissListener = new BasePopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                llMenu.setBackgroundColor(Color.WHITE);
            }
        };
        switch (view.getId()) {
            case R.id.tv_order_type:
                ArrayList<PopWorkOrderBean> popWorkOrderBeans = new ArrayList<>();
                popWorkOrderBeans.add(new PopWorkOrderBean("周次单"));
                popWorkOrderBeans.add(new PopWorkOrderBean("周期单"));
                popWorkOrderBeans.add(new PopWorkOrderBean("企业单"));
                popWorkOrderBeans.add(new PopWorkOrderBean("自如单"));
                popWorkOrderBeans.add(new PopWorkOrderBean("麦田单"));
                PopWorkOrder popWorkOrder = new PopWorkOrder(this, popWorkOrderBeans);
                popWorkOrder.getPopWorkOrderAdapter().setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                        PopWorkOrderBean data = (PopWorkOrderBean) adapter.getItem(position);
                        SuperToast.showShortMessage(data.getName());
                    }
                });
                popWorkOrder.setOnDismissListener(onDismissListener);
                popWorkOrder.setBackgroundColor(Color.TRANSPARENT);
                popWorkOrder.showPopupWindow(tvOrderType);
                llMenu.setBackgroundColor(ShapeUtils.getColor(R.color.color_f8f8f8));
                break;
            case R.id.tv_server_type:
                ArrayList<PopWorkOrderBean> servers = new ArrayList<>();
                servers.add(new PopWorkOrderBean("日常保洁"));
                servers.add(new PopWorkOrderBean("开荒保洁"));
                servers.add(new PopWorkOrderBean("深度保洁"));
                servers.add(new PopWorkOrderBean("地毯清洁"));
                PopWorkOrder popServers = new PopWorkOrder(this, servers);
                popServers.getPopWorkOrderAdapter().setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                        PopWorkOrderBean data = (PopWorkOrderBean) adapter.getItem(position);
                        SuperToast.showShortMessage(data.getName());
                    }
                });
                popServers.setOnDismissListener(onDismissListener);
                popServers.setBackgroundColor(Color.TRANSPARENT);
                popServers.showPopupWindow(tvServerType);
                llMenu.setBackgroundColor(ShapeUtils.getColor(R.color.color_f8f8f8));


                break;
            default:
        }
    }
}
