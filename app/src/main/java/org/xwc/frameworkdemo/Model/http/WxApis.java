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


    String HOST = "http://apis.baidu.com/txapi/weixin/";

    /**
     * 技术文章列表
     */
    @GET("wxhot")
    Flowable<WxHttpResponse<List<WxItemBean>>> getWXHot(@Query("num") int num, @Query("page") int page);

}
