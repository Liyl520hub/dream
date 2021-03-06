package com.dream.cleaner.ui.plan.contract;

import com.dream.cleaner.beans.PlanBean;
import com.dream.common.base.BaseContract;

import java.util.List;

/**
 * @author : admin
 * date   : 2020/9/9
 * desc   :
 */
public interface PlanFragmentContract  extends BaseContract {
    void returnCleanerPlan(List<PlanBean> list);

    void returnCleanerPlanDay(List<PlanBean.CleanerPlanItemsBean> list);
}
