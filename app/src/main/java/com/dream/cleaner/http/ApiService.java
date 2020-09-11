package com.dream.cleaner.http;

import com.dream.cleaner.beans.PlanBean;
import com.dream.cleaner.beans.login.AgreementBean;
import com.dream.cleaner.beans.login.LoginBean;
import com.dream.cleaner.beans.my.MyIncomeBean;
import com.dream.cleaner.beans.workorder.TaskDetailsBean;
import com.dream.cleaner.beans.workorder.WorkOrderTabBean;
import com.dream.common.base.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author : Liyalei
 * date   : 2020/8/16
 * desc   :
 */
public interface ApiService {


    /**
     * 保洁端登录
     * <p>
     */

    @POST(ApiUrls.LOGIN)
    Observable<BaseBean<LoginBean>> userLogin(@Body RequestBody body);

    /**
     * 保洁端获取验证码
     */
    @POST(ApiUrls.GET_IMAGE)
    Observable<BaseBean<LoginBean>> getImage(@Body RequestBody body);

    /**
     * getPhoneCode
     */
    @POST(ApiUrls.GET_PHONE_CODE)
    Observable<BaseBean<AgreementBean>> agreementPhone(@Body RequestBody body);

    /**
     * 保洁端获取用户协议
     */
    @GET(ApiUrls.AGREEMENT)
    Observable<BaseBean<AgreementBean>> agreement();

    /**
     * 保洁端获取隐私条款
     */
    @GET(ApiUrls.PRIVACY)
    Observable<BaseBean<AgreementBean>> privacy();

    /**
     * 保洁端退出登录
     */
    @POST(ApiUrls.LOGOUT)
    Observable<BaseBean<String>> logout();

    /**
     * 保洁端检查验证码
     */
    @POST(ApiUrls.CHECK_PHONE_CODE)
    Observable<BaseBean<String>> CheckPhoneCode(@Body RequestBody body);

    /**
     * 保洁端检查图形验证码
     */
    @POST(ApiUrls.CHECK_IMG_CODE)
    Observable<BaseBean<String>> checkImgCode(@Body RequestBody body);

    /**
     * 保洁端修改密码
     */
    @POST(ApiUrls.UPDATE_PASSWORD)
    Observable<BaseBean<LoginBean>> updatePassword(@Body RequestBody body);

    //--------------------------------------------保洁端申请物料------------------------------------------------------

    /**
     * 领取物料申请单表
     */
    @POST(ApiUrls.COLLECT_ID)
    Observable<BaseBean<LoginBean>> collectId(@Body RequestBody body);

    /**
     * 查询自己物料申请单
     */
    @POST(ApiUrls.GET_PAGE_LIST)
    Observable<BaseBean<LoginBean>> getPageList(@Body RequestBody body);

    /**
     * 物料申请单表详情
     */
    @POST(ApiUrls.MATERIEL_APPLY_INFO_ID)
    Observable<BaseBean<LoginBean>> materielApplyInfoId(@Body RequestBody body);

    /**
     * 提交物料申请单
     */
    @POST(ApiUrls.SUBMIT_MATERIEL)
    Observable<BaseBean<LoginBean>> submitMateriel(@Body RequestBody body);

    //--------------------------------------------保洁端物料------------------------------------------------------

    /**
     * 拉取分类物料
     */
    @POST(ApiUrls.MATERIEL_LIST)
    Observable<BaseBean<LoginBean>> materielList(@Body RequestBody body);

    //--------------------------------------------保洁端任务------------------------------------------------------

    /**
     * 保洁员到达
     */
    @POST(ApiUrls.ARRIVE)
    Observable<BaseBean<LoginBean>> arrive(@Body RequestBody body);

    /**
     * 确认开始-扫前准备上传照片
     */
    @POST(ApiUrls.BEFORE_CLEAN)
    Observable<BaseBean<LoginBean>> beforeClean(@Body RequestBody body);

    /**
     * 确认完成
     */
    @POST(ApiUrls.CONFIRM_FINISH)
    Observable<BaseBean<LoginBean>> confirmFinish(@Body RequestBody body);

    /**
     * 出发-变成上门中
     */
    @POST(ApiUrls.TASK_GO)
    Observable<BaseBean<LoginBean>> taskGo(@Body RequestBody body);

    /**
     * 任务列表
     */
    @POST(ApiUrls.TASK_LIST)
    Observable<BaseBean<WorkOrderTabBean>> taskList(@Body RequestBody body);

    /**
     * 接单接口
     */
    @POST(ApiUrls.TASK_RECEIVE)
    Observable<BaseBean<LoginBean>> taskReceive(@Body RequestBody body);

    /**
     * 任务订单详情
     */
    @POST(ApiUrls.TASK_INFO_ID)
    Observable<BaseBean<TaskDetailsBean>> taskInfoId(@Path("id") String id);

    //--------------------------------------------保洁端个人中心------------------------------------------------------

    /**
     * 获取个人计划 月
     */
    @POST(ApiUrls.GET_CLEANER_PLAN_MONTH)
    Observable<BaseBean<List<PlanBean>>> getCleanerPlanMonth(@Body RequestBody body);

    /**
     * 获取个人计划 天
     */
    @POST(ApiUrls.GET_CLEANER_PLAN_DAY)
    Observable<BaseBean<List<PlanBean.CleanerPlanItemsBean>>> getCleanerPlanDay(@Body RequestBody body);

    /**
     * 我的收益
     */
    @POST(ApiUrls.MY_INCOME)
    Observable<BaseBean<MyIncomeBean>> myIncome();

    /**
     * 个人信息
     */
    @POST(ApiUrls.USER_INFO)
    Observable<BaseBean<LoginBean.CleanerBean>> userInfo(@Path("id") String id);

    //--------------------------------------------保洁端oss上传图片------------------------------------------------------

    /**
     * OSS文件上传
     */
    @POST(ApiUrls.OSS_UPLOAD)
    Observable<BaseBean<LoginBean>> ossUpload(@Body RequestBody body);

    //--------------------------------------------保洁员端请假------------------------------------------------------

    /**
     * 请假申请
     */
    @POST(ApiUrls.LEAVE_APPLY)
    Observable<BaseBean<LoginBean>> leaveApply(@Body RequestBody body);

    /**
     * 请假申请详情
     */
    @POST(ApiUrls.LEAVE_APPLY_DETAIL_ID)
    Observable<BaseBean<LoginBean>> leaveApplyDetailId(@Body RequestBody body);

    /**
     * 请假申请列表
     */
    @POST(ApiUrls.LEAVE_APPLY_LIST)
    Observable<BaseBean<LoginBean>> leaveApplyList(@Body RequestBody body);

    //--------------------------------------------保洁员端消息------------------------------------------------------

    /**
     * 消息详情
     */
    @POST(ApiUrls.MESSAGE_DETAIL_ID)
    Observable<BaseBean<LoginBean>> messageDetailId(@Body RequestBody body);

    /**
     * 消息列表
     */
    @POST(ApiUrls.MESSAGE_LIST)
    Observable<BaseBean<LoginBean>> messageList(@Body RequestBody body);

    /**
     * 修改为已读
     */
    @POST(ApiUrls.MESSAGE_READ_ID)
    Observable<BaseBean<LoginBean>> messageReadId(@Body RequestBody body);

}
