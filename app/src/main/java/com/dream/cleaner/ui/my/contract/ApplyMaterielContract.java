package com.dream.cleaner.ui.my.contract;

import com.dream.cleaner.beans.my.ApplyMaterielBean;
import com.dream.cleaner.beans.my.MaterielBean;
import com.dream.cleaner.beans.my.MaterielTypeBean;
import com.dream.common.base.BaseContract;

import java.util.List;

/**
 * @author : admin
 * date   : 2020/9/12
 * desc   :
 */
public interface ApplyMaterielContract extends BaseContract {
    void returnMaterielBean(MaterielBean materielBean);

    void returnCollect(String string);

    void returnApplyMaterielBean(String s);

    void returnMaterielTypeBeans(List<MaterielTypeBean> list);
}
