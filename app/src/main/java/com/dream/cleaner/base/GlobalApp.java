package com.dream.cleaner.base;

import android.os.Environment;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :全局静态字符串类
 */
public class GlobalApp {

    public static final String BUS_FRAGMENT_PLAN = "bus_fragment_plan";
    public static final String BUS_LOGIN_ACTIVITY = "bus_login_activity";
    public static final String TOKEN = "token";
    public static final String VERIFY_TOKEN = "verifyToken";
    /**
     * 保洁员编号
     */
    public static final String CLEANER_NO = "cleanerNo";
    /**
     * 保洁员id
     */
    public static final String CLEANER_ID = "cleanerId";
    /**
     * 姓名
     */
    public static final String NAME = "name";
    /**
     * 年龄
     */
    public static final String AGE = "age";
    /**
     * 工作年龄
     */
    public static final String WORK_AGE = "workAge";
    /**
     * 手机号
     */
    public static final String PHONE = "phone";
    /**
     * 身份证号
     */
    public static final String ID_NUMBER = "idNumber";
    /**
     * 性别：0->男；1->女
     */
    public static final String SEX = "sex";
    /**
     * 头像地址
     */
    public static final String HEADPIC_PATH = "headpicPath";
    /**
     * 健康证号
     */
    public static final String HEALTH_CERT_NO = "healthCertNo";

    /**
     * 健康证时间
     */
    public static final String HEALTH_CERT_DATE = "healthCertDate";

    /**
     * 健康证地址
     */
    public static final String HEALTH_CERT_PATH = "healthCertPath";

    /**
     * 所属公司-外包商
     */
    public static final String OUT_SOURCE_ID = "outsourceId";
    /**
     * 所属公司-外包商名称
     */
    public static final String OUT_SOURCE_NAME = "outsourceName";

    /**
     * 入职日期
     */
    public static final String ENTRY_DATE = "entryDate";

    /**
     * 所属区域
     */
    public static final String SERVICE_AREA_NAME = "serviceAreaName";
    /**
     * 服务名称
     */
    public static final String SERVICE_NAME = "serviceName";

    /**
     * 直属联系人姓名
     */
    public static final String DIRECT_CONTACT_NAME = "directContactName";
    /**
     * 直属联系人手机号
     */
    public static final String DIRECT_CONTACT_PHONE = "directContactPhone";


    /**
     * 1 保存用户账号密码
     * 其余不保存
     */
    public static String REMEMBER_PASSWORD = "remember_password";
    public static String USER_LOGIN_MOBILE = "user_login_mobile";
    public static String USER_LOGIN_PASSWORD = "user_login_password";
    /**
     * 用户协议
     */
    public static String USER_AGREEMENT = "本应用尊重并保护所有使用服务用户的个人隐私权。为了给您提供更准确、更有个性化的服务，本应用会按照本隐私权政策的规定使用和披露您的个人信息。但本应用将以高度的勤勉、审慎义务对待这些信息。除本隐私权政策另有规定外，在未征得您事先许可的情况下，本应用不会将这些信息对外披露或向第三方提供。本应用会不时更新本隐私权政策。 您在同意本应用服务使用协议之时，即视为您已经同意本隐私权政策全部内容。本隐私权政策属于本应用服务使用协议不可分割的一部分。";
    /**
     * 隐私权
     */
    public static String RIGHTS_OF_PRIVACY = "本应用尊重并保护所有使用服务用户的个人隐私权。为了给您提供更准确、更有个性化的服务，本应用会按照本隐私权政策的规定使用和披露您的个人信息。但本应用将以高度的勤勉、审慎义务对待这些信息。除本隐私权政策另有规定外，在未征得您事先许可的情况下，本应用不会将这些信息对外披露或向第三方提供。本应用会不时更新本隐私权政策。 您在同意本应用服务使用协议之时，即视为您已经同意本隐私权政策全部内容。本隐私权政策属于本应用服务使用协议不可分割的一部分。";

    /**
     * app下载地址
     */
    public static final String DOWNLOAD_PATH = Environment.getExternalStorageDirectory() + "/BaoJieIcon/";

}
