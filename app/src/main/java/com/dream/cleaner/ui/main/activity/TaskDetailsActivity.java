package com.dream.cleaner.ui.main.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.dream.cleaner.R;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarBackTitle;

/**
 * author : liyl
 * date   : 2020/8/20
 * desc   : 任务详情
 * type
 * 0 新任务---》 任务信息 联系方式 订单信息  底部按钮为接单
 * 1 待服务---》 任务信息 联系方式（增加拨打电话） 订单信息（增加待服务状态） 底部按钮为出发
 * 2 上门中---》 任务信息 联系方式（增加拨打电话） 订单信息（增加上门中状态） 底部按钮为确认到达--》点击到达后变为扫前准备--》点击跳转
 * 3 服务中---》 任务信息 联系方式（增加拨打电话） 订单信息（增加服务中状态） 底部按钮为完成服务--》点击后跳转
 * 4 售后单---》 售后状态信息 任务信息 联系方式（增加拨打电话） 订单信息（增加售后中状态）补退款 扫前准备 扫后记录 没有底部按钮
 *
 * @author liyl
 */
public class TaskDetailsActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_task_details;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "任务详情");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }
}
