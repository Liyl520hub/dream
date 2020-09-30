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
        private String contractType;
        private String userId;
        private String cycleServiceId;
        private String memberName;
        private String memberPhone;
        private String contacts;
        private String provinceName;
        private String cityName;
        private String countyName;
        private String countyId;
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
        private String cleanerId;
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
        private String inputFlag;
        private String orderStatus;
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
        private String visitFee;
        private String cancleTime;
        private String cancleReason;
        private String distance;
        private List<PmsServiceRelationTypeListBean> pmsServiceRelationTypeList;
        private String lon;
        private String lat;
        private PmsServiceEvaluation pmsServiceEvaluation;


        public PmsServiceEvaluation getPmsServiceEvaluation() {
            return pmsServiceEvaluation == null ? new PmsServiceEvaluation() : pmsServiceEvaluation;
        }

        public void setPmsServiceEvaluation(PmsServiceEvaluation pmsServiceEvaluation) {
            this.pmsServiceEvaluation = pmsServiceEvaluation;
        }

        public String getLon() {
            return lon == null ? "" : lon;
        }

        public void setLon(String lon) {
            this.lon = lon == null ? "" : lon;
        }

        public String getLat() {
            return lat == null ? "" : lat;
        }

        public void setLat(String lat) {
            this.lat = lat == null ? "" : lat;
        }

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

        public String getContractType() {
            return contractType == null ? "" : contractType;
        }

        public void setContractType(String contractType) {
            this.contractType = contractType == null ? "" : contractType;
        }

        public String getUserId() {
            return userId == null ? "" : userId;
        }

        public void setUserId(String userId) {
            this.userId = userId == null ? "" : userId;
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

        public String getCountyId() {
            return countyId == null ? "" : countyId;
        }

        public void setCountyId(String countyId) {
            this.countyId = countyId == null ? "" : countyId;
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

        public String getInputFlag() {
            return inputFlag == null ? "" : inputFlag;
        }

        public void setInputFlag(String inputFlag) {
            this.inputFlag = inputFlag == null ? "" : inputFlag;
        }

        public String getOrderStatus() {
            return orderStatus == null ? "0" : orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus == null ? "0" : orderStatus;
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

        public String getDistance() {
            return distance == null ? "" : distance;
        }

        public void setDistance(String distance) {
            this.distance = distance == null ? "" : distance;
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
            private String relationId;
            private String relationType;
            private String categoryId;
            private String categoryName;
            private String serviceId;
            private String serviceName;
            private String billingUnitId;
            private String billingUnitName;
            private String unitProId;
            private String unitProName;
            private String settlePrice;
            private String isDel;
            private String createTime;
            private String updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getRelationId() {
                return relationId == null ? "" : relationId;
            }

            public void setRelationId(String relationId) {
                this.relationId = relationId == null ? "" : relationId;
            }

            public String getRelationType() {
                return relationType == null ? "" : relationType;
            }

            public void setRelationType(String relationType) {
                this.relationType = relationType == null ? "" : relationType;
            }

            public String getCategoryId() {
                return categoryId == null ? "" : categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId == null ? "" : categoryId;
            }

            public String getCategoryName() {
                return categoryName == null ? "" : categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName == null ? "" : categoryName;
            }

            public String getServiceId() {
                return serviceId == null ? "" : serviceId;
            }

            public void setServiceId(String serviceId) {
                this.serviceId = serviceId == null ? "" : serviceId;
            }

            public String getServiceName() {
                return serviceName == null ? "" : serviceName;
            }

            public void setServiceName(String serviceName) {
                this.serviceName = serviceName == null ? "" : serviceName;
            }

            public String getBillingUnitId() {
                return billingUnitId == null ? "" : billingUnitId;
            }

            public void setBillingUnitId(String billingUnitId) {
                this.billingUnitId = billingUnitId == null ? "" : billingUnitId;
            }

            public String getBillingUnitName() {
                return billingUnitName == null ? "" : billingUnitName;
            }

            public void setBillingUnitName(String billingUnitName) {
                this.billingUnitName = billingUnitName == null ? "" : billingUnitName;
            }

            public String getUnitProId() {
                return unitProId == null ? "" : unitProId;
            }

            public void setUnitProId(String unitProId) {
                this.unitProId = unitProId == null ? "" : unitProId;
            }

            public String getUnitProName() {
                return unitProName == null ? "" : unitProName;
            }

            public void setUnitProName(String unitProName) {
                this.unitProName = unitProName == null ? "" : unitProName;
            }

            public String getSettlePrice() {
                return settlePrice == null ? "" : settlePrice;
            }

            public void setSettlePrice(String settlePrice) {
                this.settlePrice = settlePrice == null ? "" : settlePrice;
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
        }


        public static class PmsServiceEvaluation {
            /**
             * 整体评价分数
             */
            private String serviceScore;
            /**
             * 保洁员分数
             */
            private String cleanerScore;

            public String getServiceScore() {
                return serviceScore == null ? "1" : serviceScore;
            }

            public void setServiceScore(String serviceScore) {
                this.serviceScore = serviceScore == null ? "1" : serviceScore;
            }

            public String getCleanerScore() {
                return cleanerScore == null ? "1" : cleanerScore;
            }

            public void setCleanerScore(String cleanerScore) {
                this.cleanerScore = cleanerScore == null ? "1" : cleanerScore;
            }
        }


    }

}
