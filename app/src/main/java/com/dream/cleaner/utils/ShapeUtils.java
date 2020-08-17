package com.dream.cleaner.utils;

import android.graphics.drawable.GradientDrawable;

import androidx.core.content.res.ResourcesCompat;

import com.blankj.utilcode.util.Utils;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :代码编写shape
 */
public class ShapeUtils {


    public static int getColor(int color) {
        return ResourcesCompat.getColor(Utils.getApp().getResources(), color, null);
    }


    /**
     * 根据参数返回shape （GradientDrawable）
     *
     * @param bgColor     要设置的背景颜色
     * @param radius      要设置的圆角
     * @param strokeWidth 要设置的边缘线的宽 不设置请传0
     * @param strokeColor 要设置的边缘线的颜色
     * @return 矩形shape
     */
    public static GradientDrawable getDiyGradientDrawable(int bgColor, int radius, int strokeWidth, int strokeColor) {
        int bg = ResourcesCompat.getColor(Utils.getApp().getResources(), bgColor, null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        //设置shape颜色
        gradientDrawable.setColor(bg);
        //设置shape圆角
        gradientDrawable.setCornerRadius(radius);
        if (strokeWidth != 0) {
            int stroke = ResourcesCompat.getColor(Utils.getApp().getResources(), strokeColor, null);
            //设置边缘线的宽以及颜色bg
            gradientDrawable.setStroke(strokeWidth, stroke);
        }

        return gradientDrawable;
    }

    /**
     * 根据参数返回shape （GradientDrawable）
     *
     * @param bgColor     要设置的背景颜色
     * @param radius      要设置的圆角数组 最少4个 top-left, top-right, bottom-right, bottom-left
     * @param strokeWidth 要设置的边缘线的宽 不设置请传0
     * @param strokeColor 要设置的边缘线的颜色
     * @return 矩形shape
     */
    public static GradientDrawable getDiyGradientDrawable(int bgColor, float[] radius, int strokeWidth, int strokeColor) {
        int bg = ResourcesCompat.getColor(Utils.getApp().getResources(), bgColor, null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        //设置shape颜色
        gradientDrawable.setColor(bg);
        //设置shape圆角
        gradientDrawable.setCornerRadii(new float[]{radius[0], radius[0], radius[1], radius[1], radius[2], radius[2], radius[3], radius[3]});
        if (strokeWidth != 0) {
            int stroke = ResourcesCompat.getColor(Utils.getApp().getResources(), strokeColor, null);
            //设置边缘线的宽以及颜色bg
            gradientDrawable.setStroke(strokeWidth, stroke);
        }

        return gradientDrawable;
    }

}
