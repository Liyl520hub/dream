package com.dream.cleaner.ui.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dream.cleaner.R;
import com.dream.common.base.BaseActivity;
import com.dream.common.callback.MyToolbar;
import com.dream.common.widget.ToolbarBackTitle;

/**
 * @author Liyalei
 */
public class MainActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }


    @Override
    protected MyToolbar getMyToolbar() {
        return new ToolbarBackTitle(this, "保洁端");
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        setDoubleClickExit(true);
    }
}
