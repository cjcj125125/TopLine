package com.head.pro.constans;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Jie on 2017/2/18.
 */

public class ConnectClient<T> {
    public static final String URL_HEAD = "http://api.client.zjyiwei.com/";
    private static Retrofit retrofit;
//配置网络层为okhttp
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request.Builder builder = chain.request().newBuilder();
                   // builder.addHeader("token", "abc");
                    return chain.proceed(builder.build());
                }
            }).connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();
/***
 * ddCallAdapterFactory，通过这个转换，
 * 才能将服务器的返回值从Retrofit默认的Call变为Observable
 * */
    static {
        retrofit = new Retrofit.Builder().baseUrl(URL_HEAD)
               // .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }



    public static <T> T getApiContent(Class<T>service) {
        return retrofit.create(service);
    }
}
