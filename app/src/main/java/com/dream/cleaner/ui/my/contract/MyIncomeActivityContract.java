package com.dream.cleaner.ui.my.contract;

import com.dream.cleaner.beans.my.MyIncomeBean;
import com.dream.cleaner.beans.my.MyIncomeListBean;
import com.dream.common.base.BaseContract;

/**
 * @author : Liyalei
 * date   : 2020/9/11
 * desc   :
 */
public interface MyIncomeActivityContract extends BaseContract {
    void returnMyIncome(MyIncomeBean myIncomeBean);

    void returnMyIncomeList(MyIncomeListBean myIncomeListBean);
}
