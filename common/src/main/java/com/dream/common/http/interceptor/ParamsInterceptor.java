package com.dream.common.http.interceptor;


import android.content.Context;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.SPUtils;
import java.io.IOException;


import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 封装公共参数（Key和密码）  目前只支持FormBody MultipartBody替换token参数 其余不在这处理
 * <p>
 *
 * @author Administrator
 * <p>
 */
public class ParamsInterceptor implements Interceptor {

    private static final String TAG = "request params";
    private Context context;

    public ParamsInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {

        Request orgRequest = chain.request();
        HttpUrl orgUrl = orgRequest.url();
        //环信校验不替换token
//        if (orgUrl.pathSegments().contains("userAuthentication") || orgUrl.pathSegments().contains("saveCustomer")) {
//            return chain.proceed(orgRequest);
//        }
        RequestBody body = orgRequest.body();
        //收集请求参数，方便调试
        StringBuilder paramsBuilder = new StringBuilder();
        if (body != null) {
            RequestBody newBody;
            if (body instanceof FormBody) {
                newBody = addParamsToFormBody((FormBody) body, paramsBuilder);
            } else if (body instanceof MultipartBody) {
                newBody = addParamsToMultipartBody((MultipartBody) body, paramsBuilder);
            } else {
                return chain.proceed(orgRequest);
            }
            Request newRequest = orgRequest.newBuilder()
                    .url(orgUrl)
                    .method(orgRequest.method(), newBody)
                    .build();

            return chain.proceed(newRequest);
        }

        return chain.proceed(orgRequest);
    }

    /**
     * 为MultipartBody类型请求体添加参数
     * <p>
     *
     * @param body          请求主体
     * @param paramsBuilder 参数builder
     * @return builder.build();
     * <p>
     * 替换代码中传的token
     */
    private MultipartBody addParamsToMultipartBody(MultipartBody body, StringBuilder paramsBuilder) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        String token = SPUtils.getInstance().getString("token");
        builder.addFormDataPart("token", token);
        paramsBuilder.append("token=").append(token);
        //添加原请求体
        for (int i = 0; i < body.size(); i++) {
            builder.addPart(body.part(i));
        }
        return builder.build();
    }


    /**
     * 为FormBody类型请求体添加参数
     * <p>
     *
     * @param body          请求主体
     * @param paramsBuilder 参数builder
     * @return builder.build();
     * <p>
     * 替换代码中传的token
     */

    private FormBody addParamsToFormBody(FormBody body, StringBuilder paramsBuilder) {
        FormBody.Builder builder = new FormBody.Builder();
        String token = SPUtils.getInstance().getString("token");
        builder.add("token", token);
        paramsBuilder.append("token=").append(token);
        //添加原请求体
        for (int i = 0; i < body.size(); i++) {
            if (!"token".equals(body.encodedName(i))) {
                builder.addEncoded(body.encodedName(i), body.encodedValue(i));
                paramsBuilder.append("&");
                paramsBuilder.append(body.name(i));
                paramsBuilder.append("=");
                paramsBuilder.append(body.value(i));
            }
        }
        return builder.build();
    }
}

