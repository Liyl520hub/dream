package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.dream.cleaner.R;
import com.dream.cleaner.ui.login.activity.LoginActivity;
import com.dream.cleaner.ui.my.contract.SettingActivityContract;
import com.dream.cleaner.ui.my.presenter.SettingActivityPresenter;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.ToolbarBackTitle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author : liyl
 * date   : 2020/8/23
 * desc   :
 */
public class SettingActivity extends BaseActivity<SettingActivityPresenter> implements SettingActivityContract {
    @BindView(R.id.my_switch)
    Switch mySwitch;
    @BindView(R.id.ll_push)
    LinearLayout llPush;
    @BindView(R.id.tv_cache)
    TextView tvCache;
    @BindView(R.id.ll_cache)
    LinearLayout llCache;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.ll_version)
    LinearLayout llVersion;
    @BindView(R.id.tv_logout)
    TextView tvLogout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "系统设置");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }




    @OnClick({R.id.ll_cache, R.id.tv_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_cache:
                break;
            case R.id.tv_logout:
                mPresenter.logout();
                break;
            default:
        }
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void returnLogout(String loginBean) {
        ActivityUtils.startActivity(LoginActivity.class);

    }
}
