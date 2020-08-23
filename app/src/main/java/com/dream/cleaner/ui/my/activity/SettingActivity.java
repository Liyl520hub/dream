package com.dream.cleaner.ui.my.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.dream.cleaner.R;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarBackTitle;

/**
 * @author : liyl
 * date   : 2020/8/23
 * desc   :
 */
public class SettingActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this,"系统设置");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }
}
