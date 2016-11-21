package org.xwc.frameworkdemo.MVP.Entity;

/**
 * Created by xuwc on 2016/11/21.
 */
public class HttpResult<T> {
    public String requestTime;
    public int code;
    public T data;

    public HttpResult(String requestTime, int code, T data) {
        this.requestTime = requestTime;
        this.code = code;
        this.data = data;
    }

}
