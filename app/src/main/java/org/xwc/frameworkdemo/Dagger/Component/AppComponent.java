package org.xwc.frameworkdemo.Dagger.Component;

import org.xwc.frameworkdemo.App.App;
import org.xwc.frameworkdemo.Dagger.ContextLife;
import org.xwc.frameworkdemo.Dagger.Modul.AppModule;
import org.xwc.frameworkdemo.Model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by xuwc on 2016/11/24.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("Application")
    App getContext();  // 提供App的Context

    RetrofitHelper retrofitHelper();  //提供http的帮助类


}
