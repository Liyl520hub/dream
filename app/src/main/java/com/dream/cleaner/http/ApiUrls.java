package com.dream.cleaner.http;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :
 */
public class ApiUrls {


    /**
     * 保洁端登录
     */
    public static final String LOGIN = "/api/app/cleaner/login";

    /**
     * 保洁端获取验证码
     */
    public static final String GET_IMAGE = "/api/app/cleaner/getImage";


    /**
     * getPhoneCode
     */
    public static final String GET_PHONE_CODE = "/api/app/cleaner/getPhoneCode";


    /**
     * 保洁端获取用户协议
     */
    public static final String AGREEMENT = "/api/app/cleaner/agreement";
    /**
     * 保洁端获取隐私条款
     */
    public static final String PRIVACY = "/api/app/cleaner/privacy";


    /**
     * 保洁端退出登录
     */
    public static final String LOGOUT = "/api/app/cleaner/logout";


    /**
     * 保洁端检查手机验证码
     */
    public static final String CHECK_PHONE_CODE = "/api/app/cleaner/checkPhoneCode";

    /**
     * 保洁端检查图形验证码
     */
    public static final String CHECK_IMG_CODE = "/api/app/cleaner/checkImgCode";


    /**
     * 保洁端修改密码
     */
    public static final String UPDATE_PASSWORD = "/api/app/cleaner/updatePassword";

//--------------------------------------------保洁端申请物料------------------------------------------------------


    /**
     * 领取物料申请单表
     */
    public static final String COLLECT_ID = "/api/app/cleaner/materielApply/collect/{id}";


    /**
     * 查询自己物料申请单
     */
    public static final String GET_PAGE_LIST = "/api/app/cleaner/materielApply/getPageList";


    /**
     * 物料申请单表详情
     */
    public static final String MATERIEL_APPLY_INFO_ID = "/api/app/cleaner/materielApply/info/{id}";


    /**
     * 提交物料申请单
     */
    public static final String SUBMIT_MATERIEL = "/api/app/cleaner/materielApply/submit";

//--------------------------------------------保洁端物料------------------------------------------------------


    /**
     * 拉取分类物料
     */
    public static final String MATERIEL_LIST = "/api/app/cleaner/materiel/list";

//--------------------------------------------保洁端任务------------------------------------------------------

    /**
     * 保洁员到达
     */
    public static final String ARRIVE = "/api/app/cleaner/task/arrive";


    /**
     * 确认开始-扫前准备上传照片
     */
    public static final String BEFORE_CLEAN = "/api/app/cleaner/task/beforeClean";


    /**
     * 确认完成
     */
    public static final String CONFIRM_FINISH = "/api/app/cleaner/task/confirmFinish";


    /**
     * 出发-变成上门中
     */
    public static final String TASK_GO = "/api/app/cleaner/task/go";


    /**
     * 任务列表
     */
    public static final String TASK_LIST = "/api/app/cleaner/task/list";


    /**
     * 接单接口
     */
    public static final String TASK_RECEIVE = "/api/app/cleaner/task/receive";


    /**
     * 任务订单详情
     */
    public static final String TASK_INFO_ID = "/api/app/cleaner/task/taskInfo/{id}";

    //--------------------------------------------保洁端个人中心------------------------------------------------------


    /**
     * 获取个人计划 月
     */
    public static final String GET_CLEANER_PLAN_MONTH = "/api/app/cleaner/userinfo/getCleanerMonthPlan";

   /**
     * 获取个人计划 月
     */
    public static final String GET_CLEANER_PLAN_DAY = "/api/app/cleaner/userinfo/getCleanerDayPlan";


    /**
     * 我的收益
     */
    public static final String MY_INCOME = "/api/app/cleaner/userinfo/income";


    /**
     * 个人信息
     */
    public static final String USER_INFO = "/api/app/cleaner/userinfo/{id}";

    //--------------------------------------------保洁端oss上传图片------------------------------------------------------

    /**
     * OSS文件上传
     */
    public static final String OSS_UPLOAD = "/api/app/cleaner/oss/upload";

    //--------------------------------------------保洁员端请假------------------------------------------------------

    /**
     * 请假申请
     */
    public static final String LEAVE_APPLY = "/api/app/cleaner/leave/apply";


    /**
     * 请假申请详情
     */
    public static final String LEAVE_APPLY_DETAIL_ID = "/api/app/cleaner/leave/apply/detail/{id}";


    /**
     * 请假申请列表
     */
    public static final String LEAVE_APPLY_LIST = "/api/app/cleaner/leave/apply/list";

    //--------------------------------------------保洁员端消息------------------------------------------------------

    /**
     * 消息详情
     */
    public static final String MESSAGE_DETAIL_ID = "/api/app/cleaner/message/detail/{id}";


    /**
     * 消息列表
     */
    public static final String MESSAGE_LIST = "/api/app/cleaner/message/list";


    /**
     * 修改为已读
     */
    public static final String MESSAGE_READ_ID = "/api/app/cleaner/message/read/{id}";


}