package com.dream.cleaner.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import com.blankj.utilcode.util.NetworkUtils;
import com.dream.cleaner.R;


public class EmptyLayout extends LinearLayout implements
        View.OnClickListener {// , ISkinUIObserver {

    public static final int HIDE_LAYOUT = 4;
    public static final int NETWORK_ERROR = 1;
    public static final int NETWORK_LOADING = 2;
    public static final int NODATA = 3;
    public static final int NODATA_ENABLE_CLICK = 5;
    public static final int NO_LOGIN = 6;
    //暂无内容 带返回按钮
    public static final int NODATA_BACK = 9;

    private ProgressBar animProgress;
    private boolean clickEnable = true;
    private final Context context;
    public ImageView img;
    public ImageView ivEpclose;
    private OnClickListener listener;
    private int mErrorState;
    private RelativeLayout mLayout;
    private String strNoDataContent = "";
    private TextView tv;
    private onEmptyClickListener onEmptyClickListener;

    public EmptyLayout(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public EmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public void setOnEmptyClickListener(EmptyLayout.onEmptyClickListener onEmptyClickListener) {
        this.onEmptyClickListener = onEmptyClickListener;
    }

    private void init() {
        View view = View.inflate(context, R.layout.view_error_layout, null);
        img = view.findViewById(R.id.img_error_layout);
        ivEpclose = view.findViewById(R.id.iv_ep_close);
        tv = view.findViewById(R.id.tv_error_layout);
        mLayout = view.findViewById(R.id.pageerrLayout);
        animProgress = view.findViewById(R.id.animProgress);
        setBackgroundColor(-1);
        setOnClickListener(this);
        img.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clickEnable) {
                    // setErrorType(NETWORK_LOADING);
                    if (listener != null) {
                        listener.onClick(v);
                    }
                }
            }
        });
        addView(view);
        changeErrorLayoutBgMode(context);
    }

    public void changeErrorLayoutBgMode(Context context1) {
        // mLayout.setBackgroundColor(SkinsUtil.getColor(context1,
        // "bgcolor01"));
        // tv.setTextColor(SkinsUtil.getColor(context1, "textcolor05"));
    }

    public void dismiss() {
        mErrorState = HIDE_LAYOUT;
        setVisibility(View.GONE);
    }

    public int getErrorState() {
        return mErrorState;
    }

    public boolean isLoadError() {
        return mErrorState == NETWORK_ERROR;
    }

    public boolean isLoading() {
        return mErrorState == NETWORK_LOADING;
    }

    @Override
    public void onClick(View v) {
        if (clickEnable) {
            // setErrorType(NETWORK_LOADING);
            if (listener != null) {
                listener.onClick(v);
            }
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        // MyApplication.getInstance().getAtSkinObserable().registered(this);
        onSkinChanged();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        // MyApplication.getInstance().getAtSkinObserable().unregistered(this);
    }

    public void onSkinChanged() {
        // mLayout.setBackgroundColor(SkinsUtil
        // .getColor(getContext(), "bgcolor01"));
        // tv.setTextColor(SkinsUtil.getColor(getContext(), "textcolor05"));
    }

    public void setDayNight(boolean flag) {
    }

    public void setErrorMessage(String msg) {
        tv.setText(msg);
    }

    /**
     * 新添设置背景
     *
     * @author 火蚁 2015-1-27 下午2:14:00
     */
    public void setErrorImag(int imgResource) {
        try {
            img.setImageResource(imgResource);
        } catch (Exception e) {
        }
    }


    /**
     * 设置背景颜色
     */
    public void setLayoutBackground(int color) {
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), color, null);
        mLayout.setBackground(drawable);
    }

    public void setErrorType(int i) {
        setVisibility(View.VISIBLE);
        switch (i) {
            case NETWORK_ERROR:
                mErrorState = NETWORK_ERROR;
                // img.setBackgroundDrawable(SkinsUtil.getDrawable(context,"pagefailed_bg"));
                if (NetworkUtils.isConnected()) {
                    tv.setText(R.string.error_view_load_error_click_to_refresh);
                    img.setBackgroundResource(R.drawable.pagefailed_bg);
                } else {
                    tv.setText(R.string.error_view_network_error_click_to_refresh);
                    img.setImageResource(R.mipmap.page_icon_network);
                }
                img.setVisibility(View.VISIBLE);
                animProgress.setVisibility(View.GONE);
                clickEnable = true;
                break;
            case NETWORK_LOADING:
                mErrorState = NETWORK_LOADING;
                // animProgress.setBackgroundDrawable(SkinsUtil.getDrawable(context,"loadingpage_bg"));
                animProgress.setVisibility(View.VISIBLE);
                img.setVisibility(View.GONE);
                tv.setText(R.string.error_view_loading);
                clickEnable = false;
                break;
            case NODATA:
                mErrorState = NODATA;
                // img.setBackgroundDrawable(SkinsUtil.getDrawable(context,"page_icon_empty"));
                img.setImageResource(R.mipmap.page_icon_empty);
                img.setVisibility(View.VISIBLE);
                animProgress.setVisibility(View.GONE);
                setTvNoDataContent();
                clickEnable = true;
                break;
            case HIDE_LAYOUT:
                setVisibility(View.GONE);
                break;
            case NODATA_ENABLE_CLICK:
                mErrorState = NODATA_ENABLE_CLICK;
                img.setImageResource(R.mipmap.page_icon_empty);
                // img.setBackgroundDrawable(SkinsUtil.getDrawable(context,"page_icon_empty"));
                img.setVisibility(View.VISIBLE);
                animProgress.setVisibility(View.GONE);
                setTvNoDataContent();
                clickEnable = true;
                break;
            case NODATA_BACK:
                //注意 使用此布局必须传返回按钮的监听事件
                mErrorState = NODATA_BACK;
                ivEpclose.setVisibility(VISIBLE);
                img.setImageResource(R.mipmap.page_icon_empty);
                img.setVisibility(View.VISIBLE);
                animProgress.setVisibility(View.GONE);
                setTvNoDataContent();
                clickEnable = true;
                ivEpclose.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onEmptyClickListener != null) {
                            onEmptyClickListener.onEmptyClick(v);
                        }
                    }
                });
                break;
            default:
                break;
        }
    }

    public void setNoDataContent(String noDataContent) {
        strNoDataContent = noDataContent;
    }

    public void setOnLayoutClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void setTvNoDataContent() {
        if (!strNoDataContent.equals("")) {
            tv.setText(strNoDataContent);
        } else {
            tv.setText(R.string.error_view_no_data);
        }
    }

    @Override
    public void setVisibility(int visibility) {
        if (visibility == View.GONE) {
            mErrorState = HIDE_LAYOUT;
        }
        super.setVisibility(visibility);
    }

    public interface onEmptyClickListener {

        void onEmptyClick(View v);
    }
}
