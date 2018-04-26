package org.xwc.frameworkdemo.Model.http;


import org.xwc.frameworkdemo.Model.bean.WxItemBean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xuwc on 2016/11/24.
 */
public interface WxApis {


    String HOST = "http://api.tianapi.com/";

    /**
     * 技术文章列表
     */
    @GET("wxnew")
    Flowable<WxHttpResponse<List<WxItemBean>>> getWXHot(@Query("key") String key,@Query("num") int num, @Query("page") int page);

}
