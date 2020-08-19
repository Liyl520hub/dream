package com.dream.cleaner.beans.workorder;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :工单下拉框bean
 */
public class PopWorkOrderBean {
    private String name;


    public PopWorkOrderBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
