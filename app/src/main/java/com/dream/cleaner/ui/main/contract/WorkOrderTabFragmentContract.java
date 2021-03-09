package com.dream.cleaner.ui.main.contract;

import com.dream.cleaner.beans.workorder.WorkOrderTabBean;
import com.dream.common.base.BaseContract;

/**
 * @author : admin
 * date   : 2020/9/9
 * desc   :
 */
public interface WorkOrderTabFragmentContract extends BaseContract {
    void returnTaskList(WorkOrderTabBean loginBean);

    void returnTaskReceive(String s);
}
