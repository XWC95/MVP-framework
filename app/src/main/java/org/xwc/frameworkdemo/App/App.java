package org.xwc.frameworkdemo.App;

import android.app.Application;

import com.orhanobut.logger.Logger;

import org.xwc.frameworkdemo.Dagger.Component.AppComponent;
import org.xwc.frameworkdemo.Dagger.Component.DaggerAppComponent;
import org.xwc.frameworkdemo.Dagger.Modul.AppModule;

/**
 * 全局应用程序类
 * Created by xuwc on 2016/11/21.
 */
public class App extends Application{
    private static App instance;



    public static synchronized App getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //初始化日志
        Logger.init(getPackageName()).hideThreadInfo();

    }



    public static AppComponent getAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }
}
