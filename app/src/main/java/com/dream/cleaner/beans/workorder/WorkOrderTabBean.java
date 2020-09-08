package com.dream.cleaner.beans.workorder;

import java.util.ArrayList;
import java.util.List;

/**
 * author : liyl
 * date   : 2020/8/20
 * desc   :
 */
public class WorkOrderTabBean {

    /**
     * total : 0
     * records : [{"id":0,"orderNo":"","contractType":0,"userId":0,"cycleServiceId":0,"memberName":"","memberPhone":"","contacts":"","provinceName":"","cityName":"","countyName":"","countyId":0,"contactAddress":"","placeOrderUser":0,"placeOrderUsername":"","serviceItemsId":0,"serviceItemsName":"","serviceTypeName":"","serviceTimes":0,"serviceAddress":"","contactNo":"","serviceTime":"","serviceUnit":"","serviceNum":"","serviceProperty":"","cycleFlag":0,"cleanerId":0,"cleanerName":"","cleanerPhone":"","areaName":"","paymentMethod":"","paymentTime":"","paymentSeq":"","suppleReason":"","refundReason":"","serviceEvalua":"","cleanerEvalua":"","description":"","inputFlag":0,"orderStatus":0,"orderStatusStr":"","servicePrice":0,"favourablePrice":0,"paymentPrice":0,"placeOrderTime":"","endTime":"","serviceReplenish":"","specialRequest":"","remark":"","isDel":0,"createTime":"","updateTime":"","pmsServiceRelationTypeList":[{"id":0,"relationId":0,"relationType":0,"categoryId":0,"categoryName":"","serviceId":0,"serviceName":"","billingUnitId":0,"billingUnitName":"","unitProId":0,"unitProName":"","settlePrice":0,"isDel":0,"createTime":"","updateTime":""}],"visitFee":0,"cancleTime":"","cancleReason":""}]
     * pageIndex : 0
     * pageSize : 0
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
         * id : 0
         * orderNo :
         * contractType : 0
         * userId : 0
         * cycleServiceId : 0
         * memberName :
         * memberPhone :
         * contacts :
         * provinceName :
         * cityName :
         * countyName :
         * countyId : 0
         * contactAddress :
         * placeOrderUser : 0
         * placeOrderUsername :
         * serviceItemsId : 0
         * serviceItemsName :
         * serviceTypeName :
         * serviceTimes : 0
         * serviceAddress :
         * contactNo :
         * serviceTime :
         * serviceUnit :
         * serviceNum :
         * serviceProperty :
         * cycleFlag : 0
         * cleanerId : 0
         * cleanerName :
         * cleanerPhone :
         * areaName :
         * paymentMethod :
         * paymentTime :
         * paymentSeq :
         * suppleReason :
         * refundReason :
         * serviceEvalua :
         * cleanerEvalua :
         * description :
         * inputFlag : 0
         * orderStatus : 0
         * orderStatusStr :
         * servicePrice : 0
         * favourablePrice : 0
         * paymentPrice : 0
         * placeOrderTime :
         * endTime :
         * serviceReplenish :
         * specialRequest :
         * remark :
         * isDel : 0
         * createTime :
         * updateTime :
         * pmsServiceRelationTypeList : [{"id":0,"relationId":0,"relationType":0,"categoryId":0,"categoryName":"","serviceId":0,"serviceName":"","billingUnitId":0,"billingUnitName":"","unitProId":0,"unitProName":"","settlePrice":0,"isDel":0,"createTime":"","updateTime":""}]
         * visitFee : 0
         * cancleTime :
         * cancleReason :
         */

        private int id;
        private String orderNo;
        private int contractType;
        private int userId;
        private int cycleServiceId;
        private String memberName;
        private String memberPhone;
        private String contacts;
        private String provinceName;
        private String cityName;
        private String countyName;
        private int countyId;
        private String contactAddress;
        private int placeOrderUser;
        private String placeOrderUsername;
        private int serviceItemsId;
        private String serviceItemsName;
        private String serviceTypeName;
        private int serviceTimes;
        private String serviceAddress;
        private String contactNo;
        private String serviceTime;
        private String serviceUnit;
        private String serviceNum;
        private String serviceProperty;
        private int cycleFlag;
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
        private int orderStatus;
        private String orderStatusStr;
        private int servicePrice;
        private int favourablePrice;
        private int paymentPrice;
        private String placeOrderTime;
        private String endTime;
        private String serviceReplenish;
        private String specialRequest;
        private String remark;
        private int isDel;
        private String createTime;
        private String updateTime;
        private int visitFee;
        private String cancleTime;
        private String cancleReason;
        private List<PmsServiceRelationTypeListBean> pmsServiceRelationTypeList;

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

        public int getCycleServiceId() {
            return cycleServiceId;
        }

