package com.dream.cleaner.ui.main.contract;

import com.dream.cleaner.beans.workorder.TaskDetailsBean;
import com.dream.common.base.BaseContract;

/**
 * @author : Liyalei
 * date   : 2020/9/10
 * desc   :
 */
public interface TaskDetailsActivityContract extends BaseContract {
    void returnTaskDetail(TaskDetailsBean taskDetailsBean);

    void returnTaskReceive(String s);
}
