package com.dream.cleaner.ui.login.contract;

import com.dream.cleaner.beans.login.AgreementBean;
import com.dream.cleaner.beans.login.LoginBean;
import com.dream.common.base.BaseContract;

/**
 * @author : admin
 * date   : 2020/8/16
 * desc   :
 */
public interface LoginContract extends BaseContract {

    void returnLoginBean(LoginBean loginBean);


    void returnAgreementBean(AgreementBean agreementBean,boolean isPrivacy);
}
