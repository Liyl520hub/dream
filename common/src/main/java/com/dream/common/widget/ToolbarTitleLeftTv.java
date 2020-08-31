package com.dream.common.widget;

import android.widget.ImageView;
import android.widget.TextView;

import com.dream.common.base.BaseActivity;
import com.dream.common.base.BaseToolbar;
import com.dream.common.callback.ToolbarConfig;


/**
 *
 * @author Administrator
 * @date 2018/3/27 0027
 * @Desc: 标题与左边文字的toolbar封装
 */

public class ToolbarTitleLeftTv extends BaseToolbar {

    private String mTitle;

    public ToolbarTitleLeftTv(BaseActivity activity, String tittle) {
        super(activity);
        this.mTitle = tittle;
    }

    @Override
    public ToolbarConfig getToolbarConfig() {
        return ToolbarConfig.LEFT_AND_TITLE;
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
