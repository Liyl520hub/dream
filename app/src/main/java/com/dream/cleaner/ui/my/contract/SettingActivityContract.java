package com.dream.cleaner.ui.my.contract;

import com.dream.common.base.BaseContract;

/**
 * @author : admin
 * date   : 2020/9/8
 * desc   :
 */
public interface SettingActivityContract extends BaseContract {
    void returnLogout(String loginBean);

    void returnUpdate(String string);
}
