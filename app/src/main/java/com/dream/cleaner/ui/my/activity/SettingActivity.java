package com.dream.cleaner.ui.my.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.CacheDiskStaticUtils;
import com.blankj.utilcode.util.CacheDiskUtils;
import com.blankj.utilcode.util.CacheDoubleStaticUtils;
import com.blankj.utilcode.util.CacheDoubleUtils;
import com.blankj.utilcode.util.CacheMemoryUtils;
import com.blankj.utilcode.util.CleanUtils;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.Utils;
import com.dream.cleaner.R;
import com.dream.cleaner.ui.login.activity.LoginActivity;
import com.dream.cleaner.ui.my.contract.SettingActivityContract;
import com.dream.cleaner.ui.my.presenter.SettingActivityPresenter;
import com.dream.cleaner.utils.InfoUtils;
import com.dream.cleaner.widget.pop.PopTip;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.http.error.ErrorType;
import com.dream.common.widget.SuperToast;
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
    private PopTip popCacheTip;
    private PopTip popLogoutTip;
    private PopTip popVersionTip;

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
        long cacheSize = CacheDiskUtils.getInstance(Utils.getApp().getCacheDir().getPath()).getCacheSize();
        tvCache.setText(cacheSize < 1024 ? "0MB" : ConvertUtils.byte2FitMemorySize(cacheSize));
        String userReceive = InfoUtils.getUserReceive();
        mySwitch.setChecked("0".equals(userReceive));
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mPresenter.updatePush(isChecked ? "0" : "1");
            }
        });
    }


    @OnClick({R.id.ll_cache, R.id.tv_logout, R.id.ll_version})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_cache:
                cleanCache();
                break;
            case R.id.ll_version:
                checkVersion();
                break;
            case R.id.tv_logout:
                logOut();
                break;
            default:
        }
    }

    private void checkVersion() {
        popVersionTip = new PopTip.Builder().
                setType(2).
                setMsg("有新版本可更新").
                setSubmitClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popVersionTip.dismiss();
                    }
                }).
                setCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popVersionTip.dismiss();
                    }
                }).
                setYesClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popVersionTip.dismiss();
                    }
                }).build(SettingActivity.this);
        popVersionTip.showPopupWindow();
    }

    private void cleanCache() {
        popCacheTip = new PopTip.Builder().
                setType(2).
                setMsg("是否清除应用缓存").
                setSubmitClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popCacheTip.dismiss();
                    }
                }).
                setCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popCacheTip.dismiss();
                    }
                }).
                setYesClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CacheDiskUtils.getInstance(Utils.getApp().getCacheDir().getPath()).clear();
                        tvCache.setText("0Mb");
                        popCacheTip.dismiss();
                    }
                }).build(SettingActivity.this);
        popCacheTip.showPopupWindow();
    }

    private void logOut() {
        popLogoutTip = new PopTip.Builder().
                setType(2).
                setMsg("您确定要注销登录吗").
                setSubmitClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popLogoutTip.dismiss();
                    }
                }).
                setCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popLogoutTip.dismiss();
                    }
                }).
                setYesClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.logout();
                        InfoUtils.clean();
                        popLogoutTip.dismiss();
                    }
                }).build(SettingActivity.this);
        popLogoutTip.showPopupWindow();
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void returnLogout(String loginBean) {
        InfoUtils.clean();
        ActivityUtils.startActivity(LoginActivity.class);
    }

    @Override
    public void returnUpdate(String string) {
//        SuperToast.showShortMessage("修改成功");
        InfoUtils.setUserReceive(mySwitch.isChecked() ? "0" : "1");

    }
}
