package com.dream.common.http;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.dream.common.R;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :网络加载框
 */
public class HttpCustomDialog extends Dialog {
    private String content;

    public HttpCustomDialog(Context context, String content) {
        super(context, R.style.CustomDialog);
        this.content = content;
        initView();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (isShowing()) {
                    dismiss();
                }
                break;
            default:
        }
        return true;
    }


    private void initView() {
        setContentView(R.layout.common_dialog_loading);
        ((TextView) findViewById(R.id.tvcontent)).setText(content);
        setCanceledOnTouchOutside(false);
//        Window window = ActivityUtils.getTopActivity().getWindow();
//        WindowManager.LayoutParams attributes = window.getAttributes();
//        attributes.alpha = 0.8f;
//        window.setAttributes(attributes);
        setCancelable(false);
    }

    /**
     * 显示dialog
     */
    public void showLoading() {
        if (!isShowing()) {
            show();
        }
    }

    /**
     * 关闭dialog
     */
    public void cancelLoading() {
        if (isShowing()) {
//            Window window = ActivityUtils.getTopActivity().getWindow();
//            WindowManager.LayoutParams attributes = window.getAttributes();
//            attributes.alpha = 1f;
//            window.setAttributes(attributes);
            cancel();
        }
    }
}

