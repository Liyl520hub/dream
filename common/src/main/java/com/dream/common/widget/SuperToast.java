package com.dream.common.widget;

import android.view.Gravity;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dream.common.R;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :封装吐司工具类
 */
public class SuperToast {

    public static void showShortMessage(String msg) {
        ToastUtils.setBgResource(R.drawable.common_shape_toast);
        ToastUtils.setMsgTextSize(16);
        ToastUtils.showShort(msg);
    }

    public static void showLongMessage(String msg) {
        ToastUtils.setBgResource(R.drawable.common_shape_toast);
        ToastUtils.setMsgTextSize(16);
        ToastUtils.showLong(msg);
    }
}
