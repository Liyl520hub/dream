package com.dream.cleaner.ui.my.contract;

import com.dream.cleaner.beans.my.LeaveBean;
import com.dream.common.base.BaseContract;

/**
 * @author : Liyalei
 * date   : 2020/9/11
 * desc   :
 */
public interface StopReceivingOrdersActivityContract extends BaseContract {
    void returnLeaveBean(LeaveBean leaveBean);

    void returnApply(String leaveBean);

    void returnLeaveRecordsBean(LeaveBean.RecordsBean leaveBean);
}
