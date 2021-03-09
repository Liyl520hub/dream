package com.dream.cleaner.beans;

/**
 * @author : admin
 * date   : 2020/9/17
 * desc   :
 */
public class UploadImageBean {


    /**
     * fileSize : 65414
     * fileAPUrl : test/2020-09-17/54022d120c7e42eabf1696c203ae0491-app_logo.png
     * webUrl : https://braveheart.oss-cn-beijing.aliyuncs.com/test/2020-09-17/54022d120c7e42eabf1696c203ae0491-app_logo.png
     * fileSuffix : png
     * fileBucket :
     * oldFileName : braveheart
     * folder : test
     */

    private int fileSize;
    private String fileAPUrl;
    private String webUrl;
    private String fileSuffix;
    private String fileBucket;
    private String oldFileName;
    private String folder;

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileAPUrl() {
        return fileAPUrl == null ? "" : fileAPUrl;
    }

    public void setFileAPUrl(String fileAPUrl) {
        this.fileAPUrl = fileAPUrl == null ? "" : fileAPUrl;
    }

    public String getWebUrl() {
        return webUrl == null ? "" : webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl == null ? "" : webUrl;
    }

    public String getFileSuffix() {
        return fileSuffix == null ? "" : fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix == null ? "" : fileSuffix;
    }

    public String getFileBucket() {
        return fileBucket == null ? "" : fileBucket;
    }

    public void setFileBucket(String fileBucket) {
        this.fileBucket = fileBucket == null ? "" : fileBucket;
    }

    public String getOldFileName() {
        return oldFileName == null ? "" : oldFileName;
    }

    public void setOldFileName(String oldFileName) {
        this.oldFileName = oldFileName == null ? "" : oldFileName;
    }

    public String getFolder() {
        return folder == null ? "" : folder;
    }

    public void setFolder(String folder) {
        this.folder = folder == null ? "" : folder;
    }
}
