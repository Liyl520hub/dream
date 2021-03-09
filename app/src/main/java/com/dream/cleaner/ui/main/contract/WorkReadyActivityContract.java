package com.dream.cleaner.ui.main.contract;

import com.dream.common.base.BaseContract;

/**
 * @author : admin
 * date   : 2020/9/15
 * desc   :
 */
public interface WorkReadyActivityContract extends BaseContract {
    void returnUpLoadImageStatus(String 无网络, String s, boolean isSaoQianZhunBei);

    void returnBeforeClean(String s);
}
