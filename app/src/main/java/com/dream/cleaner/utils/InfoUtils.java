package com.dream.cleaner.utils;

import com.blankj.utilcode.util.SPUtils;
import com.dream.cleaner.base.GlobalApp;
import com.dream.cleaner.beans.login.LoginBean;

/**
 * @author : Liyalei
 * date   : 2020/9/8
 * desc   :个人信息Utils 存储Sp
 */
public class InfoUtils {


    public static void setLoginBean(LoginBean loginBean) {
        SPUtils.getInstance().put(GlobalApp.TOKEN, loginBean.getToken());
        setCleanerBean(loginBean.getCleaner());
    }

    public static void setCleanerBean(LoginBean.CleanerBean cleanerBean) {
        SPUtils.getInstance().put(GlobalApp.CLEANER_ID, cleanerBean.getId() + "");
        SPUtils.getInstance().put(GlobalApp.CLEANER_NO, cleanerBean.getCleanerNo());
        SPUtils.getInstance().put(GlobalApp.NAME, cleanerBean.getName());
        SPUtils.getInstance().put(GlobalApp.AGE, cleanerBean.getAge());
        SPUtils.getInstance().put(GlobalApp.WORK_AGE, cleanerBean.getWorkAge());
        SPUtils.getInstance().put(GlobalApp.PHONE, cleanerBean.getPhone());
        SPUtils.getInstance().put(GlobalApp.ID_NUMBER, cleanerBean.getIdNumber());
        SPUtils.getInstance().put(GlobalApp.SEX, cleanerBean.getSex());
        SPUtils.getInstance().put(GlobalApp.HEADPIC_PATH, cleanerBean.getHeadpicPath());
        SPUtils.getInstance().put(GlobalApp.HEALTH_CERT_NO, cleanerBean.getHealthCertNo());
        SPUtils.getInstance().put(GlobalApp.HEALTH_CERT_DATE, cleanerBean.getHealthCertDate());
        SPUtils.getInstance().put(GlobalApp.HEALTH_CERT_PATH, cleanerBean.getHealthCertPath());
        SPUtils.getInstance().put(GlobalApp.OUT_SOURCE_ID, cleanerBean.getOutsourcerId());
        SPUtils.getInstance().put(GlobalApp.OUT_SOURCE_NAME, cleanerBean.getOutsourcerName());
        SPUtils.getInstance().put(GlobalApp.ENTRY_DATE, cleanerBean.getEntryDate());
        SPUtils.getInstance().put(GlobalApp.DIRECT_CONTACT_NAME, cleanerBean.getDirectContactName());
        SPUtils.getInstance().put(GlobalApp.DIRECT_CONTACT_PHONE, cleanerBean.getDirectContactPhone());
        SPUtils.getInstance().put(GlobalApp.SERVICE_AREA_NAME, cleanerBean.getServiceAreaName());
        SPUtils.getInstance().put(GlobalApp.SERVICE_NAME, cleanerBean.getServiceName());
        SPUtils.getInstance().put(GlobalApp.USER_LEVEL, cleanerBean.getLevelId());
    }


    /**
     * @return 获取token
     */
    public static String getToken() {
        return SPUtils.getInstance().getString(GlobalApp.TOKEN, "");
    }

    /**
     * @return 获取员工编号
     */
    public static String getCleanerNo() {
        return SPUtils.getInstance().getString(GlobalApp.CLEANER_NO, "");
    }

    /**
     * @return 获取员工id
     */
    public static String getCleanerId() {
        return SPUtils.getInstance().getString(GlobalApp.CLEANER_ID, "");
    }

    /**
     * @return 获取姓名
     */
    public static String getName() {
        return SPUtils.getInstance().getString(GlobalApp.NAME, "");
    }

    /**
     * @return 获取年龄
     */
    public static String getAge() {
        return SPUtils.getInstance().getString(GlobalApp.AGE, "1");
    }

    /**
     * @return 获取工作年龄
     */
    public static String getWorkAge() {
        return SPUtils.getInstance().getString(GlobalApp.WORK_AGE, "1");
    }

    /**
     * @return 获取手机号
     */
    public static String getPhone() {
        return SPUtils.getInstance().getString(GlobalApp.PHONE, "");
    }

    /**
     * @return 获取身份证号
     */
    public static String getIdNumber() {
        return SPUtils.getInstance().getString(GlobalApp.ID_NUMBER, "");
    }

