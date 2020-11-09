package com.dream.cleaner.ui.my.contract;

import com.dream.cleaner.beans.my.CleanerOrderCountBean;
import com.dream.common.base.BaseContract;

/**
 * @author : Liyalei
 * date   : 2020/9/11
 * desc   :
 */
public interface UserFragmentContract extends BaseContract {

    void returnCleanerOrderCountBean(CleanerOrderCountBean cleanerOrderCountBean);

}
