package com.dream.common.widget;

import android.widget.ImageView;
import android.widget.TextView;

import com.dream.common.base.BaseActivity;
import com.dream.common.base.BaseToolbar;
import com.dream.common.callback.ToolbarConfig;


/**
 * Created by Administrator on 2018/3/27 0027.
 * @Desc: 只有标题的toolbar封装
 */

public class ToolbarTitle extends BaseToolbar {

    private String mTitle;

    public ToolbarTitle(BaseActivity activity, String tittle) {
        super(activity);
        this.mTitle = tittle;
    }

    @Override
    public ToolbarConfig getToolbarConfig() {
        return ToolbarConfig.JUST_TITLE;
    }

    @Override
    public void getTitleTextView(TextView mTitleTextView) {
        super.getTitleTextView(mTitleTextView);
    }

    @Override
    public void getTitleLeftView(ImageView mImageView) {
        super.getTitleLeftView(mImageView);
    }

    @Override
    public String getTitle() {
        return mTitle;
    }
}