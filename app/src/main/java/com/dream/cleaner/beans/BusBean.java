package com.dream.cleaner.beans;

/**
 * @author : Liyalei
 * date   : 2020/9/1
 * desc   :eventBus的消息类
 */
public class BusBean {

    private String name;

    public BusBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }
}
