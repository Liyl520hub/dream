package com.dream.cleaner.beans.my;

/**
 * @author : Liyalei
 * date   : 2020/9/29
 * desc   :
 */
public class CleanerOrderCountBean {


    /**
     * cleanerId : 23
     * time :
     * finishOrderCount : 0
     * cancelOrderCount : 0
     * afterOrderCount : 0
     */

    private String cleanerId;
    private String time;
    private String finishOrderCount;
    private String cancelOrderCount;
    private String afterOrderCount;

    public String getCleanerId() {
        return cleanerId == null ? "" : cleanerId;
    }

    public void setCleanerId(String cleanerId) {
        this.cleanerId = cleanerId == null ? "" : cleanerId;
    }

    public String getTime() {
        return time == null ? "" : time;
    }

    public void setTime(String time) {
        this.time = time == null ? "" : time;
    }

    public String getFinishOrderCount() {
        return finishOrderCount == null ? "" : finishOrderCount;
    }

    public void setFinishOrderCount(String finishOrderCount) {
        this.finishOrderCount = finishOrderCount == null ? "" : finishOrderCount;
    }

    public String getCancelOrderCount() {
        return cancelOrderCount == null ? "" : cancelOrderCount;
    }

    public void setCancelOrderCount(String cancelOrderCount) {
        this.cancelOrderCount = cancelOrderCount == null ? "" : cancelOrderCount;
    }

    public String getAfterOrderCount() {
        return afterOrderCount == null ? "" : afterOrderCount;
    }

    public void setAfterOrderCount(String afterOrderCount) {
        this.afterOrderCount = afterOrderCount == null ? "" : afterOrderCount;
    }
}
