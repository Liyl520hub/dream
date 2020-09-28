package com.dream.cleaner.ui.main.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

import com.blankj.utilcode.util.BusUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.BusBean;
import com.dream.cleaner.beans.workorder.PopWorkOrderBean;
import com.dream.cleaner.beans.workorder.PopWorkOrderTypeListBean;
import com.dream.cleaner.ui.main.activity.WorkReadyActivity;
import com.dream.cleaner.ui.main.adapter.WorkOrderFragmentTabLayoutAdapter;
import com.dream.cleaner.ui.main.contract.WorkOrderFragmentContract;
import com.dream.cleaner.ui.main.presenter.WorkOrderFragmentPresenter;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.cleaner.utils.UiUtil;
import com.dream.cleaner.widget.DataGenerator;
import com.dream.cleaner.widget.pop.PopWorkOrder;
import com.dream.common.base.BaseFragment;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.SuperToast;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import razerdp.basepopup.BasePopupWindow;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :工单
 */
public class WorkOrderFragment extends BaseFragment<WorkOrderFragmentPresenter> implements WorkOrderFragmentContract {


    @BindView(R.id.my_view_pager)
    ViewPager2 myViewPager;
    @BindView(R.id.my_tab_layout)
    TabLayout myTabLayout;
    @BindView(R.id.tv_order_type)
    TextView tvOrderType;
    @BindView(R.id.tv_server_type)
    TextView tvServerType;
    @BindView(R.id.ll_menu)
    LinearLayout llMenu;
    private String[] tabTitles = new String[]{"新任务", "待服务", "上门中", "服务中", "售后单", "已完成", "已取消"};
    private ArrayList<WorkOrderTabFragment> fragments;
    private String serviceTypeId = "";
    private String orderTypeId = "";
    private List<PopWorkOrderBean> orderTypeList = new ArrayList<>();
    private List<PopWorkOrderBean> serviceList = new ArrayList<>();
    private WorkOrderFragmentTabLayoutAdapter mainAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_order;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this);
    }

    @OnClick({R.id.tv_order_type, R.id.tv_server_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_order_type:
                if (orderTypeList.size() == 0) {
                    mPresenter.getOrderTypeList();
                } else {
                    showPop(true);

                }
                break;
            case R.id.tv_server_type:
                if (serviceList.size() == 0) {
                    mPresenter.getServiceClassList();
                } else {
                    showPop(false);
                }
                break;
            default:
        }
    }


    @Override
    protected void initView() {
        if (getActivity() != null) {
            mainAdapter = new WorkOrderFragmentTabLayoutAdapter(getActivity(), getFragments());
            myViewPager.setAdapter(mainAdapter);
            myViewPager.setOffscreenPageLimit(getFragments().size());
            initTabLayout();
        }
        BusUtils.register(this);
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
        fragments = new ArrayList<>();
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
     * @param list
     * @param b    true 代表是订单类型
     */
    @Override
    public void returnPopWorkOrder(List<PopWorkOrderBean> list, boolean b) {
        if (list == null) {
            list = new ArrayList<>();
        }
        //过滤未上架的
        if (list.size() > 0) {
            Iterator<PopWorkOrderBean> iterator = list.iterator();
            while (iterator.hasNext()) {
                PopWorkOrderBean next = iterator.next();
                if (!"1".equals(next.getStatus())) {
                    iterator.remove();
                }
            }
        }

        if (b) {
            orderTypeList.clear();
            orderTypeList.addAll(list);
        } else {
            serviceList.clear();
            serviceList.addAll(list);
        }
        if (list.size() == 0) {
            SuperToast.showShortMessage("暂无类型");
        } else {
            showPop(b);
        }
    }

    private void showPop(boolean b) {
        PopWorkOrder popWorkOrder = new PopWorkOrder(this, b ? orderTypeList : serviceList, b);
        popWorkOrder.getPopWorkOrderAdapter().setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                PopWorkOrderBean data = (PopWorkOrderBean) adapter.getItem(position);
                List<PopWorkOrderBean> data1 = (List<PopWorkOrderBean>) adapter.getData();
                int size = data1.size();
                for (int i = 0; i < size; i++) {
                    if (i == position) {
                        continue;
                    }
                    data1.get(i).setCheck(false);
                }
                //true 设置为false
                data.setCheck(!data.isCheck());
                if (b) {
                    orderTypeId =data.isCheck()? data.getId() + "":"";
                } else {
                    serviceTypeId = data.isCheck()?data.getId() + "":"";
                }
                //刷新当前页面
                BusUtils.post(GlobalApp.BUS_FRAGMENT_WORK, new BusBean(orderTypeId, serviceTypeId));
                popWorkOrder.dismiss();

            }
        });
        popWorkOrder.setOnDismissListener(new BasePopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                llMenu.setBackgroundColor(Color.WHITE);
            }
        });
        popWorkOrder.setBackgroundColor(Color.TRANSPARENT);
        popWorkOrder.showPopupWindow(tvOrderType);
        llMenu.setBackgroundColor(ShapeUtils.getColor(R.color.color_f8f8f8));
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        BusUtils.unregister(this);
    }

}
