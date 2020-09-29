package com.dream.cleaner.beans.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Liyalei
 * date   : 2020/9/13
 * desc   :
 */
public class MyIncomeListBean {


    /**
     * total : 3
     * records : [{"id":58,"orderNo":"1303157338601033728","contractType":1,"userId":25,"cycleServiceId":null,"memberName":"测试企业新增","memberPhone":"联系号码","specialAreaId":null,"contacts":"马云","provinceName":null,"cityName":null,"countyId":110101,"countyName":null,"contactAddress":"建兴路27号","placeOrderUser":null,"placeOrderUsername":null,"serviceItemsId":7,"serviceItemsName":"测试1","serviceTypeName":"父级分类","serviceTimes":3,"serviceAddress":"中国,北京,北京市,东城区建兴路27号","contactNo":"12345678901","serviceTime":"2020-09-15 00:00:00","serviceUnit":"台","serviceNum":null,"serviceProperty":"单开门,双开门,多开门,","cycleFlag":0,"cleanerId":1,"cleanerName":"qqqaaa","cleanerPhone":"111111111","areaName":"马家堡","paymentMethod":"微信支付","paymentTime":null,"paymentSeq":null,"suppleReason":null,"refundReason":null,"serviceEvalua":null,"cleanerEvalua":null,"description":null,"inputFlag":1,"type":null,"orderStatus":7,"orderStatusStr":"用户确认已完成","servicePrice":200,"favourablePrice":null,"paymentPrice":null,"placeOrderTime":"2020-09-05 19:05:01","endTime":null,"serviceReplenish":null,"specialRequest":null,"remark":null,"isDel":0,"createTime":"2020-09-05 19:05:01","updateTime":"2020-09-12 21:16:06","pmsServiceRelationTypeList":null,"visitFee":null,"cancleTime":null,"cancleReason":"11111"},{"id":59,"orderNo":"1303157535674601472","contractType":1,"userId":25,"cycleServiceId":null,"memberName":"测试企业新增","memberPhone":"联系号码","specialAreaId":null,"contacts":"马云","provinceName":null,"cityName":null,"countyId":110101,"countyName":null,"contactAddress":"建兴路27号","placeOrderUser":null,"placeOrderUsername":null,"serviceItemsId":7,"serviceItemsName":"测试1","serviceTypeName":"父级分类","serviceTimes":3,"serviceAddress":"中国,北京,北京市,东城区建兴路27号","contactNo":"12345678901","serviceTime":"2020-09-22 00:00:00","serviceUnit":"台","serviceNum":null,"serviceProperty":"单开门,双开门,多开门,","cycleFlag":0,"cleanerId":1,"cleanerName":"qqqaaa","cleanerPhone":"111111111","areaName":"马家堡","paymentMethod":"微信支付","paymentTime":null,"paymentSeq":null,"suppleReason":null,"refundReason":null,"serviceEvalua":null,"cleanerEvalua":null,"description":null,"inputFlag":1,"type":null,"orderStatus":7,"orderStatusStr":"用户确认已完成","servicePrice":200,"favourablePrice":null,"paymentPrice":null,"placeOrderTime":"2020-09-05 19:05:01","endTime":null,"serviceReplenish":null,"specialRequest":null,"remark":null,"isDel":0,"createTime":"2020-09-05 19:05:01","updateTime":"2020-09-12 21:16:01","pmsServiceRelationTypeList":null,"visitFee":null,"cancleTime":null,"cancleReason":"11111"},{"id":60,"orderNo":"1303195577424678912","contractType":1,"userId":25,"cycleServiceId":null,"memberName":"测试企业新增","memberPhone":"联系号码","specialAreaId":null,"contacts":"马云","provinceName":null,"cityName":null,"countyId":110101,"countyName":null,"contactAddress":"建兴路27号","placeOrderUser":null,"placeOrderUsername":null,"serviceItemsId":7,"serviceItemsName":"测试1","serviceTypeName":"父级分类","serviceTimes":3,"serviceAddress":"中国,北京,北京市,东城区建兴路27号","contactNo":"12345678901","serviceTime":"2020-09-24 00:00:00","serviceUnit":"台","serviceNum":null,"serviceProperty":"单开门,双开门,多开门,","cycleFlag":0,"cleanerId":1,"cleanerName":"qqqaaa","cleanerPhone":"111111111","areaName":"马家堡","paymentMethod":"微信支付","paymentTime":null,"paymentSeq":null,"suppleReason":null,"refundReason":null,"serviceEvalua":null,"cleanerEvalua":null,"description":null,"inputFlag":1,"type":null,"orderStatus":7,"orderStatusStr":"用户确认已完成","servicePrice":200,"favourablePrice":null,"paymentPrice":null,"placeOrderTime":"2020-09-05 19:05:01","endTime":null,"serviceReplenish":null,"specialRequest":null,"remark":null,"isDel":0,"createTime":"2020-09-05 19:05:01","updateTime":"2020-09-12 21:16:00","pmsServiceRelationTypeList":null,"visitFee":null,"cancleTime":null,"cancleReason":"11111"}]
     * pageIndex : 1
     * pageSize : 10
     */

