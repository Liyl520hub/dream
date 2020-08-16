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
     * 用户登录
     */
    @POST(ApiUrls.LOGIN)
    @FormUrlEncoded
    Observable<BaseBean<LoginBean>> userLogin(@Field("username") String username,
                                              @Field("password") String password);

}
