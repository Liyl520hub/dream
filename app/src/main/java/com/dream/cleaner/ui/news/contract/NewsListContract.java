package com.dream.cleaner.ui.news.contract;

import com.dream.cleaner.beans.news.NewsListBean;
import com.dream.common.base.BaseContract;

/**
 * @author : liyl
 * date   : 2020/9/9
 * desc   :
 */
public interface NewsListContract extends BaseContract {
    void returnNewsListBean(NewsListBean newsBean);
}
