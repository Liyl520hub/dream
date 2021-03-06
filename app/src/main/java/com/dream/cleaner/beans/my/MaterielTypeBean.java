package com.dream.cleaner.beans.my;

/**
 * @author : admin
 * date   : 2020/9/12
 * desc   :
 */
public class MaterielTypeBean {


    /**
     * id : 7
     * materielNo : M200001
     * materielName : 拖布122
     * materielModel : 0601
     * alertNo : 100
     * maximumStock : 200
     * stockNum : 998
     * unitType : 9901
     * lastPurchasePrice : 1
     * isDel : 0
     * createTime : 2020-08-03 11:40:00
     * updateTime : 2020-09-06 18:38:34
     * defaultBase : 3
     * status : 0
     * materielTypeCodes : null
     * materielTypeNames : null
     */

    private int id;
    private String materielNo;
    private String materielName;
    private String materielModel;
    private int alertNo;
    private int maximumStock;
    private int stockNum;
    private String unitType;
    private int lastPurchasePrice;
    private int isDel;
    private String createTime;
    private String updateTime;
    private int defaultBase;
    private int status;
    private String materielTypeCodes;
    private String materielTypeNames;
    /**
     * 物料详情item对象跟这个对象共用一个
     * materielApplyId applyNo materielId applyNum
     * 这四个是item对象带的
     */
    private int materielApplyId;
    private String applyNo;
    private String materielId;
    private String applyNum;


    public int getMaterielApplyId() {
        return materielApplyId;
    }

    public void setMaterielApplyId(int materielApplyId) {
        this.materielApplyId = materielApplyId;
    }

    public String getApplyNo() {
        return applyNo == null ? "" : applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? "" : applyNo;
    }

    public String getMaterielId() {
        return materielId == null ? "" : materielId;
    }

    public void setMaterielId(String materielId) {
        this.materielId = materielId == null ? "" : materielId;
    }

    public String getApplyNum() {
        return applyNum == null ? "0" : applyNum;
    }

    public void setApplyNum(String applyNum) {
        this.applyNum = applyNum == null ? "" : applyNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterielNo() {
        return materielNo == null ? "" : materielNo;
    }

    public void setMaterielNo(String materielNo) {
        this.materielNo = materielNo == null ? "" : materielNo;
    }

    public String getMaterielName() {
        return materielName == null ? "" : materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName == null ? "" : materielName;
    }

    public String getMaterielModel() {
        return materielModel == null ? "" : materielModel;
    }

    public void setMaterielModel(String materielModel) {
        this.materielModel = materielModel == null ? "" : materielModel;
    }

    public int getAlertNo() {
        return alertNo;
    }

    public void setAlertNo(int alertNo) {
        this.alertNo = alertNo;
    }

    public int getMaximumStock() {
        return maximumStock;
    }

    public void setMaximumStock(int maximumStock) {
        this.maximumStock = maximumStock;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public String getUnitType() {
        return unitType == null ? "" : unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? "" : unitType;
    }

    public int getLastPurchasePrice() {
        return lastPurchasePrice;
    }

    public void setLastPurchasePrice(int lastPurchasePrice) {
        this.lastPurchasePrice = lastPurchasePrice;
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

    public int getDefaultBase() {
        return defaultBase;
    }

    public void setDefaultBase(int defaultBase) {
        this.defaultBase = defaultBase;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMaterielTypeCodes() {
        return materielTypeCodes == null ? "" : materielTypeCodes;
    }

    public void setMaterielTypeCodes(String materielTypeCodes) {
        this.materielTypeCodes = materielTypeCodes == null ? "" : materielTypeCodes;
    }

    public String getMaterielTypeNames() {
        return materielTypeNames == null ? "" : materielTypeNames;
    }

    public void setMaterielTypeNames(String materielTypeNames) {
        this.materielTypeNames = materielTypeNames == null ? "" : materielTypeNames;
    }
}
