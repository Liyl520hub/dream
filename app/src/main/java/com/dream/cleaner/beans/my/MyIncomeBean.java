package com.dream.cleaner.beans.my;

/**
 * @author : liyl
 * date   : 2020/8/23
 * desc   :
 */
public class MyIncomeBean {


    /**
     * cleanerId : 1
     * year : 2020
     * month : 9
     * totalWages : 0
     * deductionWages : 0
     * netWages : 0
     * orderNum : 0
     * startTime : 2020-09-01 00:00:00
     * endTime : 2020-09-30 23:59:59
     */

    private String  cleanerId;
    private String year;
    private String month;
    private String totalWages;
    private String deductionWages;
    private String netWages;
    private String orderNum;
    private String startTime;
    private String endTime;

    public String getCleanerId() {
        return cleanerId == null ? "" : cleanerId;
    }

    public void setCleanerId(String cleanerId) {
        this.cleanerId = cleanerId == null ? "" : cleanerId;
    }

    public String getYear() {
        return year == null ? "" : year;
    }

    public void setYear(String year) {
        this.year = year == null ? "1" : year;
    }

    public String getMonth() {
        return month == null ? "1" : month;
    }

    public void setMonth(String month) {
        this.month = month == null ? "" : month;
    }

    public String getTotalWages() {
        return totalWages == null ? "" : totalWages;
    }

    public void setTotalWages(String totalWages) {
        this.totalWages = totalWages == null ? "" : totalWages;
    }

    public String getDeductionWages() {
        return deductionWages == null ? "" : deductionWages;
    }

    public void setDeductionWages(String deductionWages) {
        this.deductionWages = deductionWages == null ? "" : deductionWages;
    }

    public String getNetWages() {
        return netWages == null ? "" : netWages;
    }

    public void setNetWages(String netWages) {
        this.netWages = netWages == null ? "" : netWages;
    }

    public String getOrderNum() {
        return orderNum == null ? "" : orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? "" : orderNum;
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
}
