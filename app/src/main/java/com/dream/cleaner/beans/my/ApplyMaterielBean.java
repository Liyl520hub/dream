package com.dream.cleaner.beans.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liyl
 * date   : 2020/8/25
 * desc   :申请物料bean
 */
public class ApplyMaterielBean {


    /**
     * total : 2
     * records : [{"id":23,"applyNo":"202008271657490845535","applyReason":"刚入职，要拿新人物料","applyPerson":1,"applyPersonName":"string","contactNumber":"18010476582","applyType":"01","applyDesc":"刚入职，要拿新人物料","applyTime":"2020-08-27 16:57:49","collectTime":"2020-08-27 17:08:29","auditTime":"2020-09-07 14:11:54","status":2,"auditPerson":1,"auditPersonName":"超级管理员","auditReason":"通过","buildTime":"2020-08-27 16:57:49","isDel":0,"createTime":"2020-08-27 16:57:49","updateTime":"2020-09-07 14:09:16","applyNums":3,"applyTypeName":"新人物料"},{"id":24,"applyNo":"202009071414226711855","applyReason":"新人领料","applyPerson":1,"applyPersonName":"string","contactNumber":"18010476582","applyType":"01","applyDesc":"领料","applyTime":"2020-09-07 14:14:23","collectTime":null,"auditTime":"2020-09-07 14:22:04","status":3,"auditPerson":1,"auditPersonName":"超级管理员","auditReason":"qqq","buildTime":"2020-09-07 14:14:23","isDel":0,"createTime":"2020-09-07 14:14:23","updateTime":"2020-09-07 14:14:23","applyNums":2,"applyTypeName":"新人物料"}]
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
         * id : 23
         * applyNo : 202008271657490845535
         * applyReason : 刚入职，要拿新人物料
         * applyPerson : 1
         * applyPersonName : string
         * contactNumber : 18010476582
         * applyType : 01
         * applyDesc : 刚入职，要拿新人物料
         * applyTime : 2020-08-27 16:57:49
         * collectTime : 2020-08-27 17:08:29
         * auditTime : 2020-09-07 14:11:54
         * status : 2
         * auditPerson : 1
         * auditPersonName : 超级管理员
         * auditReason : 通过
         * buildTime : 2020-08-27 16:57:49
         * isDel : 0
         * createTime : 2020-08-27 16:57:49
         * updateTime : 2020-09-07 14:09:16
         * applyNums : 3
         * applyTypeName : 新人物料
         */

        private int id;
        private String applyNo;
        private String applyReason;
        private int applyPerson;
        private String applyPersonName;
        private String contactNumber;
        private String applyType;
        private String applyDesc;
        private String applyTime;
        private String collectTime;
        private String auditTime;
        private int status;
        private int auditPerson;
        private String auditPersonName;
        private String auditReason;
        private String buildTime;
        private int isDel;
        private String createTime;
        private String updateTime;
        private int applyNums;
        private String applyTypeName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getApplyNo() {
            return applyNo == null ? "" : applyNo;
        }

        public void setApplyNo(String applyNo) {
            this.applyNo = applyNo == null ? "" : applyNo;
        }

        public String getApplyReason() {
            return applyReason == null ? "" : applyReason;
        }

        public void setApplyReason(String applyReason) {
            this.applyReason = applyReason == null ? "" : applyReason;
        }

        public int getApplyPerson() {
            return applyPerson;
        }

        public void setApplyPerson(int applyPerson) {
            this.applyPerson = applyPerson;
        }

        public String getApplyPersonName() {
            return applyPersonName == null ? "" : applyPersonName;
        }

        public void setApplyPersonName(String applyPersonName) {
            this.applyPersonName = applyPersonName == null ? "" : applyPersonName;
        }

        public String getContactNumber() {
            return contactNumber == null ? "" : contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber == null ? "" : contactNumber;
        }

        public String getApplyType() {
            return applyType == null ? "" : applyType;
        }

        public void setApplyType(String applyType) {
            this.applyType = applyType == null ? "" : applyType;
        }

        public String getApplyDesc() {
            return applyDesc == null ? "" : applyDesc;
        }

        public void setApplyDesc(String applyDesc) {
            this.applyDesc = applyDesc == null ? "" : applyDesc;
        }

        public String getApplyTime() {
            return applyTime == null ? "" : applyTime;
        }

        public void setApplyTime(String applyTime) {
            this.applyTime = applyTime == null ? "" : applyTime;
        }

        public String getCollectTime() {
            return collectTime == null ? "" : collectTime;
        }

        public void setCollectTime(String collectTime) {
            this.collectTime = collectTime == null ? "" : collectTime;
        }

        public String getAuditTime() {
            return auditTime == null ? "" : auditTime;
        }

        public void setAuditTime(String auditTime) {
            this.auditTime = auditTime == null ? "" : auditTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getAuditPerson() {
            return auditPerson;
        }

        public void setAuditPerson(int auditPerson) {
            this.auditPerson = auditPerson;
        }

        public String getAuditPersonName() {
            return auditPersonName == null ? "" : auditPersonName;
        }

        public void setAuditPersonName(String auditPersonName) {
            this.auditPersonName = auditPersonName == null ? "" : auditPersonName;
        }

        public String getAuditReason() {
            return auditReason == null ? "" : auditReason;
        }

        public void setAuditReason(String auditReason) {
            this.auditReason = auditReason == null ? "" : auditReason;
        }

        public String getBuildTime() {
            return buildTime == null ? "" : buildTime;
        }

        public void setBuildTime(String buildTime) {
            this.buildTime = buildTime == null ? "" : buildTime;
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

        public int getApplyNums() {
            return applyNums;
        }

        public void setApplyNums(int applyNums) {
            this.applyNums = applyNums;
        }

        public String getApplyTypeName() {
            return applyTypeName == null ? "" : applyTypeName;
        }

        public void setApplyTypeName(String applyTypeName) {
            this.applyTypeName = applyTypeName == null ? "" : applyTypeName;
        }
    }
}
