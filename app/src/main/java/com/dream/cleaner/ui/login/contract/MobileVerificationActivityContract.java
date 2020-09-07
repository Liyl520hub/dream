package com.dream.cleaner.ui.login.contract;

import com.dream.cleaner.beans.login.AgreementBean;
import com.dream.common.base.BaseContract;

/**
 * @author : Liyalei
 * date   : 2020/9/7
 * desc   :
 */
public interface MobileVerificationActivityContract extends BaseContract {
    void returnAgreementPhone(AgreementBean agreementBean);

}
