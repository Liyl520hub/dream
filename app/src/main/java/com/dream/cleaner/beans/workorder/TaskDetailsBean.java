package com.dream.cleaner.beans.workorder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Liyalei
 * date   : 2020/9/10
 * desc   :
 */
public class TaskDetailsBean {

    /**
     * orderId : 26
     * contactAddress : 中国,北京,北京市,东城区建兴路27号
     * serviceName : null
     * serviceProperty : null
     * serviceTime : 2020-11-12 14:00:00
     * contacts : 马云
     * contactNo : 12345678901
     * specialRequest : null
     * orderNo : 1302201054640869376
     * servicePrice : 200
     * orderStatus : 9
     * suppleRefundType : 0
     * suppleRefundTPrice : 199
     * explain : 订单取消
     * explainPicList : []
     * beforePicList : []
     * remark : null
     * afterPicList : []
     * serviceReplenish : null
     * afterSale : {"id":6,"orderNo":"1302201054640869376","saleOrderNo":"SH0000000005","newOrderNo":"1303157338601033728","userId":null,"contacts":"马云","contactNumber":"12345678901","serviceId":7,"cleanerId":null,"cleanerName":null,"cleanerPhone":null,"refundPrice":null,"postReason":"1111111","salePostTime":"2020-09-08 10:24:56","dealTime":"2020-09-08 10:24:56","saleType":0,"reason":null,"saleStatus":0,"isDel":0,"createTime":"2020-09-08 10:24:55","updateTime":"2020-09-08 14:06:14"}
     */

    private int orderId;
    private String contactAddress;
    private String serviceName;
    private String serviceProperty;
    private String serviceTime;
    private String contacts;
    private String contactNo;
    private String specialRequest;
    private String orderNo;
    private int servicePrice;
    private int orderStatus;
    private int suppleRefundType;
    private int suppleRefundTPrice;
    private String explain;
    private String remark;
    private String serviceReplenish;
    private AfterSaleBean afterSale;
    private List<?> explainPicList;
    private List<?> beforePicList;
    private List<?> afterPicList;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getContactAddress() {
        return contactAddress == null ? "" : contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? "" : contactAddress;
    }

    public String getServiceName() {
        return serviceName == null ? "" : serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? "" : serviceName;
    }

    public String getServiceProperty() {
        return serviceProperty == null ? "" : serviceProperty;
    }

    public void setServiceProperty(String serviceProperty) {
        this.serviceProperty = serviceProperty == null ? "" : serviceProperty;
    }

    public String getServiceTime() {
        return serviceTime == null ? "" : serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime == null ? "" : serviceTime;
    }

    public String getContacts() {
        return contacts == null ? "" : contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? "" : contacts;
    }

    public String getContactNo() {
        return contactNo == null ? "" : contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo == null ? "" : contactNo;
    }

    public String getSpecialRequest() {
        return specialRequest == null ? "" : specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest == null ? "" : specialRequest;
    }

