package com.dream.common.base;

import java.io.Serializable;

/**
 *
 * @author Administrator
 * @date 2020/8/15 0026
 * @Desc 接口返回数据JavaBean的基类，所有JavaBean务必继承该基类，方便封装错误统一处理
 */

public class BaseBean<T> implements Serializable {

    /**
     * time : 2020
     * message : 登录成功！
     * success : true
     * code : 0
     * data : {"id":45,"status":1,"username":"15835788167","password":"9cbf8a4dcb8e30682b927f352d6559a0","type":2,"schoolName":"","info":{"id":36,"createTime":"2018-09-07T02:09:13.000+0000","updateTime":"2018-09-07T02:09:13.000+0000","status":1,"userId":45,"nickname":"学员NRM2","values":[]}}
     */

    private boolean success;
    private String message;
    private String time;
    private int code;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message == null ? "" : message;
    }

    public String getTime() {
        return time == null ? "" : time;
    }

    public void setTime(String time) {
        this.time = time == null ? "" : time;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
