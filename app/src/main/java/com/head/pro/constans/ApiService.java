package com.head.pro.constans;


import com.head.pro.entity.Advertisement;
import com.head.pro.entity.BaseEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Jie on 2017/2/16.
 */

public interface ApiService {
/***
    @GET(value = "category/list/%7BparentId%7D")
  Observable<BaseEntity<String>> getCategoryList(@Query("parentId") int parentId);
    @GET(value = "item/recommended")
   Observable<BaseEntity<List<RecommBean>>> getCategoryList();
    /***
     * 查询所有分类
     * /***
     *在直接使用Retrofit，不使用RxJava时，我们的返回值都是Call
     *
   @GET(value = "category/list/%7BparentId%7D")
     Call<Object> getAllList(@Query("parentId") int parentId);
****/

/**
 * 广告列表
 * **/
@GET(value = "adverties")
Observable<BaseEntity<List<Advertisement>>> getAdvertisement();


}
