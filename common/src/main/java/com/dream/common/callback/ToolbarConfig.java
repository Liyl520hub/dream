package com.dream.common.callback;

/**
 * Created by Administrator on 2018/1/12 0012.
 *
 * @Desc 用于设置Toolbar的模式
 */

public enum ToolbarConfig {
    /**
     * 仅有返回按键
     */
    JUST_BACK,
    /**
     * 仅有返回按键,背景为白色的
     */
    JUST_BACK_WHITE,
    /**
     * 返回按键和标题
     */
    BACK_WITH_TITLE,
    /**
     * 绿色返回按键和黑色标题，白色背景
     */
    BACK_WITH_TITLE_WHITE,

    /**
     * 黑色返回按键和黑色标题，白色背景
     */
    BACK_WITH_TITLE_WHITE_BACK_ICON,
    /**
     * 绿色返回按键和黑色标题，白色背景，右侧文本
     */
    BACK_WITH_TITLE_WHITE_RIGHT_TEXT,
    /**
     * 仅有标题
     */
    JUST_TITLE,
    /**
     * 左侧文字与中间标题
     */
    LEFT_AND_TITLE,
    /**
     * 仅有右侧文字
     */
    JUST_RIGHT,
    /**
     * 常规，返回按键、标题、右侧图片
     */
    NORMAL;
}