    /**
     * @return 获取性别  0 男 1 女
     */
    public static String getSex() {
        String sex = SPUtils.getInstance().getString(GlobalApp.SEX, "1");
        return "0".equals(sex) ? "男" : "女";
    }


    /**
     * @return 获取头像地址
     */
    public static String getHeadIcPath() {
        return SPUtils.getInstance().getString(GlobalApp.HEADPIC_PATH, "");
    }

    /**
     * @return 获取健康证号
     */
    public static String getHealthCertNo() {
        return SPUtils.getInstance().getString(GlobalApp.HEALTH_CERT_NO, "");
    }

    /**
     * @return 获取健康证时间
     */
    public static String getHealthCertDate() {
        return SPUtils.getInstance().getString(GlobalApp.HEALTH_CERT_DATE, "");
    }

    /**
     * @return 获取健康证地址
     */
    public static String getHealthCertPath() {
        return SPUtils.getInstance().getString(GlobalApp.HEALTH_CERT_PATH, "");
    }

    /**
     * @return 所属公司-外包商
     */
    public static String getOutSourceId() {
        return SPUtils.getInstance().getString(GlobalApp.OUT_SOURCE_ID, "");
    }

    /**
     * @return 所属公司-外包商名称
     */
    public static String getOutSourceName() {
        return SPUtils.getInstance().getString(GlobalApp.OUT_SOURCE_NAME, "");
    }

    /**
     * @return 入职日期
     */
    public static String getEntryDate() {
        return SPUtils.getInstance().getString(GlobalApp.ENTRY_DATE, "");
    }

    /**
     * @return 所属区域
     */
    public static String getServiceAreaName() {
        return SPUtils.getInstance().getString(GlobalApp.SERVICE_AREA_NAME, "");
    }

    /**
     * @return 服务名称
     */
    public static String getServiceName() {
        return SPUtils.getInstance().getString(GlobalApp.SERVICE_NAME, "");
    }

    /**
     * @return 直属联系人姓名
     */
    public static String getDirectContactName() {
        return SPUtils.getInstance().getString(GlobalApp.DIRECT_CONTACT_NAME, "");
    }

    /**
     * @return 直属联系人手机号
     */
    public static String getDirectContactPhone() {
        return SPUtils.getInstance().getString(GlobalApp.DIRECT_CONTACT_PHONE, "");
    }
    /**
     * @return 获取星级
     */
    public static String getUserLevel() {
        return SPUtils.getInstance().getString(GlobalApp.USER_LEVEL, "");
    }


    public static void clean() {
        SPUtils.getInstance().put(GlobalApp.TOKEN, "");
        SPUtils.getInstance().put(GlobalApp.CLEANER_ID, "");
        SPUtils.getInstance().put(GlobalApp.CLEANER_NO, "");
        SPUtils.getInstance().put(GlobalApp.NAME, "");
        SPUtils.getInstance().put(GlobalApp.AGE, "");
        SPUtils.getInstance().put(GlobalApp.WORK_AGE, "");
        SPUtils.getInstance().put(GlobalApp.PHONE, "");
        SPUtils.getInstance().put(GlobalApp.ID_NUMBER, "");
        SPUtils.getInstance().put(GlobalApp.SEX, "");
        SPUtils.getInstance().put(GlobalApp.HEADPIC_PATH, "");
        SPUtils.getInstance().put(GlobalApp.HEALTH_CERT_NO, "");
        SPUtils.getInstance().put(GlobalApp.HEALTH_CERT_DATE, "");
        SPUtils.getInstance().put(GlobalApp.HEALTH_CERT_PATH, "");
        SPUtils.getInstance().put(GlobalApp.OUT_SOURCE_ID, "");
        SPUtils.getInstance().put(GlobalApp.OUT_SOURCE_NAME, "");
        SPUtils.getInstance().put(GlobalApp.ENTRY_DATE, "");
        SPUtils.getInstance().put(GlobalApp.DIRECT_CONTACT_NAME, "");
        SPUtils.getInstance().put(GlobalApp.DIRECT_CONTACT_PHONE, "");
        SPUtils.getInstance().put(GlobalApp.SERVICE_AREA_NAME, "");
        SPUtils.getInstance().put(GlobalApp.SERVICE_NAME, "");
        SPUtils.getInstance().put(GlobalApp.USER_LEVEL, "");
    }
}
