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
import com.dream.cleaner.ui.my.contract.MaterielApplyContract;
import com.dream.cleaner.ui.my.presenter.MaterielApplyPresenter;
import com.dream.cleaner.utils.UiUtil;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.ToolbarBackTitle;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author : liyl
 * date   : 2020/8/26
 * desc   :物料申请列表
 */
public class MaterielApplyListActivity extends BaseActivity<MaterielApplyPresenter> implements MaterielApplyContract {
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.my_rv)
    RecyclerView myRv;
    private ApplyMaterielAdapter applyMaterielAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_materiel_apply;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "物料申请");
    }

    @OnClick({R.id.tv_submit})
    public void onViewClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("type", "2");
        UiUtil.openActivity(this, ApplyMaterielActivity.class, bundle);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mPresenter.getPageList("1", "1000");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mPresenter.getPageList("1", "1000");
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void returnMaterielBean(ApplyMaterielBean applyMaterielBean) {
        if (applyMaterielBean != null) {
            List<ApplyMaterielBean.RecordsBean> records = applyMaterielBean.getRecords();
            applyMaterielAdapter = new ApplyMaterielAdapter(records);
            applyMaterielAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                    ApplyMaterielBean.RecordsBean item = applyMaterielAdapter.getItem(position);
                    int id = item.getId();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", id + "");
                    bundle.putString("type", "1");
                    UiUtil.openActivity(MaterielApplyListActivity.this, ApplyMaterielActivity.class, bundle);
                }
            });
            myRv.setLayoutManager(new LinearLayoutManager(this));
            myRv.setAdapter(applyMaterielAdapter);
        }

    }
}
