package com.dream.common.base;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import com.blankj.utilcode.util.ClickUtils;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.dream.common.R;
import com.dream.common.callback.MyToolbar;

/**
 * Created by Administrator on 2018/3/27 0027.
 *
 * @Desc: Toolbar封装基类
 */

public abstract class BaseToolbar implements MyToolbar {

    protected BaseActivity mActivity;
    private ImageView mLeftImage;
    private Toolbar default_toolbar;
    private Toolbar mToolbarView;
    private int background;
    private TextView mTitleText;
    private TextView mLeftText;
    private ImageView mRightImage;

    public BaseToolbar(BaseActivity activity) {
        this.mActivity = activity;
    }

    /**
     * 对于使用默认布局的toolbar，继承该类的子类请谨慎重写该方法
     * 重写需要针对特定情境实现完成整逻辑
     *
     * @return
     */
    @Override
    public Toolbar getToolbar() {
        mToolbarView = (Toolbar) View.inflate(mActivity, R.layout.common_view_default_toolbar, null);
        default_toolbar = mToolbarView.findViewById(R.id.default_toolbar);
        mLeftImage = mToolbarView.findViewById(R.id.default_toolbar_left_image);
        mLeftText = mToolbarView.findViewById(R.id.default_toolbar_left_text);
        getTitleLeftView(mLeftImage);
        mTitleText = mToolbarView.findViewById(R.id.default_toolbar_title);
        mRightImage = mToolbarView.findViewById(R.id.default_toolbar_right_image);
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, ConvertUtils.dp2px(42));
        mToolbarView.setLayoutParams(params);
        switch (getToolbarConfig()) {
            case JUST_BACK:
                mLeftImage.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.GONE);
                mRightImage.setVisibility(View.GONE);
                initBackImageListener();
                break;
            case JUST_BACK_WHITE:
                Drawable drawable1 = ResourcesCompat.getDrawable(mActivity.getResources(), R.color.white, null);
                default_toolbar.setBackground(drawable1);
                mLeftImage.setImageResource(R.drawable.common_finish_black);
                mLeftImage.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.GONE);
                mRightImage.setVisibility(View.GONE);
                initBackImageListener();
                break;
            case JUST_TITLE:
                mLeftImage.setVisibility(View.GONE);
                mTitleText.setVisibility(View.VISIBLE);
                mRightImage.setVisibility(View.GONE);
                mTitleText.setText(getTitle());
                getTitleTextView(mTitleText);
                initTitleClickListener();
                break;
            case LEFT_AND_TITLE:
                mLeftImage.setVisibility(View.GONE);
                mLeftText.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.VISIBLE);
                mRightImage.setVisibility(View.GONE);
                mTitleText.setText(getTitle());
                getTitleTextView(mTitleText);
                initTitleClickListener();
                break;
            case BACK_WITH_TITLE:
                mLeftImage.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.VISIBLE);
                mRightImage.setVisibility(View.GONE);
                mTitleText.setText(getTitle());
                getTitleTextView(mTitleText);
                initBackImageListener();
                initTitleClickListener();
                break;
            case NORMAL:
                mLeftImage.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.VISIBLE);
                mRightImage.setVisibility(View.VISIBLE);

                if (getToolbarRightDrawable() != null) {
                    mRightImage.setImageDrawable(getToolbarRightDrawable());
                }

                mTitleText.setText(getTitle());
                getTitleTextView(mTitleText);
                initBackImageListener();
                initTitleClickListener();
                initRightImageClickListener();
                break;

            default:
        }
        if (background != 0) {
            mToolbarView.setBackgroundColor(background);
        }
        return mToolbarView;
    }

    @Override
    public void getTitleTextView(TextView mTitleTextView) {
        LogUtils.e("getTitleTextView");
    }

    @Override
    public void getTitleLeftView(ImageView mImageView) {
    }

    /**
     * 不使用drawable请传递null
     *
     * @return
     */
    @Override
    public Drawable getToolbarRightDrawable() {
        return null;
    }

    /**
     * 标题点击空实现，有需要点击事件的界面重写该方法
     *
     * @param title
     */
    @Override
    public void onTitleClicked(String title) {

    }

    /**
     * 右侧图标点击空实现，有需要点击事件的界面重写该方法
     */
    @Override
    public void onRightImageClicked() {

    }

    /**
     * 初始化返回按键点击事件
     */
    private void initBackImageListener() {
        ClickUtils.applySingleDebouncing(mLeftImage, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.onBackPressed();
            }
        });
    }

    /**
     * 初始化标题点击事件
     */
    private void initTitleClickListener() {
        ClickUtils.applySingleDebouncing(mTitleText, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTitleClicked(mTitleText.getText().toString());
            }
        });
    }

    /**
     * 初始化右侧图标点击事件
     */
    private void initRightImageClickListener() {
        ClickUtils.applySingleDebouncing(mRightImage, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRightImageClicked();
            }
        });
    }

    public BaseToolbar setBackground(int color) {
        background = color;
        return this;
    }

    public BaseToolbar setTitle(String title) {
        mTitleText.setText(title);
        return this;
    }

    public BaseToolbar setLiftTitle(String title) {
        mLeftText.setText(title);
        return this;
    }
}
