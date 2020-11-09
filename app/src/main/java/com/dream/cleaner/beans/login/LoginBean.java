package com.dream.cleaner.beans.login;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :
 */
public class LoginBean {

    /**
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ3ZWIiLCJpc3MiOiJzcHJpbmctYm9vdC1wbHVzIiwiZXhwIjoxNjAyMDg5MDE4LCJpYXQiOjE1OTk0OTcwMTgsImp0aSI6ImQxMDEzNzRmOWNlOTRhNGI4ZGY1NGJmMDgwYWNjMGM2IiwidXNlcm5hbWUiOiIxNTczMzEyNTIxMSJ9.CFu8c-UUK2g_gp-jePgZhgGunTzCfw2TRxfoT3-8XP4
     * cleaner : {"id":10,"cleanerNo":"20200907-1","name":"测试","age":null,"workAge":null,"phone":"15733125211","idNumber":null,"password":"123456","sex":null,"startDate":"2020-09-06 00:00:00","endDate":"2020-09-06 00:00:00","birthDate":"2020-09-06 00:00:00","headpicPath":null,"portraitPath":null,"nationalEmblemPath":null,"healthCertNo":null,"healthCertDate":"2020-09-06 00:00:00","healthCertPath":null,"proQualiCertPath":null,"proQualiCertPathList":null,"areaProvinceId":null,"areaProvinceName":null,"areaCityId":null,"areaCityName":null,"areaCountyId":null,"areaCountyName":null,"serviceAreaId":null,"serviceAreaName":null,"projectBudgetId":null,"projectBudgetName":null,"serviceId":null,"serviceName":null,"serviceParentId":null,"serviceParentName":null,"levelId":null,"levelName":null,"canTakeStatus":null,"outsourcerId":null,"outsourcerName":null,"entryDate":"2020-09-06 00:00:00","status":1,"isDel":0,"createTime":"2020-09-03 17:59:24","updateTime":"2020-09-07 16:00:11","directContactName":null,"directContactPhone":null}
     */

    private String token;
    private CleanerBean cleaner;

    public String getToken() {
        return token == null ? "" : token;
    }

    public void setToken(String token) {
        this.token = token == null ? "" : token;
    }

    public CleanerBean getCleaner() {
        return cleaner;
    }

    public void setCleaner(CleanerBean cleaner) {
        this.cleaner = cleaner;
    }

    public static class CleanerBean {
        /**
         * id : 10
         * cleanerNo : 20200907-1
         * name : 测试
         * age : null
         * workAge : null
         * phone : 15733125211
         * idNumber : null
         * password : 123456
         * sex : null
         * startDate : 2020-09-06 00:00:00
         * endDate : 2020-09-06 00:00:00
         * birthDate : 2020-09-06 00:00:00
         * headpicPath : null
         * portraitPath : null
         * nationalEmblemPath : null
         * healthCertNo : null
         * healthCertDate : 2020-09-06 00:00:00
         * healthCertPath : null
         * proQualiCertPath : null
         * proQualiCertPathList : null
         * areaProvinceId : null
         * areaProvinceName : null
         * areaCityId : null
         * areaCityName : null
         * areaCountyId : null
         * areaCountyName : null
         * serviceAreaId : null
         * serviceAreaName : null
         * projectBudgetId : null
         * projectBudgetName : null
         * serviceId : null
         * serviceName : null
         * serviceParentId : null
         * serviceParentName : null
         * levelId : null
         * levelName : null
         * canTakeStatus : null
         * outsourcerId : null
         * outsourcerName : null
         * entryDate : 2020-09-06 00:00:00
         * status : 1
         * isDel : 0
         * createTime : 2020-09-03 17:59:24
         * updateTime : 2020-09-07 16:00:11
         * directContactName : null
         * directContactPhone : null
         */

        private int id;
        private String cleanerNo;
        private String name;
        private String age;
        private String workAge;
        private String phone;
        private String idNumber;
        private String password;
        private String sex;
        private String startDate;
        private String endDate;
        private String birthDate;
        private String headpicPath;
        private String portraitPath;
        private String nationalEmblemPath;
        private String healthCertNo;
        private String healthCertDate;
        private String healthCertPath;
        private String proQualiCertPath;
        private String proQualiCertPathList;
        private String areaProvinceId;
        private String areaProvinceName;
        private String areaCityId;
        private String areaCityName;
        private String areaCountyId;
        private String areaCountyName;
        private String serviceAreaId;
        private String serviceAreaName;
        private String projectBudgetId;
        private String projectBudgetName;
        private String serviceId;
        private String serviceName;
        private String serviceParentId;
        private String serviceParentName;
        private String levelId;
        private String levelName;
        private String canTakeStatus;
        private String outsourcerId;
        private String outsourcerName;
        private String entryDate;
        private int status;
        private int isDel;
        private String createTime;
        private String updateTime;
        private String directContactName;
        private String directContactPhone;
        private String isReceive;

