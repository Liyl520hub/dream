package com.dream.cleaner.beans;

/**
 * @author : Liyalei
 * date   : 2020/9/1
 * desc   :eventBus的消息类
 */
public class BusBean {

    private String name;
    private String orderTypeId;
    private String serviceTypeId;

    public BusBean(String orderTypeId, String serviceTypeId) {
        this.orderTypeId = orderTypeId;
        this.serviceTypeId = serviceTypeId;
    }

    public String getOrderTypeId() {
        return orderTypeId == null ? "" : orderTypeId;
    }

    public void setOrderTypeId(String orderTypeId) {
        this.orderTypeId = orderTypeId == null ? "" : orderTypeId;
    }

    public String getServiceTypeId() {
        return serviceTypeId == null ? "" : serviceTypeId;
    }

    public void setServiceTypeId(String serviceTypeId) {
        this.serviceTypeId = serviceTypeId == null ? "" : serviceTypeId;
    }

    public BusBean(String name) {
        this.name = name;
    }

    public BusBean() {
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }
}
