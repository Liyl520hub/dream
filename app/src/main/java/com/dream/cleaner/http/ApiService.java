package com.dream.cleaner.http;

import com.dream.cleaner.beans.login.LoginBean;
import com.dream.common.base.BaseBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :
 */
public interface ApiService {


    /**
     * 保洁端登录
     */
    @POST(ApiUrls.LOGIN)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> userLogin(@Field("username") String username,
                                              @Field("password") String password);

    /**
     * 保洁端获取验证码
     */
    @POST(ApiUrls.GET_IMAGE)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> getImage(@Field("username") String username,
                                             @Field("password") String password);

    /**
     * getPhoneCode
     */
    @POST(ApiUrls.AGREEMENT_PHONE)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> agreementPhone(@Field("username") String username,
                                                   @Field("password") String password);

    /**
     * 保洁端获取用户协议
     */
    @POST(ApiUrls.AGREEMENT)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> agreement(@Field("username") String username,
                                              @Field("password") String password);

    /**
     * 保洁端获取隐私条款
     */
    @POST(ApiUrls.PRIVACY)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> privacy(@Field("username") String username,
                                            @Field("password") String password);

    /**
     * 保洁端退出登录
     */
    @POST(ApiUrls.LOGOUT)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> logout(@Field("username") String username,
                                           @Field("password") String password);

    /**
     * 保洁端检查验证码
     */
    @POST(ApiUrls.UPDATE_CHECK_CODE)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> updateCheckCode(@Field("username") String username,
                                                    @Field("password") String password);

    /**
     * 保洁端修改密码
     */
    @POST(ApiUrls.UPDATE_PASSWORD)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> updatePassword(@Field("username") String username,
                                                   @Field("password") String password);

    //--------------------------------------------保洁端申请物料------------------------------------------------------

    /**
     * 领取物料申请单表
     */
    @POST(ApiUrls.COLLECT_ID)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> collectId(@Field("username") String username,
                                              @Field("password") String password);

    /**
     * 查询自己物料申请单
     */
    @POST(ApiUrls.GET_PAGE_LIST)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> getPageList(@Field("username") String username,
                                                @Field("password") String password);

    /**
     * 物料申请单表详情
     */
    @POST(ApiUrls.MATERIEL_APPLY_INFO_ID)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> materielApplyInfoId(@Field("username") String username,
                                                        @Field("password") String password);

    /**
     * 提交物料申请单
     */
    @POST(ApiUrls.SUBMIT_MATERIEL)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> submitMateriel(@Field("username") String username,
                                                   @Field("password") String password);

    //--------------------------------------------保洁端物料------------------------------------------------------

    /**
     * 拉取分类物料
     */
    @POST(ApiUrls.MATERIEL_LIST)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> materielList(@Field("username") String username,
                                                 @Field("password") String password);

    //--------------------------------------------保洁端任务------------------------------------------------------

    /**
     * 保洁员到达
     */
    @POST(ApiUrls.ARRIVE)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> arrive(@Field("username") String username,
                                           @Field("password") String password);

    /**
     * 确认开始-扫前准备上传照片
     */
    @POST(ApiUrls.BEFORE_CLEAN)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> beforeClean(@Field("username") String username,
                                                @Field("password") String password);

    /**
     * 确认完成
     */
    @POST(ApiUrls.CONFIRM_FINISH)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> confirmFinish(@Field("username") String username,
                                                  @Field("password") String password);

    /**
     * 出发-变成上门中
     */
    @POST(ApiUrls.TASK_GO)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> taskGo(@Field("username") String username,
                                           @Field("password") String password);

    /**
     * 任务列表
     */
    @POST(ApiUrls.TASK_LIST)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> taskList(@Field("username") String username,
                                             @Field("password") String password);

    /**
     * 接单接口
     */
    @POST(ApiUrls.TASK_RECEIVE)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> taskReceive(@Field("username") String username,
                                                @Field("password") String password);

    /**
     * 任务订单详情
     */
    @POST(ApiUrls.TASK_INFO_ID)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> taskInfoId(@Field("username") String username,
                                               @Field("password") String password);

    //--------------------------------------------保洁端个人中心------------------------------------------------------

    /**
     * 获取个人计划
     */
    @POST(ApiUrls.GET_CLEANER_PLAN)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> getCleanerPlan(@Field("username") String username,
                                                   @Field("password") String password);

    /**
     * 我的收益
     */
    @POST(ApiUrls.MY_INCOME)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> myIncome(@Field("username") String username,
                                             @Field("password") String password);

    /**
     * 个人信息
     */
    @POST(ApiUrls.USER_INFO)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> userInfo(@Field("username") String username,
                                             @Field("password") String password);

    //--------------------------------------------保洁端oss上传图片------------------------------------------------------

    /**
     * OSS文件上传
     */
    @POST(ApiUrls.OSS_UPLOAD)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> ossUpload(@Field("username") String username,
                                              @Field("password") String password);

    //--------------------------------------------保洁员端请假------------------------------------------------------

    /**
     * 请假申请
     */
    @POST(ApiUrls.LEAVE_APPLY)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> leaveApply(@Field("username") String username,
                                               @Field("password") String password);

    /**
     * 请假申请详情
     */
    @POST(ApiUrls.LEAVE_APPLY_DETAIL_ID)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> leaveApplyDetailId(@Field("username") String username,
                                                       @Field("password") String password);

    /**
     * 请假申请列表
     */
    @POST(ApiUrls.LEAVE_APPLY_LIST)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> leaveApplyList(@Field("username") String username,
                                                   @Field("password") String password);

    //--------------------------------------------保洁员端消息------------------------------------------------------

    /**
     * 消息详情
     */
    @POST(ApiUrls.MESSAGE_DETAIL_ID)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> messageDetailId(@Field("username") String username,
                                                    @Field("password") String password);

    /**
     * 消息列表
     */
    @POST(ApiUrls.MESSAGE_LIST)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> messageList(@Field("username") String username,
                                                @Field("password") String password);

    /**
     * 修改为已读
     */
    @POST(ApiUrls.MESSAGE_READ_ID)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> messageReadId(@Field("username") String username,
                                                  @Field("password") String password);

}
