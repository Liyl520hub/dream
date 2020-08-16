package com.dream.common.callback;

/**
 * Created by Administrator on 2018/3/27 0027.
 * @Desc： Toolbar的接口
 */

public interface MyToolbarRight extends MyToolbar {
    void setRightTitle(String rightTitle);
    String getRightTitle();
    void onRightTitleClicked();
}
