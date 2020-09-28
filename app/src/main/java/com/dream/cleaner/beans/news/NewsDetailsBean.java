package com.dream.cleaner.beans.news;

/**
 * @author : liyl
 * date   : 2020/9/10
 * desc   :
 */
public class NewsDetailsBean {


    /**
     * id : 0
     * orderNo :
     * userId : 0
     * userType :
     * messageType : 0
     * title :
     * messagePerson :
     * messageTime :
     * messageContent :
     * status : 0
     * isDel : 0
     * createTime :
     * updateTime :
     */

    private int id;
    private String orderNo;
    private String userId;
    private String userType;
    private String messageType;
    private String title;
    private String messagePerson;
    private String messageTime;
    private String messageContent;
    private String status;
    private String isDel;
    private String createTime;
    private String updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo == null ? "" : orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? "" : orderNo;
    }

    public String getUserId() {
        return userId == null ? "" : userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? "" : userId;
    }

    public String getUserType() {
        return userType == null ? "" : userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? "" : userType;
    }

    public String getMessageType() {
        return messageType == null ? "" : messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType == null ? "" : messageType;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title == null ? "" : title;
    }

    public String getMessagePerson() {
        return messagePerson == null ? "" : messagePerson;
    }

    public void setMessagePerson(String messagePerson) {
        this.messagePerson = messagePerson == null ? "" : messagePerson;
    }

    public String getMessageTime() {
        return messageTime == null ? "" : messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime == null ? "" : messageTime;
    }

    public String getMessageContent() {
        return messageContent == null ? "" : messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? "" : messageContent;
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
}
