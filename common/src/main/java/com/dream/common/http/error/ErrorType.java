package com.dream.common.http.error;

/**
 * Created by Administrator on 2018/1/18 0018.
 */

public enum ErrorType {

    //未知错误
    ERROR_UNKNOWN,

    //retrunValue空异常
    ERROR_NULL,

    //未知http错误
    ERROR_UNKNOWN_HTTP,

    //数据解析错误
    ERROR_PARSE,

    //网络错误
    ERROR_NETWORK,

    //http错误
    ERROR_HTTP,

    //接口返回的业务错误
    ERROR_API;


}
