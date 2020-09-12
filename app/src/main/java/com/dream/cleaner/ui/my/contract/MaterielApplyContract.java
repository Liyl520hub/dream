package com.dream.cleaner.ui.my.contract;

import com.dream.cleaner.beans.my.ApplyMaterielBean;
import com.dream.common.base.BaseContract;

/**
 * @author : Liyalei
 * date   : 2020/9/12
 * desc   :
 */
public interface MaterielApplyContract extends BaseContract {
    void returnMaterielBean(ApplyMaterielBean applyMaterielBean);
}
