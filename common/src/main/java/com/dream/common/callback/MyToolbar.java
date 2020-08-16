package com.dream.common.callback;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;


/**
 * @author Administrator
 * @date 20200816
 * @Desc： Toolbar的接口
 */

public interface MyToolbar {

    Toolbar getToolbar();

    ToolbarConfig getToolbarConfig();

    String getTitle();

    void getTitleTextView(TextView mTitleTextView);

    void getTitleLeftView(ImageView mImageView);

    Drawable getToolbarRightDrawable();

    void onTitleClicked(String tittle);

    void onRightImageClicked();
}
