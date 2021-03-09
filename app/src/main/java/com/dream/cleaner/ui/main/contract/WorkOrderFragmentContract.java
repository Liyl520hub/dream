package com.dream.cleaner.ui.main.contract;

import com.dream.cleaner.beans.workorder.PopWorkOrderBean;
import com.dream.common.base.BaseContract;

import java.util.List;

/**
 * @author : admin
 * date   : 2020/9/15
 * desc   :
 */
public interface WorkOrderFragmentContract extends BaseContract {
    void returnPopWorkOrder(List<PopWorkOrderBean> list, boolean b);

}