        public String getIsReceive() {
            return isReceive == null ? "" : isReceive;
        }

        public void setIsReceive(String isReceive) {
            this.isReceive = isReceive == null ? "" : isReceive;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCleanerNo() {
            return cleanerNo == null ? "" : cleanerNo;
        }

        public void setCleanerNo(String cleanerNo) {
            this.cleanerNo = cleanerNo == null ? "" : cleanerNo;
        }

        public String getName() {
            return name == null ? "" : name;
        }

        public void setName(String name) {
            this.name = name == null ? "" : name;
        }

        public String getAge() {
            return age == null ? "" : age;
        }

        public void setAge(String age) {
            this.age = age == null ? "" : age;
        }

        public String getWorkAge() {
            return workAge == null ? "" : workAge;
        }

        public void setWorkAge(String workAge) {
            this.workAge = workAge == null ? "" : workAge;
        }

        public String getPhone() {
            return phone == null ? "" : phone;
        }

        public void setPhone(String phone) {
            this.phone = phone == null ? "" : phone;
        }

        public String getIdNumber() {
            return idNumber == null ? "" : idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber == null ? "" : idNumber;
        }

        public String getPassword() {
            return password == null ? "" : password;
        }

        public void setPassword(String password) {
            this.password = password == null ? "" : password;
        }

        public String getSex() {
            return sex == null ? "" : sex;
        }

        public void setSex(String sex) {
            this.sex = sex == null ? "" : sex;
        }

        public String getStartDate() {
            return startDate == null ? "" : startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate == null ? "" : startDate;
        }

        public String getEndDate() {
            return endDate == null ? "" : endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate == null ? "" : endDate;
        }

        public String getBirthDate() {
            return birthDate == null ? "" : birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate == null ? "" : birthDate;
        }

        public String getHeadpicPath() {
            return headpicPath == null ? "" : headpicPath;
        }

        public void setHeadpicPath(String headpicPath) {
            this.headpicPath = headpicPath == null ? "" : headpicPath;
        }

        public String getPortraitPath() {
            return portraitPath == null ? "" : portraitPath;
        }

        public void setPortraitPath(String portraitPath) {
            this.portraitPath = portraitPath == null ? "" : portraitPath;
        }

        public String getNationalEmblemPath() {
            return nationalEmblemPath == null ? "" : nationalEmblemPath;
        }

        public void setNationalEmblemPath(String nationalEmblemPath) {
            this.nationalEmblemPath = nationalEmblemPath == null ? "" : nationalEmblemPath;
        }

        public String getHealthCertNo() {
            return healthCertNo == null ? "" : healthCertNo;
        }

        public void setHealthCertNo(String healthCertNo) {
            this.healthCertNo = healthCertNo == null ? "" : healthCertNo;
        }

        public String getHealthCertDate() {
            return healthCertDate == null ? "" : healthCertDate;
        }

        public void setHealthCertDate(String healthCertDate) {
            this.healthCertDate = healthCertDate == null ? "" : healthCertDate;
        }

        public String getHealthCertPath() {
            return healthCertPath == null ? "" : healthCertPath;
        }

        public void setHealthCertPath(String healthCertPath) {
            this.healthCertPath = healthCertPath == null ? "" : healthCertPath;
        }

        public String getProQualiCertPath() {
            return proQualiCertPath == null ? "" : proQualiCertPath;
        }

        public void setProQualiCertPath(String proQualiCertPath) {
            this.proQualiCertPath = proQualiCertPath == null ? "" : proQualiCertPath;
        }

        public String getProQualiCertPathList() {
            return proQualiCertPathList == null ? "" : proQualiCertPathList;
        }

        public void setProQualiCertPathList(String proQualiCertPathList) {
            this.proQualiCertPathList = proQualiCertPathList == null ? "" : proQualiCertPathList;
        }

        public String getAreaProvinceId() {
            return areaProvinceId == null ? "" : areaProvinceId;
        }

        public void setAreaProvinceId(String areaProvinceId) {
            this.areaProvinceId = areaProvinceId == null ? "" : areaProvinceId;
        }

        public String getAreaProvinceName() {
            return areaProvinceName == null ? "" : areaProvinceName;
        }

        public void setAreaProvinceName(String areaProvinceName) {
            this.areaProvinceName = areaProvinceName == null ? "" : areaProvinceName;
        }

        public String getAreaCityId() {
            return areaCityId == null ? "" : areaCityId;
        }

        public void setAreaCityId(String areaCityId) {
            this.areaCityId = areaCityId == null ? "" : areaCityId;
        }

        public String getAreaCityName() {
            return areaCityName == null ? "" : areaCityName;
        }

        public void setAreaCityName(String areaCityName) {
            this.areaCityName = areaCityName == null ? "" : areaCityName;
        }

        public String getAreaCountyId() {
            return areaCountyId == null ? "" : areaCountyId;
        }

        public void setAreaCountyId(String areaCountyId) {
            this.areaCountyId = areaCountyId == null ? "" : areaCountyId;
        }

        public String getAreaCountyName() {
            return areaCountyName == null ? "" : areaCountyName;
        }

        public void setAreaCountyName(String areaCountyName) {
            this.areaCountyName = areaCountyName == null ? "" : areaCountyName;
        }

        public String getServiceAreaId() {
            return serviceAreaId == null ? "" : serviceAreaId;
        }

        public void setServiceAreaId(String serviceAreaId) {
            this.serviceAreaId = serviceAreaId == null ? "" : serviceAreaId;
        }

        public String getServiceAreaName() {
            return serviceAreaName == null ? "" : serviceAreaName;
        }

        public void setServiceAreaName(String serviceAreaName) {
            this.serviceAreaName = serviceAreaName == null ? "" : serviceAreaName;
        }

        public String getProjectBudgetId() {
            return projectBudgetId == null ? "" : projectBudgetId;
        }

        public void setProjectBudgetId(String projectBudgetId) {
            this.projectBudgetId = projectBudgetId == null ? "" : projectBudgetId;
        }

        public String getProjectBudgetName() {
            return projectBudgetName == null ? "" : projectBudgetName;
        }

        public void setProjectBudgetName(String projectBudgetName) {
            this.projectBudgetName = projectBudgetName == null ? "" : projectBudgetName;
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

        public String getServiceParentId() {
            return serviceParentId == null ? "" : serviceParentId;
        }

        public void setServiceParentId(String serviceParentId) {
            this.serviceParentId = serviceParentId == null ? "" : serviceParentId;
        }

        public String getServiceParentName() {
            return serviceParentName == null ? "" : serviceParentName;
        }

        public void setServiceParentName(String serviceParentName) {
            this.serviceParentName = serviceParentName == null ? "" : serviceParentName;
        }

        public String getLevelId() {
            return levelId == null ? "" : levelId;
        }

        public void setLevelId(String levelId) {
            this.levelId = levelId == null ? "" : levelId;
        }

        public String getLevelName() {
            return levelName == null ? "" : levelName;
        }

        public void setLevelName(String levelName) {
            this.levelName = levelName == null ? "" : levelName;
        }

        public String getCanTakeStatus() {
            return canTakeStatus == null ? "" : canTakeStatus;
        }

        public void setCanTakeStatus(String canTakeStatus) {
            this.canTakeStatus = canTakeStatus == null ? "" : canTakeStatus;
        }

        public String getOutsourcerId() {
            return outsourcerId == null ? "" : outsourcerId;
        }

        public void setOutsourcerId(String outsourcerId) {
            this.outsourcerId = outsourcerId == null ? "" : outsourcerId;
        }

        public String getOutsourcerName() {
            return outsourcerName == null ? "" : outsourcerName;
        }

        public void setOutsourcerName(String outsourcerName) {
            this.outsourcerName = outsourcerName == null ? "" : outsourcerName;
        }

        public String getEntryDate() {
            return entryDate == null ? "" : entryDate;
        }

        public void setEntryDate(String entryDate) {
            this.entryDate = entryDate == null ? "" : entryDate;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public String getDirectContactName() {
            return directContactName == null ? "" : directContactName;
        }

        public void setDirectContactName(String directContactName) {
            this.directContactName = directContactName == null ? "" : directContactName;
        }

        public String getDirectContactPhone() {
            return directContactPhone == null ? "" : directContactPhone;
        }

        public void setDirectContactPhone(String directContactPhone) {
            this.directContactPhone = directContactPhone == null ? "" : directContactPhone;
        }
    }

}
