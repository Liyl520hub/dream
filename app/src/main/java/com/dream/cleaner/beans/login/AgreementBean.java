package com.dream.cleaner.beans.login;

/**
 * @author : admin
 * date   : 2020/9/7
 * desc   :articleText webview加载
 */
public class AgreementBean {

        /**
         * id : null
         * articleMtitle : 保洁员登陆用户协议
         * articleOtitle : null
         * inputTime : null
         * articleText : &lt;p&gt;&lt;img src=&quot;https://braveheart.oss-cn-beijing.aliyuncs.com/test/2020-09-04/06937caf034c4ce798f68aedb7f9ab8b-090f9c1d2c8d432ab4e46ce089a8bee6-8e9bdf3e3fe55da92cdfe7652c789ed1.jpg&quot;&gt;&lt;/p&gt;
         * status : null
         * isDel : null
         * createTime : null
         * updateTime : null
         */

        private String id;
        private String articleMtitle;
        private String articleOtitle;
        private String inputTime;
        private String articleText;
        private String status;
        private String isDel;
        private String createTime;
        private String updateTime;

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id;
    }

    public String getArticleMtitle() {
        return articleMtitle == null ? "" : articleMtitle;
    }

    public void setArticleMtitle(String articleMtitle) {
        this.articleMtitle = articleMtitle == null ? "" : articleMtitle;
    }

    public String getArticleOtitle() {
        return articleOtitle == null ? "" : articleOtitle;
    }

    public void setArticleOtitle(String articleOtitle) {
        this.articleOtitle = articleOtitle == null ? "" : articleOtitle;
    }

    public String getInputTime() {
        return inputTime == null ? "" : inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime == null ? "" : inputTime;
    }

    public String getArticleText() {
        return articleText == null ? "" : articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText == null ? "" : articleText;
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
