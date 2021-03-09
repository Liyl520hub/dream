package com.dream.cleaner.ui.login.contract;

import com.dream.cleaner.beans.login.LoginBean;
import com.dream.common.base.BaseContract;

/**
 * @author : admin
 * date   : 2020/9/7
 * desc   :
 */
public interface ResetPasswordActivityContract extends BaseContract {
    void returnUpdatePassWordBean(LoginBean loginBean);

}
