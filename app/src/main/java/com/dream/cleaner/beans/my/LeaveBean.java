package com.dream.cleaner.beans.my;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Liyalei
 * date   : 2020/9/12
 * desc   :
 */
public class LeaveBean {


    /**
     * total : 1
     * records : [{"id":8,"cleanerId":1,"cleanerNo":"ceshi0001","approvalNo":"202009112319304532313","name":"test","phone":"18010476582","startTime":"2020-09-11 23:19:30","endTime":"2020-09-11 23:19:30","duration":0,"reason":"","approvalTime":null,"status":0,"isDel":0,"createTime":"2020-09-11 23:19:30","updateTime":"2020-09-11 23:19:30"}]
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
         * id : 8
         * cleanerId : 1
         * cleanerNo : ceshi0001
         * approvalNo : 202009112319304532313
         * name : test
         * phone : 18010476582
         * startTime : 2020-09-11 23:19:30
         * endTime : 2020-09-11 23:19:30
         * duration : 0
         * reason :
         * approvalTime : null
         * status : 0
         * isDel : 0
         * createTime : 2020-09-11 23:19:30
         * updateTime : 2020-09-11 23:19:30
         */

        private int id;
        private int cleanerId;
        private String cleanerNo;
        private String approvalNo;
        private String name;
        private String phone;
        private String startTime;
        private String endTime;
        private int duration;
        private String reason;
        private String approvalTime;
        private int status;
        private int isDel;
        private String createTime;
        private String updateTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCleanerId() {
            return cleanerId;
        }

        public void setCleanerId(int cleanerId) {
            this.cleanerId = cleanerId;
        }

        public String getCleanerNo() {
            return cleanerNo == null ? "" : cleanerNo;
        }

        public void setCleanerNo(String cleanerNo) {
            this.cleanerNo = cleanerNo == null ? "" : cleanerNo;
        }

        public String getApprovalNo() {
            return approvalNo == null ? "" : approvalNo;
        }

        public void setApprovalNo(String approvalNo) {
            this.approvalNo = approvalNo == null ? "" : approvalNo;
        }

        public String getName() {
            return name == null ? "" : name;
        }

        public void setName(String name) {
            this.name = name == null ? "" : name;
        }

        public String getPhone() {
            return phone == null ? "" : phone;
        }

        public void setPhone(String phone) {
            this.phone = phone == null ? "" : phone;
        }

        public String getStartTime() {
            return startTime == null ? "" : startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime == null ? "" : startTime;
        }

        public String getEndTime() {
            return endTime == null ? "" : endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime == null ? "" : endTime;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getReason() {
            return reason == null ? "" : reason;
        }

        public void setReason(String reason) {
            this.reason = reason == null ? "" : reason;
        }

        public String getApprovalTime() {
            return approvalTime == null ? "" : approvalTime;
        }

        public void setApprovalTime(String approvalTime) {
            this.approvalTime = approvalTime == null ? "" : approvalTime;
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
    }
}
