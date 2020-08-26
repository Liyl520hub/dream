package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.dream.cleaner.R;
import com.dream.cleaner.beans.my.ApplyMaterielBean;
import com.dream.cleaner.ui.my.adapter.ApplyMaterielAdapter;
import com.dream.cleaner.utils.UiUtil;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarBackTitle;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author : liyl
 * date   : 2020/8/26
 * desc   :物料申请
 */
public class MaterielApplyActivity extends BaseActivity {
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.my_rv)
    RecyclerView myRv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_materiel_apply;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "物料申请");
    }

    @OnClick({R.id.tv_submit})
    public void onViewClicked(View view) {
        UiUtil.openActivity(this, ApplyMaterielActivity.class);
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

        ArrayList<ApplyMaterielBean> applyMaterielBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            applyMaterielBeans.add(new ApplyMaterielBean());

        }
        ApplyMaterielAdapter applyMaterielAdapter = new ApplyMaterielAdapter(applyMaterielBeans);
        applyMaterielAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                UiUtil.openActivity(MaterielApplyActivity.this, StopReceivingDetailActivity.class);
            }
        });
        myRv.setLayoutManager(new LinearLayoutManager(this));
        myRv.setAdapter(applyMaterielAdapter);
    }
}
