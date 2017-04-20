package com.head.pro.constans;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.head.pro.App;
import com.head.pro.util.NetWorkUtil;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Jie on 2017/2/16.
 */

public class ConnectNet {
    public static final String URL_HEAD = "http://www.pillar.lol:9090/";
    private static ConnectNet instance;
    private Retrofit retrofit;


    public ConnectNet() {
        //设置请求拦截（BODY 请求/响应行 + 头 + 体）
//        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
//        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //设置请求头
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                // builder.addHeader("","");//设置请求头
                return chain.proceed(builder.build());
            }
        };

        File cacheFile = new File(App.getAppContext().getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)//读取超时和连接超时的配置
                .connectTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
              //  .addInterceptor(logInterceptor)
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .cache(cache)
                .build();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(URL_HEAD)
                .client(okHttpClient)
               .addConverterFactory(JacksonConverterFactory.create())
               // .addConverterFactory(ScalarsConverterFactory.create())
                //.addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


/**
 * 内部类形式实现单例
 * */
//    private static class SingletonHolder {
//        private static final ConnectNet INSTANCE = new ConnectNet();
//    }
//    public static ConnectNet getInstance() {
//        return SingletonHolder.INSTANCE;
//    }

    public static ConnectNet getInstance() {
        if (instance == null) {
            synchronized (ConnectNet.class) {
                if (instance == null) {
                    instance = new ConnectNet();
                }
            }
        }
        return instance;
    }

    /**
     * 转换为对象的Service
     *
     * @param service
     * @param <T>
     * @return 传入的类型
     */
    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }

//网络拦截器
  public   class HttpCacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetWorkUtil.isNetConnected(App.getAppContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                Log.d("Okhttp", "no network");
            }
            Response originalResponse = chain.proceed(request);
            if (NetWorkUtil.isNetConnected(App.getAppContext())) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                        .removeHeader("Pragma")
                        .build();
            }
        }
    }


}
