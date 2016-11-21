package org.xwc.frameworkdemo;

import android.app.Application;

import org.xwc.frameworkdemo.Uitls.TLog;

/**
 * 全局应用程序类
 * Created by xuwc on 2016/11/21.
 */
public class AppContext extends Application{
    private static AppContext instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        TLog.DEBUG = BuildConfig.DEBUG;
    }

    /**
     * 获得当前app运行的AppContext
     *
     * @return
     */
    public static AppContext getInstance() {
        return instance;
    }
}
