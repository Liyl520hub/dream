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
        SPUtils.getInstance().put(GlobalApp.CLEANER_NO, loginBean.getCleaner().getCleanerNo());
        SPUtils.getInstance().put(GlobalApp.NAME, loginBean.getCleaner().getName());
        SPUtils.getInstance().put(GlobalApp.AGE, loginBean.getCleaner().getAge());
        SPUtils.getInstance().put(GlobalApp.WORK_AGE, loginBean.getCleaner().getWorkAge());
        SPUtils.getInstance().put(GlobalApp.PHONE, loginBean.getCleaner().getPhone());
        SPUtils.getInstance().put(GlobalApp.ID_NUMBER, loginBean.getCleaner().getIdNumber());
        SPUtils.getInstance().put(GlobalApp.SEX, loginBean.getCleaner().getSex());
        SPUtils.getInstance().put(GlobalApp.HEADPIC_PATH, loginBean.getCleaner().getHeadpicPath());
        SPUtils.getInstance().put(GlobalApp.HEALTH_CERT_NO, loginBean.getCleaner().getHealthCertNo());
        SPUtils.getInstance().put(GlobalApp.HEALTH_CERT_DATE, loginBean.getCleaner().getHealthCertDate());
        SPUtils.getInstance().put(GlobalApp.HEALTH_CERT_PATH, loginBean.getCleaner().getHealthCertPath());
        SPUtils.getInstance().put(GlobalApp.OUT_SOURCE_ID, loginBean.getCleaner().getOutsourcerId());
        SPUtils.getInstance().put(GlobalApp.ENTRY_DATE, loginBean.getCleaner().getEntryDate());
        SPUtils.getInstance().put(GlobalApp.DIRECT_CONTACT_NAME, loginBean.getCleaner().getDirectContactName());
        SPUtils.getInstance().put(GlobalApp.DIRECT_CONTACT_PHONE, loginBean.getCleaner().getDirectContactPhone());
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
     * @return 入职日期
     */
    public static String getEntryDate() {
        return SPUtils.getInstance().getString(GlobalApp.ENTRY_DATE, "");
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


}
