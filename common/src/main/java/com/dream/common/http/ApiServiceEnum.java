package com.dream.common.http;



import com.blankj.utilcode.util.Utils;
import com.dream.common.BuildConfig;
import com.dream.common.http.interceptor.HeaderInterceptor;
import com.dream.common.http.interceptor.RewriteCacheControlInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author lyl
 * <p>
 * created 2018/9/15
 * <p>
 * class use:
 */
public enum ApiServiceEnum {

    /**
     * 域名单例
     */
    HOST_SERVER;
    /**
     * 主体retrofit
     */
    public static final int TYPE_HEADER = 1;

    private Retrofit retrofitService = null;


    ApiServiceEnum() {
        try {
            retrofitService = getRetrofit(TYPE_HEADER);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Retrofit getRetrofitService() {
        return retrofitService;
    }


    private Retrofit getRetrofit(int headerType) {
        //Log拦截器
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        //网络缓存文件夹
        File cacheFile = new File(Utils.getApp().getApplicationContext().getCacheDir(), "cleaner_cache");
        //100Mb;
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);

        RewriteCacheControlInterceptor cacheInterceptor = new RewriteCacheControlInterceptor();

        OkHttpClient.Builder mOkHttpClientBuild = new OkHttpClient.Builder()
                .readTimeout(30000, TimeUnit.MILLISECONDS)
                .connectTimeout(30000, TimeUnit.MILLISECONDS)
                .addInterceptor(cacheInterceptor)
                .addNetworkInterceptor(cacheInterceptor)
                .addInterceptor(new HeaderInterceptor(headerType))
                .addInterceptor(logInterceptor)
                .cache(cache);
        if (!BuildConfig.IS_DEBUG) {
            mOkHttpClientBuild.proxy(Proxy.NO_PROXY);
        }
        OkHttpClient mOkHttpClient = mOkHttpClientBuild.build();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();
        String url = "";
        switch (headerType) {
            case TYPE_HEADER: {
                url = BuildConfig.HOST_SERVER;
            }

            break;
            default:
                url = BuildConfig.HOST_SERVER;

        }
        return new Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();

    }
}