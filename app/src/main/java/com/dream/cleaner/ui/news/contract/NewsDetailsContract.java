package com.dream.cleaner.ui.news.contract;

import com.dream.cleaner.beans.news.NewsDetailsBean;
import com.dream.common.base.BaseContract;

/**
 * Create by moying
 * Creation time:2020/8/28
 * Class action:
 */
public interface NewsDetailsContract  extends BaseContract {
    void returnNewsDetails(NewsDetailsBean newsDetailsBean);
    void returnNewsDetailsRead(String string);

}
