package com.dream.cleaner.beans.login;

/**
 * @author : admin
 * date   : 2020/9/2
 * desc   : 登录请求body
 */
public class LoginParam  {


    /**
     * phone :
     * token :
     * cleaner : {"id":0,"cleanerNo":"","name":"","age":"","phone":"","idNumber":"","password":"","sex":0,"startDate":"","endDate":"","birthDate":"","headpicPath":"","portraitPath":"","nationalEmblemPath":"","healthCertNo":"","healthCertDate":"","healthCertPath":"","proQualiCertPath":"","serviceAreaId":0,"projectId":0,"serviceId":0,"serviceParentId":0,"levelId":0,"canTakeStatus":0,"outsourcerId":0,"entryDate":"","status":0,"isDel":0,"createTime":"","updateTime":"","directContactName":"","directContactPhone":""}
     * password : 123456
     * verifyToken :
     * imgCode :
     * code :
     */

    private String phone;
    private String token;
    private CleanerBean cleaner;
    private String password;
    private String verifyToken;
    private String imgCode;
    private String code;

    public String getPhone() {
        return phone == null ? "" : phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? "" : phone;
    }

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

    public String getPassword() {
        return password == null ? "" : password;
    }

    public void setPassword(String password) {
        this.password = password == null ? "" : password;
    }

    public String getVerifyToken() {
        return verifyToken == null ? "" : verifyToken;
    }

    public void setVerifyToken(String verifyToken) {
        this.verifyToken = verifyToken == null ? "" : verifyToken;
    }

    public String getImgCode() {
        return imgCode == null ? "" : imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode == null ? "" : imgCode;
    }

    public String getCode() {
        return code == null ? "" : code;
    }

    public void setCode(String code) {
        this.code = code == null ? "" : code;
    }

    public static class CleanerBean {
        /**
         * id : 0
         * cleanerNo :
         * name :
         * age :
         * phone :
         * idNumber :
         * password :
         * sex : 0
         * startDate :
         * endDate :
         * birthDate :
         * headpicPath :
         * portraitPath :
         * nationalEmblemPath :
         * healthCertNo :
         * healthCertDate :
         * healthCertPath :
         * proQualiCertPath :
         * serviceAreaId : 0
         * projectId : 0
         * serviceId : 0
         * serviceParentId : 0
         * levelId : 0
         * canTakeStatus : 0
         * outsourcerId : 0
         * entryDate :
         * status : 0
         * isDel : 0
         * createTime :
         * updateTime :
         * directContactName :
         * directContactPhone :
         */

        private int id;
        private String cleanerNo;
        private String name;
        private String age;
        private String phone;
        private String idNumber;
        private String password;
        private int sex;
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
        private int serviceAreaId;
        private int projectId;
        private int serviceId;
        private int serviceParentId;
        private int levelId;
        private int canTakeStatus;
        private int outsourcerId;
        private String entryDate;
        private int status;
        private int isDel;
        private String createTime;
        private String updateTime;
        private String directContactName;
        private String directContactPhone;


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

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
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

        public int getServiceAreaId() {
            return serviceAreaId;
        }

        public void setServiceAreaId(int serviceAreaId) {
            this.serviceAreaId = serviceAreaId;
        }

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        public int getServiceId() {
            return serviceId;
        }

        public void setServiceId(int serviceId) {
            this.serviceId = serviceId;
        }

        public int getServiceParentId() {
            return serviceParentId;
        }

        public void setServiceParentId(int serviceParentId) {
            this.serviceParentId = serviceParentId;
        }

        public int getLevelId() {
            return levelId;
        }

        public void setLevelId(int levelId) {
            this.levelId = levelId;
        }

        public int getCanTakeStatus() {
            return canTakeStatus;
        }

        public void setCanTakeStatus(int canTakeStatus) {
            this.canTakeStatus = canTakeStatus;
        }

        public int getOutsourcerId() {
            return outsourcerId;
        }

        public void setOutsourcerId(int outsourcerId) {
            this.outsourcerId = outsourcerId;
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
