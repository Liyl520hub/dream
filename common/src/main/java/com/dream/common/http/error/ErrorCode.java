package com.dream.common.http.error;

/**
 * Created by Administrator on 2018/1/18 0018.
 * 网络请求错误码
 */

public class ErrorCode {


    /**
     * 未知错误
     */
    public static final int CODE_UNKNOWN = 1000000;

    /**
     * data为空
     */
    public static final int CODE_NULL = 1000010;

    /**
     * 解析错误
     */
    public static final int CODE_PARSE = 10000001;

    /**
     * 网络连接错误
     */
    public static final int CODE_NETWORK = 10000002;

    /**
     * 错误码
     */
    public static final int CODE_FORBIDDEN = 403;

    public static final int CODE_NOT_FOUND = 404;

    public static final int CODE_REQUEST_TIMEOUT = 408;

    public static final int CODE_INTERNAL_SERVER_ERROR = 500;

    public static final int CODE_BAD_GATEWAY = 502;

    public static final int CODE_SERVICE_UNAVAILABLE = 503;

    public static final int CODE_GATEWAY_TIMEOUT = 504;

    /**
     * 接口定义错误码
     * <p>
     * 优先判断status 三种 Success Failure SystemException
     * 再细分判断 code
     */

    public static final String SERVER_STATUS_SUCCESS = "Success";

    public static final String SERVER_STATUS_FAILURE = "Failure";

    public static final String SERVER_STATUS_SYSTEM_EXCEPTION = "SystemException";

    public static final int SERVER_ERROR_CODE_9111 = 9111;


    public static final int CODE_UNAUTHORIZED = 9112;
    public static final int SERVER_ERROR_CODE_10007 = 10007;
}
