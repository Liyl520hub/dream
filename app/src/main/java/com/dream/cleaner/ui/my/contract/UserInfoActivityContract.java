package com.dream.cleaner.ui.my.contract;

import com.dream.cleaner.beans.login.LoginBean;
import com.dream.common.base.BaseContract;

/**
 * @author : Liyalei
 * date   : 2020/9/11
 * desc   :
 */
public interface UserInfoActivityContract extends BaseContract {

    void returnUserInfoBean(LoginBean.CleanerBean cleanerBean);

}
