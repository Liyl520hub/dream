package com.dream.cleaner.beans.workorder;

/**
 * author : liyl
 * date   : 2020/8/19
 * desc   :工单下拉框bean
 */
public class PopWorkOrderBean {



    /**
     * id : 1
     * categoryCode : 100
     * categoryName : 居家保洁
     * parentId : 0
     * status : 1
     * isDel : 0
     * createTime : 2020-08-01 20:57:05
     * updateTime : 2020-09-13 15:33:47
     */

    private String id;
    private String categoryCode;
    private String categoryName;
    private String parentId;
    private String status;
    private String isDel;
    private String createTime;
    private String updateTime;



    /**
     *
     * 订单类型列表
     * id : -1
     * name : 个人
     * provinceId : null
     * provinceName : null
     * cityId : null
     * cityName : null
     * countyId : null
     * countyName : null
     * status : null
     * flag : null
     * beginTime : null
     * endTime : null
     * isDel : null
     * createTime : null
     * updateTime : null
     * categoryId : null
     * pmsServiceRelationTypeS : null
     */

    private String name;
    private String provinceId;
    private String provinceName;
    private String cityId;
    private String cityName;
    private String countyId;
    private String countyName;
    private String flag;
    private String beginTime;
    private String endTime;
    private String categoryId;
    private String pmsServiceRelationTypeS;
    private boolean isCheck;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    public String getProvinceId() {
        return provinceId == null ? "" : provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? "" : provinceId;
    }

    public String getProvinceName() {
        return provinceName == null ? "" : provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? "" : provinceName;
    }

    public String getCityId() {
        return cityId == null ? "" : cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? "" : cityId;
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

    public String getFlag() {
        return flag == null ? "" : flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? "" : flag;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id;
    }

    public String getCategoryCode() {
        return categoryCode == null ? "" : categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? "" : categoryCode;
    }

    public String getCategoryName() {
        return categoryName == null ? "" : categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? "" : categoryName;
    }

    public String getParentId() {
        return parentId == null ? "" : parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? "" : parentId;
    }

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status == null ? "" : status;
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

    public String getBeginTime() {
        return beginTime == null ? "" : beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? "" : beginTime;
    }

    public String getEndTime() {
        return endTime == null ? "" : endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? "" : endTime;
    }

    public String getCategoryId() {
        return categoryId == null ? "" : categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? "" : categoryId;
    }

    public String getPmsServiceRelationTypeS() {
        return pmsServiceRelationTypeS == null ? "" : pmsServiceRelationTypeS;
    }

    public void setPmsServiceRelationTypeS(String pmsServiceRelationTypeS) {
        this.pmsServiceRelationTypeS = pmsServiceRelationTypeS == null ? "" : pmsServiceRelationTypeS;
    }
}
