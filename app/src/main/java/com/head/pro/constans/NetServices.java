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

/**
 * Created by Jie on 2017/4/8.
 */

public class NetServices<T> {
    private static Retrofit retrofit;
    public final static String URL_HEAD = "http://api.client.zjyiwei.com/";


//   static HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//        @Override
//        public void log(String message) {
////这里打印拦截日志
//            StringReader reader = new StringReader(message);//字符串转换
//            Properties properties = new Properties();
//            try {
//                properties.load(reader);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            properties.list(System.out);
//            Log.i("TAG","输出日志");
//        }
//    }).setLevel(HttpLoggingInterceptor.Level.BODY);


  static   Interceptor interceptor=new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
           // builder.addHeader("","");//添加请求头
            return chain.proceed(builder.build());
        }
    };

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            //.addInterceptor(logInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();

    public static <T> T init(Class<T> service) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(URL_HEAD)
                    .client(httpClient)
                     .addConverterFactory(GsonConverterFactory.create())
                   // .addConverterFactory(JacksonConverterFactory.create())
                    // .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(service);
    }

}
