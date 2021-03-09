package com.dream.common.base;


import com.dream.common.http.error.ErrorType;

/**
 * @author admin
 */
public interface BaseContract {

    /**
     * 显示提示
     *
     * @param errorType 失败类型
     * @param errorCode 失败错误码
     * @param message   提示语
     */
    void showErrorTip(ErrorType errorType, int errorCode, String message);
}
