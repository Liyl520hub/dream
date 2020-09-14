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

import com.blankj.utilcode.util.BusUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dream.cleaner.R;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.BusBean;
import com.dream.cleaner.beans.workorder.PopWorkOrderBean;
import com.dream.cleaner.beans.workorder.WorkOrderTabBean;
import com.dream.cleaner.ui.main.activity.TaskDetailsActivity;
import com.dream.cleaner.ui.main.adapter.WorkOrderTabFragmentAdapter;
import com.dream.cleaner.ui.main.contract.WorkOrderTabFragmentContract;
import com.dream.cleaner.ui.main.presenter.WorkOrderTabFragmentPresenter;
import com.dream.cleaner.utils.ShapeUtils;
import com.dream.cleaner.utils.UiUtil;
import com.dream.cleaner.widget.EmptyLayout;
import com.dream.cleaner.widget.pop.PopTip;
import com.dream.cleaner.widget.pop.PopWorkOrder;
import com.dream.common.base.BaseFragment;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.SuperToast;

import java.util.ArrayList;
import java.util.List;

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
public class WorkOrderTabFragment extends BaseFragment<WorkOrderTabFragmentPresenter> implements WorkOrderTabFragmentContract {


    @BindView(R.id.my_recyclerview)
    RecyclerView myRecyclerview;
    private PopTip popTip;
    private String title;
    private WorkOrderTabFragmentAdapter workOrderTabFragmentAdapter;
    private String orderTypeId = "";
    private String serviceTypeId = "";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_work_order_tab;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected void initView() {
        BusUtils.register(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            title = arguments.getString("title");
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        initData(orderTypeId, serviceTypeId);
    }

    private void initData(String orderType, String serviceType) {
        orderTypeId = orderType;
        serviceTypeId = serviceType;
        mPresenter.taskList("1", "10", getOrderStatus(title), orderTypeId, serviceTypeId);
    }

    public void upData(String orderType, String serviceType) {
        initData(orderType, serviceType);
    }

    private int getOrderStatus(String title) {
        int intOrderStatus = 0;
        switch (title) {
            case "新任务": {
                intOrderStatus = 0;
            }
            break;
            case "待服务": {
                intOrderStatus = 1;
            }
            break;
            case "上门中": {
                intOrderStatus = 2;
            }
            break;
            case "服务中": {
                intOrderStatus = 5;
            }
            break;
            case "售后单": {
                intOrderStatus = 8;
            }
            break;
            case "已完成": {
                intOrderStatus = 7;
            }
            break;
            case "已取消": {
                intOrderStatus = 9;
            }
            break;
            default:
        }
        return intOrderStatus;
    }


    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void returnTaskList(WorkOrderTabBean workOrderTabBean) {
        List<WorkOrderTabBean.RecordsBean> records = workOrderTabBean.getRecords();
        if (workOrderTabFragmentAdapter != null) {
            workOrderTabFragmentAdapter.setList(records);
        } else {
            workOrderTabFragmentAdapter = new WorkOrderTabFragmentAdapter(records);
            myRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
            myRecyclerview.setAdapter(workOrderTabFragmentAdapter);
            EmptyLayout emptyLayout = new EmptyLayout(getActivity());
            emptyLayout.setErrorType(3);
            workOrderTabFragmentAdapter.setEmptyView(emptyLayout);
            workOrderTabFragmentAdapter.addChildClickViewIds(R.id.cl_top, R.id.tv_submit);
            workOrderTabFragmentAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                @Override
                public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
                    WorkOrderTabBean.RecordsBean item = workOrderTabFragmentAdapter.getItem(position);
                    int id = item.getId();
                    switch (view.getId()) {
                        case R.id.cl_top: {
                            Bundle bundle = new Bundle();
                            bundle.putString("title", title);
                            bundle.putString("id", id + "");
                            UiUtil.openActivity(getActivity(), TaskDetailsActivity.class, bundle);
                        }
                        break;

                        case R.id.tv_submit: {
                            popTip = new PopTip.Builder()
                                    .setType(2)
                                    .setMsg("接单确认")
                                    .setSubmitClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            popTip.dismiss();
                                        }
                                    }).setCancelClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            popTip.dismiss();
                                        }
                                    })
                                    .setYesClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            popTip.dismiss();
                                        }
                                    })
                                    .build(getActivity());
                            popTip.showPopupWindow();
                        }
                        break;


                        default:
                    }


                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        BusUtils.unregister(this);
    }

    @BusUtils.Bus(tag = GlobalApp.BUS_FRAGMENT_WORK)
    public void postBusListener(BusBean busBean) {
        if (isResumed()) {
            Log.e(WorkOrderTabFragment.this.toString(), title);
            initData(busBean.getOrderTypeId(), busBean.getServiceTypeId());
        }

    }
}
