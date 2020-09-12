package com.dream.cleaner.beans.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Liyalei
 * date   : 2020/9/12
 * desc   :
 */
public class MaterielBean {


    /**
     * items : [{"id":0,"materielApplyId":0,"applyNo":"","materielId":0,"materielNo":"","materielName":"","materielModel":"","applyNum":0,"isDel":0,"createTime":"","updateTime":""}]
     * id : 0
     * applyNo :
     * applyReason :
     * applyPerson : 0
     * applyPersonName :
     * contactNumber :
     * applyType :
     * applyDesc :
     * applyTime :
     * collectTime :
     * auditTime :
     * status : 0
     * auditPerson : 0
     * auditPersonName :
     * auditReason :
     * buildTime :
     * isDel : 0
     * createTime :
     * updateTime :
     * applyNums : 0
     * applyTypeName :
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
    private List<MaterielTypeBean> items;

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

    public List<MaterielTypeBean> getItems() {
        if (items == null) {
            return new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<MaterielTypeBean> items) {
        this.items = items;
    }


}