    public String getOrderNo() {
        return orderNo == null ? "" : orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? "" : orderNo;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getSuppleRefundType() {
        return suppleRefundType;
    }

    public void setSuppleRefundType(int suppleRefundType) {
        this.suppleRefundType = suppleRefundType;
    }

    public int getSuppleRefundTPrice() {
        return suppleRefundTPrice;
    }

    public void setSuppleRefundTPrice(int suppleRefundTPrice) {
        this.suppleRefundTPrice = suppleRefundTPrice;
    }

    public String getExplain() {
        return explain == null ? "" : explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? "" : explain;
    }

    public String getRemark() {
        return remark == null ? "" : remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? "" : remark;
    }

    public String getServiceReplenish() {
        return serviceReplenish == null ? "" : serviceReplenish;
    }

    public void setServiceReplenish(String serviceReplenish) {
        this.serviceReplenish = serviceReplenish == null ? "" : serviceReplenish;
    }

    public AfterSaleBean getAfterSale() {
        return afterSale;
    }

    public void setAfterSale(AfterSaleBean afterSale) {
        this.afterSale = afterSale;
    }

    public List<?> getExplainPicList() {
        if (explainPicList == null) {
            return new ArrayList<>();
        }
        return explainPicList;
    }

    public void setExplainPicList(List<?> explainPicList) {
        this.explainPicList = explainPicList;
    }

    public List<?> getBeforePicList() {
        if (beforePicList == null) {
            return new ArrayList<>();
        }
        return beforePicList;
    }

    public void setBeforePicList(List<?> beforePicList) {
        this.beforePicList = beforePicList;
    }

    public List<?> getAfterPicList() {
        if (afterPicList == null) {
            return new ArrayList<>();
        }
        return afterPicList;
    }

    public void setAfterPicList(List<?> afterPicList) {
        this.afterPicList = afterPicList;
    }

    public static class AfterSaleBean {
        /**
         * id : 6
         * orderNo : 1302201054640869376
         * saleOrderNo : SH0000000005
         * newOrderNo : 1303157338601033728
         * userId : null
         * contacts : 马云
         * contactNumber : 12345678901
         * serviceId : 7
         * cleanerId : null
         * cleanerName : null
         * cleanerPhone : null
         * refundPrice : null
         * postReason : 1111111
         * salePostTime : 2020-09-08 10:24:56
         * dealTime : 2020-09-08 10:24:56
         * saleType : 0
         * reason : null
         * saleStatus : 0
         * isDel : 0
         * createTime : 2020-09-08 10:24:55
         * updateTime : 2020-09-08 14:06:14
         */

        private int id;
        private String orderNo;
        private String saleOrderNo;
        private String newOrderNo;
        private String userId;
        private String contacts;
        private String contactNumber;
        private int serviceId;
        private String cleanerId;
        private String cleanerName;
        private String cleanerPhone;
        private String refundPrice;
        private String postReason;
        private String salePostTime;
        private String dealTime;
        private int saleType;
        private String reason;
        private int saleStatus;
        private int isDel;
        private String createTime;
        private String updateTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderNo() {
            return orderNo == null ? "" : orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo == null ? "" : orderNo;
        }

        public String getSaleOrderNo() {
            return saleOrderNo == null ? "" : saleOrderNo;
        }

        public void setSaleOrderNo(String saleOrderNo) {
            this.saleOrderNo = saleOrderNo == null ? "" : saleOrderNo;
        }

        public String getNewOrderNo() {
            return newOrderNo == null ? "" : newOrderNo;
        }

        public void setNewOrderNo(String newOrderNo) {
            this.newOrderNo = newOrderNo == null ? "" : newOrderNo;
        }

        public String getUserId() {
            return userId == null ? "" : userId;
        }

        public void setUserId(String userId) {
            this.userId = userId == null ? "" : userId;
        }

        public String getContacts() {
            return contacts == null ? "" : contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts == null ? "" : contacts;
        }

        public String getContactNumber() {
            return contactNumber == null ? "" : contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber == null ? "" : contactNumber;
        }

        public int getServiceId() {
            return serviceId;
        }

        public void setServiceId(int serviceId) {
            this.serviceId = serviceId;
        }

        public String getCleanerId() {
            return cleanerId == null ? "" : cleanerId;
        }

        public void setCleanerId(String cleanerId) {
            this.cleanerId = cleanerId == null ? "" : cleanerId;
        }

        public String getCleanerName() {
            return cleanerName == null ? "" : cleanerName;
        }

        public void setCleanerName(String cleanerName) {
            this.cleanerName = cleanerName == null ? "" : cleanerName;
        }

        public String getCleanerPhone() {
            return cleanerPhone == null ? "" : cleanerPhone;
        }

        public void setCleanerPhone(String cleanerPhone) {
            this.cleanerPhone = cleanerPhone == null ? "" : cleanerPhone;
        }

        public String getRefundPrice() {
            return refundPrice == null ? "" : refundPrice;
        }

        public void setRefundPrice(String refundPrice) {
            this.refundPrice = refundPrice == null ? "" : refundPrice;
        }

        public String getPostReason() {
            return postReason == null ? "" : postReason;
        }

        public void setPostReason(String postReason) {
            this.postReason = postReason == null ? "" : postReason;
        }

        public String getSalePostTime() {
            return salePostTime == null ? "" : salePostTime;
        }

        public void setSalePostTime(String salePostTime) {
            this.salePostTime = salePostTime == null ? "" : salePostTime;
        }

        public String getDealTime() {
            return dealTime == null ? "" : dealTime;
        }

        public void setDealTime(String dealTime) {
            this.dealTime = dealTime == null ? "" : dealTime;
        }

        public int getSaleType() {
            return saleType;
        }

        public void setSaleType(int saleType) {
            this.saleType = saleType;
        }

        public String getReason() {
            return reason == null ? "" : reason;
        }

        public void setReason(String reason) {
            this.reason = reason == null ? "" : reason;
        }

        public int getSaleStatus() {
            return saleStatus;
        }

        public void setSaleStatus(int saleStatus) {
            this.saleStatus = saleStatus;
        }

        public int getIsDel() {
            return isDel;
        }

        public void setIsDel(int isDel) {
            this.isDel = isDel;
        }

        public String getCreateTime() {
            return createTime == null ? "" : createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime == null ? "" : createTime;
        }

        public String getUpdateTime() {
            return updateTime == null ? "" : updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime == null ? "" : updateTime;
        }
    }

}
