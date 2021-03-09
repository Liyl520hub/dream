package com.dream.cleaner.beans;

/**
 * @author : admin
 * date   : 2020/9/1
 * desc   :eventBus的消息类
 */
public class BusBean {

    private String name;
    private String orderTypeId;
    private String serviceTypeId;
    private String orderStatus;

    public BusBean(String orderTypeId, String serviceTypeId) {
        this.orderTypeId = orderTypeId;
        this.serviceTypeId = serviceTypeId;
    }

    public String getOrderStatus() {
        return orderStatus == null ? "" : orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? "" : orderStatus;
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
