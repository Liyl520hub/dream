package com.dream.cleaner.beans.news;

import java.util.List;

/**
 * @author : liyl
 * date   : 2020/9/9
 * desc   : 消息列表
 */
public class NewsListBean {


    /**
     * total : 0
     * records : [{"id":0,"orderNo":"","userId":0,"userType":"","messageType":0,"title":"","messagePerson":"","messageTime":"","messageContent":"","status":0,"isDel":0,"createTime":"","updateTime":""}]
     * pageIndex : 0
     * pageSize : 0
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
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class RecordsBean {
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
        private int userId;
        private String userType;
        private int messageType;
        private String title;
        private String messagePerson;
        private String messageTime;
        private String messageContent;
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

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public int getMessageType() {
            return messageType;
        }

        public void setMessageType(int messageType) {
            this.messageType = messageType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMessagePerson() {
            return messagePerson;
        }

        public void setMessagePerson(String messagePerson) {
            this.messagePerson = messagePerson;
        }

        public String getMessageTime() {
            return messageTime;
        }

        public void setMessageTime(String messageTime) {
            this.messageTime = messageTime;
        }

        public String getMessageContent() {
            return messageContent;
        }

        public void setMessageContent(String messageContent) {
            this.messageContent = messageContent;
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
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }


}