    private int total;
    private int pageIndex;
    private int pageSize;
    private List<RecordsBean> records;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<RecordsBean> getRecords() {
        if (records == null) {
            return new ArrayList<>();
        }
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class RecordsBean {
        /**
         * id : 58
         * orderNo : 1303157338601033728
         * contractType : 1
         * userId : 25
         * cycleServiceId : null
         * memberName : 测试企业新增
         * memberPhone : 联系号码
         * specialAreaId : null
         * contacts : 马云
         * provinceName : null
         * cityName : null
         * countyId : 110101
         * countyName : null
         * contactAddress : 建兴路27号
         * placeOrderUser : null
         * placeOrderUsername : null
         * serviceItemsId : 7
         * serviceItemsName : 测试1
         * serviceTypeName : 父级分类
         * serviceTimes : 3
         * serviceAddress : 中国,北京,北京市,东城区建兴路27号
         * contactNo : 12345678901
         * serviceTime : 2020-09-15 00:00:00
         * serviceUnit : 台
         * serviceNum : null
         * serviceProperty : 单开门,双开门,多开门,
         * cycleFlag : 0
         * cleanerId : 1
         * cleanerName : qqqaaa
         * cleanerPhone : 111111111
         * areaName : 马家堡
         * paymentMethod : 微信支付
         * paymentTime : null
         * paymentSeq : null
         * suppleReason : null
         * refundReason : null
         * serviceEvalua : null
         * cleanerEvalua : null
         * description : null
         * inputFlag : 1
         * type : null
         * orderStatus : 7
         * orderStatusStr : 用户确认已完成
         * servicePrice : 200
         * favourablePrice : null
         * paymentPrice : null
         * placeOrderTime : 2020-09-05 19:05:01
         * endTime : null
         * serviceReplenish : null
         * specialRequest : null
         * remark : null
         * isDel : 0
         * createTime : 2020-09-05 19:05:01
         * updateTime : 2020-09-12 21:16:06
         * pmsServiceRelationTypeList : null
         * visitFee : null
         * cancleTime : null
         * cancleReason : 11111
         */

        private int id;
        private String orderNo;
        private int contractType;
        private int userId;
        private String cycleServiceId;
        private String memberName;
        private String memberPhone;
        private String specialAreaId;
        private String contacts;
        private String provinceName;
        private String cityName;
        private String countyId;
        private String countyName;
        private String contactAddress;
        private String placeOrderUser;
        private String placeOrderUsername;
        private String serviceItemsId;
        private String serviceItemsName;
        private String serviceTypeName;
        private String serviceTimes;
        private String serviceAddress;
        private String contactNo;
        private String serviceTime;
        private String serviceUnit;
        private String serviceNum;
        private String serviceProperty;
        private String cycleFlag;
        private int cleanerId;
        private String cleanerName;
        private String cleanerPhone;
        private String areaName;
        private String paymentMethod;
        private String paymentTime;
        private String paymentSeq;
        private String suppleReason;
        private String refundReason;
        private String serviceEvalua;
        private String cleanerEvalua;
        private String description;
        private int inputFlag;
        private String type;
        private int orderStatus;
        private String orderStatusStr;
        private String servicePrice;
        private String favourablePrice;
        private String paymentPrice;
        private String placeOrderTime;
        private String endTime;
        private String serviceReplenish;
        private String specialRequest;
        private String remark;
        private String isDel;
        private String createTime;
        private String updateTime;
        private String pmsServiceRelationTypeList;
        private String visitFee;
        private String cancleTime;
        private String cancleReason;

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

        public int getContractType() {
            return contractType;
        }

        public void setContractType(int contractType) {
            this.contractType = contractType;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getCycleServiceId() {
            return cycleServiceId == null ? "" : cycleServiceId;
        }

        public void setCycleServiceId(String cycleServiceId) {
            this.cycleServiceId = cycleServiceId == null ? "" : cycleServiceId;
        }

        public String getMemberName() {
            return memberName == null ? "" : memberName;
        }

        public void setMemberName(String memberName) {
            this.memberName = memberName == null ? "" : memberName;
        }

        public String getMemberPhone() {
            return memberPhone == null ? "" : memberPhone;
        }

        public void setMemberPhone(String memberPhone) {
            this.memberPhone = memberPhone == null ? "" : memberPhone;
        }

        public String getSpecialAreaId() {
            return specialAreaId == null ? "" : specialAreaId;
        }

        public void setSpecialAreaId(String specialAreaId) {
            this.specialAreaId = specialAreaId == null ? "" : specialAreaId;
        }

        public String getContacts() {
            return contacts == null ? "" : contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts == null ? "" : contacts;
        }

        public String getProvinceName() {
            return provinceName == null ? "" : provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName == null ? "" : provinceName;
        }

        public String getCityName() {
            return cityName == null ? "" : cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName == null ? "" : cityName;
        }

        public String getCountyId() {
            return countyId == null ? "" : countyId;
        }

        public void setCountyId(String countyId) {
            this.countyId = countyId == null ? "" : countyId;
        }

        public String getCountyName() {
            return countyName == null ? "" : countyName;
        }

        public void setCountyName(String countyName) {
            this.countyName = countyName == null ? "" : countyName;
        }

        public String getContactAddress() {
            return contactAddress == null ? "" : contactAddress;
        }

        public void setContactAddress(String contactAddress) {
            this.contactAddress = contactAddress == null ? "" : contactAddress;
        }

        public String getPlaceOrderUser() {
            return placeOrderUser == null ? "" : placeOrderUser;
        }

        public void setPlaceOrderUser(String placeOrderUser) {
            this.placeOrderUser = placeOrderUser == null ? "" : placeOrderUser;
        }

        public String getPlaceOrderUsername() {
            return placeOrderUsername == null ? "" : placeOrderUsername;
        }

        public void setPlaceOrderUsername(String placeOrderUsername) {
            this.placeOrderUsername = placeOrderUsername == null ? "" : placeOrderUsername;
        }

        public String getServiceItemsId() {
            return serviceItemsId == null ? "" : serviceItemsId;
        }

        public void setServiceItemsId(String serviceItemsId) {
            this.serviceItemsId = serviceItemsId == null ? "" : serviceItemsId;
        }

        public String getServiceItemsName() {
            return serviceItemsName == null ? "" : serviceItemsName;
        }

        public void setServiceItemsName(String serviceItemsName) {
            this.serviceItemsName = serviceItemsName == null ? "" : serviceItemsName;
        }

        public String getServiceTypeName() {
            return serviceTypeName == null ? "" : serviceTypeName;
        }

        public void setServiceTypeName(String serviceTypeName) {
            this.serviceTypeName = serviceTypeName == null ? "" : serviceTypeName;
        }

        public String getServiceTimes() {
            return serviceTimes == null ? "" : serviceTimes;
        }

        public void setServiceTimes(String serviceTimes) {
            this.serviceTimes = serviceTimes == null ? "" : serviceTimes;
        }

        public String getServiceAddress() {
            return serviceAddress == null ? "" : serviceAddress;
        }

        public void setServiceAddress(String serviceAddress) {
            this.serviceAddress = serviceAddress == null ? "" : serviceAddress;
        }

        public String getContactNo() {
            return contactNo == null ? "" : contactNo;
        }

        public void setContactNo(String contactNo) {
            this.contactNo = contactNo == null ? "" : contactNo;
        }

        public String getServiceTime() {
            return serviceTime == null ? "" : serviceTime;
        }

        public void setServiceTime(String serviceTime) {
            this.serviceTime = serviceTime == null ? "" : serviceTime;
        }

        public String getServiceUnit() {
            return serviceUnit == null ? "" : serviceUnit;
        }

        public void setServiceUnit(String serviceUnit) {
            this.serviceUnit = serviceUnit == null ? "" : serviceUnit;
        }

        public String getServiceNum() {
            return serviceNum == null ? "" : serviceNum;
        }

        public void setServiceNum(String serviceNum) {
            this.serviceNum = serviceNum == null ? "" : serviceNum;
        }

        public String getServiceProperty() {
            return serviceProperty == null ? "" : serviceProperty;
        }

        public void setServiceProperty(String serviceProperty) {
            this.serviceProperty = serviceProperty == null ? "" : serviceProperty;
        }

        public String getCycleFlag() {
            return cycleFlag == null ? "" : cycleFlag;
        }

        public void setCycleFlag(String cycleFlag) {
            this.cycleFlag = cycleFlag == null ? "" : cycleFlag;
        }

        public int getCleanerId() {
            return cleanerId;
        }

        public void setCleanerId(int cleanerId) {
            this.cleanerId = cleanerId;
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

        public String getAreaName() {
            return areaName == null ? "" : areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName == null ? "" : areaName;
        }

        public String getPaymentMethod() {
            return paymentMethod == null ? "" : paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod == null ? "" : paymentMethod;
        }

        public String getPaymentTime() {
            return paymentTime == null ? "" : paymentTime;
        }

        public void setPaymentTime(String paymentTime) {
            this.paymentTime = paymentTime == null ? "" : paymentTime;
        }

        public String getPaymentSeq() {
            return paymentSeq == null ? "" : paymentSeq;
        }

        public void setPaymentSeq(String paymentSeq) {
            this.paymentSeq = paymentSeq == null ? "" : paymentSeq;
        }

        public String getSuppleReason() {
            return suppleReason == null ? "" : suppleReason;
        }

        public void setSuppleReason(String suppleReason) {
            this.suppleReason = suppleReason == null ? "" : suppleReason;
        }

        public String getRefundReason() {
            return refundReason == null ? "" : refundReason;
        }

        public void setRefundReason(String refundReason) {
            this.refundReason = refundReason == null ? "" : refundReason;
        }

        public String getServiceEvalua() {
            return serviceEvalua == null ? "" : serviceEvalua;
        }

        public void setServiceEvalua(String serviceEvalua) {
            this.serviceEvalua = serviceEvalua == null ? "" : serviceEvalua;
        }

        public String getCleanerEvalua() {
            return cleanerEvalua == null ? "" : cleanerEvalua;
        }

        public void setCleanerEvalua(String cleanerEvalua) {
            this.cleanerEvalua = cleanerEvalua == null ? "" : cleanerEvalua;
        }

        public String getDescription() {
            return description == null ? "" : description;
        }

        public void setDescription(String description) {
            this.description = description == null ? "" : description;
        }

        public int getInputFlag() {
            return inputFlag;
        }

        public void setInputFlag(int inputFlag) {
            this.inputFlag = inputFlag;
        }

        public String getType() {
            return type == null ? "" : type;
        }

        public void setType(String type) {
            this.type = type == null ? "" : type;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getOrderStatusStr() {
            return orderStatusStr == null ? "" : orderStatusStr;
        }

        public void setOrderStatusStr(String orderStatusStr) {
            this.orderStatusStr = orderStatusStr == null ? "" : orderStatusStr;
        }

        public String getServicePrice() {
            return servicePrice == null ? "" : servicePrice;
        }

        public void setServicePrice(String servicePrice) {
            this.servicePrice = servicePrice == null ? "" : servicePrice;
        }

        public String getFavourablePrice() {
            return favourablePrice == null ? "" : favourablePrice;
        }

        public void setFavourablePrice(String favourablePrice) {
            this.favourablePrice = favourablePrice == null ? "" : favourablePrice;
        }

        public String getPaymentPrice() {
            return paymentPrice == null ? "" : paymentPrice;
        }

        public void setPaymentPrice(String paymentPrice) {
            this.paymentPrice = paymentPrice == null ? "" : paymentPrice;
        }

        public String getPlaceOrderTime() {
            return placeOrderTime == null ? "" : placeOrderTime;
        }

        public void setPlaceOrderTime(String placeOrderTime) {
            this.placeOrderTime = placeOrderTime == null ? "" : placeOrderTime;
        }

        public String getEndTime() {
            return endTime == null ? "" : endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime == null ? "" : endTime;
        }

        public String getServiceReplenish() {
            return serviceReplenish == null ? "" : serviceReplenish;
        }

        public void setServiceReplenish(String serviceReplenish) {
            this.serviceReplenish = serviceReplenish == null ? "" : serviceReplenish;
        }

        public String getSpecialRequest() {
            return specialRequest == null ? "" : specialRequest;
        }

        public void setSpecialRequest(String specialRequest) {
            this.specialRequest = specialRequest == null ? "" : specialRequest;
        }

        public String getRemark() {
            return remark == null ? "" : remark;
        }

        public void setRemark(String remark) {
            this.remark = remark == null ? "" : remark;
        }

        public String getIsDel() {
            return isDel == null ? "" : isDel;
        }

        public void setIsDel(String isDel) {
            this.isDel = isDel == null ? "" : isDel;
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

        public String getPmsServiceRelationTypeList() {
            return pmsServiceRelationTypeList == null ? "" : pmsServiceRelationTypeList;
        }

        public void setPmsServiceRelationTypeList(String pmsServiceRelationTypeList) {
            this.pmsServiceRelationTypeList = pmsServiceRelationTypeList == null ? "" : pmsServiceRelationTypeList;
        }

        public String getVisitFee() {
            return visitFee == null ? "" : visitFee;
        }

        public void setVisitFee(String visitFee) {
            this.visitFee = visitFee == null ? "" : visitFee;
        }

        public String getCancleTime() {
            return cancleTime == null ? "" : cancleTime;
        }

        public void setCancleTime(String cancleTime) {
            this.cancleTime = cancleTime == null ? "" : cancleTime;
        }

        public String getCancleReason() {
            return cancleReason == null ? "" : cancleReason;
        }

        public void setCancleReason(String cancleReason) {
            this.cancleReason = cancleReason == null ? "" : cancleReason;
        }
    }
}