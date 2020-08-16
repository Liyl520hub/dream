package com.dream.common.base;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.appcompat.widget.Toolbar;

import com.blankj.utilcode.util.ClickUtils;
import com.blankj.utilcode.util.ColorUtils;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.dream.common.R;
import com.dream.common.baserx.RxClickTransformer;
import com.dream.common.callback.MyToolbarRight;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/3/27 0027.
 *
 * @Desc: Toolbar封装基类
 */

public abstract class BaseRightToolbar implements MyToolbarRight {

    protected BaseActivity mActivity;
    protected ImageView mLeftImage;
    protected TextView mTitleText;
    protected TextView tvRight;
    protected ImageView mRightImage;
    protected Toolbar mToolbarView;
    protected RelativeLayout mRightImageRl;
    private int background;

    public BaseRightToolbar(BaseActivity activity) {
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
        mLeftImage = mToolbarView.findViewById(R.id.default_toolbar_left_image);
        mTitleText = mToolbarView.findViewById(R.id.default_toolbar_title);
        mRightImage = mToolbarView.findViewById(R.id.default_toolbar_right_image);
        mRightImageRl = mToolbarView.findViewById(R.id.default_toolbar_right_image_rl);
        tvRight = mToolbarView.findViewById(R.id.tv_right);
        mTitleText.setTextSize(19);
        tvRight.setTextSize(16);
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, ConvertUtils.dp2px(42));
        mToolbarView.setLayoutParams(params);
        switch (getToolbarConfig()) {
            case JUST_BACK:
                mLeftImage.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.GONE);
                mRightImage.setVisibility(View.GONE);
                mRightImageRl.setVisibility(View.GONE);
                initBackImageListener();
                break;
            case JUST_TITLE:
                mLeftImage.setVisibility(View.GONE);
                mTitleText.setVisibility(View.VISIBLE);
                mRightImage.setVisibility(View.GONE);
                mRightImageRl.setVisibility(View.GONE);
                mTitleText.setText(getTitle());
                getTitleTextView(mTitleText);
                initTitleClickListener();
                break;
            case BACK_WITH_TITLE:
                mLeftImage.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.VISIBLE);
                mRightImage.setVisibility(View.GONE);
                mRightImageRl.setVisibility(View.GONE);
                mTitleText.setText(getTitle());
                getTitleTextView(mTitleText);

                initBackImageListener();
                initTitleClickListener();
                break;
            case NORMAL:
                mLeftImage.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.VISIBLE);
                mRightImage.setVisibility(View.VISIBLE);
                mRightImageRl.setVisibility(View.VISIBLE);

                if (getToolbarRightDrawable() != null) {
                    mRightImage.setImageDrawable(getToolbarRightDrawable());
                }

                mTitleText.setText(getTitle());
                getTitleTextView(mTitleText);
                initBackImageListener();
                initTitleClickListener();
                initRightImageClickListener();
                break;
            case JUST_RIGHT:
                mLeftImage.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.VISIBLE);
                tvRight.setVisibility(View.VISIBLE);
                mRightImage.setVisibility(View.GONE);
                mRightImageRl.setVisibility(View.GONE);
                mTitleText.setText(getTitle());
                tvRight.setText(getRightTitle());
                getTitleTextView(mTitleText);
                initBackImageListener();
                initTitleClickListener();
                initRightTitleClickListener();
                break;
            default:
        }
        if (background != 0) {
            if (background == ColorUtils.getColor(R.color.white)) {
                mLeftImage.setImageResource(R.drawable.common_finish_black);
            }
            mToolbarView.setBackgroundColor(background);
        }
        return mToolbarView;
    }

    @Override
    public void getTitleTextView(TextView mTitleTextView) {
        LogUtils.e("getTitleTextView");
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

    @Override
    public void setRightTitle(String rightTile) {
        mTitleText.setText(rightTile);
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
        ClickUtils.applySingleDebouncing(mRightImageRl, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRightImageClicked();
            }
        });

    }

    /**
     * 初始化右侧图标点击事件
     */
    private void initRightTitleClickListener() {
        ClickUtils.applySingleDebouncing(tvRight, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRightTitleClicked();
            }
        });

    }

    public TextView getTvRight() {
        return tvRight;
    }

    public BaseRightToolbar setBackground(int color) {
        background = color;
        return this;
    }
}