        public void setCycleServiceId(int cycleServiceId) {
            this.cycleServiceId = cycleServiceId;
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

        public String getCountyName() {
            return countyName == null ? "" : countyName;
        }

        public void setCountyName(String countyName) {
            this.countyName = countyName == null ? "" : countyName;
        }

        public int getCountyId() {
            return countyId;
        }

        public void setCountyId(int countyId) {
            this.countyId = countyId;
        }

        public String getContactAddress() {
            return contactAddress == null ? "" : contactAddress;
        }

        public void setContactAddress(String contactAddress) {
            this.contactAddress = contactAddress == null ? "" : contactAddress;
        }

        public int getPlaceOrderUser() {
            return placeOrderUser;
        }

        public void setPlaceOrderUser(int placeOrderUser) {
            this.placeOrderUser = placeOrderUser;
        }

        public String getPlaceOrderUsername() {
            return placeOrderUsername == null ? "" : placeOrderUsername;
        }

        public void setPlaceOrderUsername(String placeOrderUsername) {
            this.placeOrderUsername = placeOrderUsername == null ? "" : placeOrderUsername;
        }

        public int getServiceItemsId() {
            return serviceItemsId;
        }

        public void setServiceItemsId(int serviceItemsId) {
            this.serviceItemsId = serviceItemsId;
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

        public int getServiceTimes() {
            return serviceTimes;
        }

        public void setServiceTimes(int serviceTimes) {
            this.serviceTimes = serviceTimes;
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

        public int getCycleFlag() {
            return cycleFlag;
        }

        public void setCycleFlag(int cycleFlag) {
            this.cycleFlag = cycleFlag;
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

        public int getServicePrice() {
            return servicePrice;
        }

        public void setServicePrice(int servicePrice) {
            this.servicePrice = servicePrice;
        }

        public int getFavourablePrice() {
            return favourablePrice;
        }

        public void setFavourablePrice(int favourablePrice) {
            this.favourablePrice = favourablePrice;
        }

        public int getPaymentPrice() {
            return paymentPrice;
        }

        public void setPaymentPrice(int paymentPrice) {
            this.paymentPrice = paymentPrice;
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

        public int getVisitFee() {
            return visitFee;
        }

        public void setVisitFee(int visitFee) {
            this.visitFee = visitFee;
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

        public List<PmsServiceRelationTypeListBean> getPmsServiceRelationTypeList() {
            if (pmsServiceRelationTypeList == null) {
                return new ArrayList<>();
            }
            return pmsServiceRelationTypeList;
        }

        public void setPmsServiceRelationTypeList(List<PmsServiceRelationTypeListBean> pmsServiceRelationTypeList) {
            this.pmsServiceRelationTypeList = pmsServiceRelationTypeList;
        }

        public static class PmsServiceRelationTypeListBean {
            /**
             * id : 0
             * relationId : 0
             * relationType : 0
             * categoryId : 0
             * categoryName :
             * serviceId : 0
             * serviceName :
             * billingUnitId : 0
             * billingUnitName :
             * unitProId : 0
             * unitProName :
             * settlePrice : 0
             * isDel : 0
             * createTime :
             * updateTime :
             */

            private int id;
            private int relationId;
            private int relationType;
            private int categoryId;
            private String categoryName;
            private int serviceId;
            private String serviceName;
            private int billingUnitId;
            private String billingUnitName;
            private int unitProId;
            private String unitProName;
            private int settlePrice;
            private int isDel;
            private String createTime;
            private String updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getRelationId() {
                return relationId;
            }

            public void setRelationId(int relationId) {
                this.relationId = relationId;
            }

            public int getRelationType() {
                return relationType;
            }

            public void setRelationType(int relationType) {
                this.relationType = relationType;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getCategoryName() {
                return categoryName == null ? "" : categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName == null ? "" : categoryName;
            }

            public int getServiceId() {
                return serviceId;
            }

            public void setServiceId(int serviceId) {
                this.serviceId = serviceId;
            }

            public String getServiceName() {
                return serviceName == null ? "" : serviceName;
            }

            public void setServiceName(String serviceName) {
                this.serviceName = serviceName == null ? "" : serviceName;
            }

            public int getBillingUnitId() {
                return billingUnitId;
            }

            public void setBillingUnitId(int billingUnitId) {
                this.billingUnitId = billingUnitId;
            }

            public String getBillingUnitName() {
                return billingUnitName == null ? "" : billingUnitName;
            }

            public void setBillingUnitName(String billingUnitName) {
                this.billingUnitName = billingUnitName == null ? "" : billingUnitName;
            }

            public int getUnitProId() {
                return unitProId;
            }

            public void setUnitProId(int unitProId) {
                this.unitProId = unitProId;
            }

            public String getUnitProName() {
                return unitProName == null ? "" : unitProName;
            }

            public void setUnitProName(String unitProName) {
                this.unitProName = unitProName == null ? "" : unitProName;
            }

            public int getSettlePrice() {
                return settlePrice;
            }

            public void setSettlePrice(int settlePrice) {
                this.settlePrice = settlePrice;
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

}
