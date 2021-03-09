package com.dream.cleaner.beans.workorder;

/**
 * @author : admin
 * date   : 2020/9/15
 * desc   :
 */
public class PopWorkOrderTypeListBean {


    /**
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

    private int id;
    private String name;
    private String provinceId;
    private String provinceName;
    private String cityId;
    private String cityName;
    private String countyId;
    private String countyName;
    private String status;
    private String flag;
    private String beginTime;
    private String endTime;
    private String isDel;
    private String createTime;
    private String updateTime;
    private String categoryId;
    private String pmsServiceRelationTypeS;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status == null ? "" : status;
    }

    public String getFlag() {
        return flag == null ? "" : flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? "" : flag;
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
