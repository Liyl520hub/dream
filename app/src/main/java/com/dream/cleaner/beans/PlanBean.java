package com.dream.cleaner.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Liyalei
 * date   : 2020/9/1
 * desc   :
 */
public class PlanBean implements Serializable {

    /**
     * planDate : 2020-09-01
     * cleanerPlanItems : [{"id":7,"no":"202009091703186815813","startTime":"2020-09-01 13:00:00.0","endTime":"2020-09-01 17:00:00.0","times":null,"type":2}]
     */

    private String planDate;
    private List<CleanerPlanItemsBean> cleanerPlanItems;

    public String getPlanDate() {
        return planDate == null ? "" : planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate == null ? "" : planDate;
    }

    public List<CleanerPlanItemsBean> getCleanerPlanItems() {
        if (cleanerPlanItems == null) {
            return new ArrayList<>();
        }
        return cleanerPlanItems;
    }

    public void setCleanerPlanItems(List<CleanerPlanItemsBean> cleanerPlanItems) {
        this.cleanerPlanItems = cleanerPlanItems;
    }

    public static class CleanerPlanItemsBean {
        /**
         * id : 7
         * no : 202009091703186815813
         * startTime : 2020-09-01 13:00:00.0
         * endTime : 2020-09-01 17:00:00.0
         * times : null
         * type : 2
         */

        private int id;
        private String no;
        private String startTime;
        private String endTime;
        private String times;
        private int type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNo() {
            return no == null ? "" : no;
        }

        public void setNo(String no) {
            this.no = no == null ? "" : no;
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

        public String getTimes() {
            return times == null ? "" : times;
        }

        public void setTimes(String times) {
            this.times = times == null ? "" : times;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

    }
}
