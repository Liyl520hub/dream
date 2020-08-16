package com.dream.cleaner.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import androidx.fragment.app.FragmentActivity;
import com.dream.cleaner.R;


/**
 * ui操作工具类
 *
 * @author Liyalei
 */
public class UiUtil {


    // -------------------下面几个跳转界面方法，代码中intent跳转都用该方法，保证界面切换动画一致－－－－－－－－－

    /**
     * 跳转界面
     *
     * @param context
     * @param pClass
     */
    public static void openActivity(Activity context, Class<?> pClass) {
        openActivity(context, pClass, null);
    }

    /**
     * 跳转界面
     *
     * @param context
     * @param pClass
     */
    public static void openActivity(Activity context, Class<?> pClass,
                                    Bundle pBundle) {
        Intent intent = new Intent(context, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        context.startActivity(intent);
        context.overridePendingTransition(
                R.anim.translate_between_interface_right_in,
                R.anim.translate_between_interface_left_out);

    }

    /**
     * 跳转界面
     *
     * @param context
     * @param pAction
     */
    public static void openActivity(Activity context, String pAction) {
        openActivity(context, pAction, null);
    }

    /**
     * 跳转界面
     *
     * @param context
     * @param pAction
     */
    public static void openActivity(Activity context, String pAction,
                                    Bundle pBundle) {
        Intent intent = new Intent(pAction);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        context.startActivity(intent);
        context.overridePendingTransition(
                R.anim.translate_between_interface_right_in,
                R.anim.translate_between_interface_left_out);

    }


    /**
     * 跳转界面
     *
     * @param context
     * @param intent
     */
    public static void openActivityForResult(Activity context, Intent intent,
                                             int requestCode) {
        context.startActivityForResult(intent, requestCode);
        context.overridePendingTransition(
                R.anim.translate_between_interface_right_in,
                R.anim.translate_between_interface_left_out);

    }

    /**
     * 跳转界面
     *
     * @param context
     * @param intent
     */
    public static void openActivityForResult(FragmentActivity context, Intent intent,
                                             int requestCode) {
        context.startActivityForResult(intent, requestCode);
        context.overridePendingTransition(
                R.anim.translate_between_interface_right_in,
                R.anim.translate_between_interface_left_out);

    }

}
