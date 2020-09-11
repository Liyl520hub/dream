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

    private int cleanerId;
    private int year;
    private int month;
    private int totalWages;
    private int deductionWages;
    private int netWages;
    private int orderNum;
    private String startTime;
    private String endTime;

    public int getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(int cleanerId) {
        this.cleanerId = cleanerId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getTotalWages() {
        return totalWages;
    }

    public void setTotalWages(int totalWages) {
        this.totalWages = totalWages;
    }

    public int getDeductionWages() {
        return deductionWages;
    }

    public void setDeductionWages(int deductionWages) {
        this.deductionWages = deductionWages;
    }

    public int getNetWages() {
        return netWages;
    }

    public void setNetWages(int netWages) {
        this.netWages = netWages;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
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
