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
    public static final String LOGIN = "app/cleaner/login";

    /**
     * 保洁端获取验证码
     */
    public static final String GET_IMAGE = "app/cleaner/getImage";


    /**
     * getPhoneCode
     */
    public static final String GET_PHONE_CODE = "app/cleaner/getPhoneCode";


    /**
     * 保洁端获取用户协议
     */
    public static final String AGREEMENT = "app/cleaner/agreement";
    /**
     * 保洁端获取隐私条款
     */
    public static final String PRIVACY = "app/cleaner/privacy";


    /**
     * 保洁端退出登录
     */
    public static final String LOGOUT = "app/cleaner/logout";


    /**
     * 保洁端检查手机验证码
     */
    public static final String CHECK_PHONE_CODE = "app/cleaner/checkPhoneCode";

    /**
     * 保洁端检查图形验证码
     */
    public static final String CHECK_IMG_CODE = "app/cleaner/checkImgCode";


    /**
     * 保洁端修改密码
     */
    public static final String UPDATE_PASSWORD = "app/cleaner/updatePassword";

//--------------------------------------------保洁端申请物料------------------------------------------------------


    /**
     * 领取物料申请单表
     */
    public static final String COLLECT_ID = "app/cleaner/materielApply/collect/{id}";


    /**
     * 查询自己物料申请单
     */
    public static final String GET_PAGE_LIST = "app/cleaner/materielApply/getPageList";


    /**
     * 物料申请单表详情
     */
    public static final String MATERIEL_APPLY_INFO_ID = "app/cleaner/materielApply/info/{id}";


    /**
     * 提交物料申请单
     */
    public static final String SUBMIT_MATERIEL = "app/cleaner/materielApply/submit";

//--------------------------------------------保洁端物料------------------------------------------------------


    /**
     * 拉取分类物料
     */
    public static final String MATERIEL_LIST = "app/cleaner/materiel/list";

//--------------------------------------------保洁端任务------------------------------------------------------

    /**
     * 保洁员到达
     */
    public static final String ARRIVE = "app/cleaner/task/arrive";


    /**
     * 确认开始-扫前准备上传照片
     */
    public static final String BEFORE_CLEAN = "app/cleaner/task/beforeClean";


    /**
     * 确认完成
     */
    public static final String CONFIRM_FINISH = "app/cleaner/task/confirmFinish";


    /**
     * 出发-变成上门中
     */
    public static final String TASK_GO = "app/cleaner/task/go";


    /**
     * 任务列表
     */
    public static final String TASK_LIST = "app/cleaner/task/list";

   /**
     * 获取服务列表
     */
    public static final String GET_SERVICE_CLASS_LIST = "app/cleaner/task/getServiceClassList";

   /**
     * 获取订单类型列表
     */
    public static final String GET_ORDER_TYPE_LIST = "app/cleaner/task/getOrderTypeList";


    /**
     * 接单接口
     */
    public static final String TASK_RECEIVE = "app/cleaner/task/receive";


    /**
     * 任务订单详情
     */
    public static final String TASK_INFO_ID = "app/cleaner/task/taskInfo/{id}";

    //--------------------------------------------保洁端个人中心------------------------------------------------------


    /**
     * 获取个人计划 月
     */
    public static final String GET_CLEANER_PLAN_MONTH = "app/cleaner/userinfo/getCleanerMonthPlan";

   /**
     * 获取个人计划 月
     */
    public static final String GET_CLEANER_PLAN_DAY = "app/cleaner/userinfo/getCleanerDayPlan";


    /**
     * 我的收益
     */
    public static final String MY_INCOME = "app/cleaner/userinfo/income";


    /**
     * 我的收益工单列表
     */
    public static final String INCOME_LIST = "app/cleaner/userinfo/list";


    /**
     * 个人信息
     */
    public static final String USER_INFO = "app/cleaner/userinfo/{id}";

    //--------------------------------------------保洁端oss上传图片------------------------------------------------------

    /**
     * OSS文件上传
     */
    public static final String OSS_UPLOAD = "app/cleaner/oss/upload";

    //--------------------------------------------保洁员端请假------------------------------------------------------

    /**
     * 请假申请
     */
    public static final String LEAVE_APPLY = "app/cleaner/leave/apply";


    /**
     * 请假申请详情
     */
    public static final String LEAVE_APPLY_DETAIL_ID = "app/cleaner/leave/apply/detail/{id}";


    /**
     * 请假申请列表
     */
    public static final String LEAVE_APPLY_LIST = "app/cleaner/leave/apply/list";

    //--------------------------------------------保洁员端消息------------------------------------------------------

    /**
     * 消息详情
     */
    public static final String MESSAGE_DETAIL_ID = "app/cleaner/message/detail/{id}";


    /**
     * 消息列表
     */
    public static final String MESSAGE_LIST = "app/cleaner/message/list";


    /**
     * 修改为已读
     */
    public static final String MESSAGE_READ_ID = "app/cleaner/message/read/{id}";


}