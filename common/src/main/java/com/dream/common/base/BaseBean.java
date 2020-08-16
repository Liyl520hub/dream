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
     * status : Success
     * msg : 登录成功！
     * errors : null
     * code : 0
     * returnValue : {"id":45,"status":1,"username":"15835788167","password":"9cbf8a4dcb8e30682b927f352d6559a0","type":2,"schoolName":"","info":{"id":36,"createTime":"2018-09-07T02:09:13.000+0000","updateTime":"2018-09-07T02:09:13.000+0000","status":1,"userId":45,"nickname":"学员NRM2","values":[]}}
     */

    private String status;
    private String msg;
    private Object errors;
    private int code;
    private T returnValue;

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(T returnValue) {
        this.returnValue = returnValue;
    }
}
