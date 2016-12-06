package org.xwc.frameworkdemo.Dagger.Modul;

import org.xwc.frameworkdemo.App.App;
import org.xwc.frameworkdemo.Dagger.ContextLife;
import org.xwc.frameworkdemo.Model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xuwc on 2016/11/24.
 */
@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper() {
        return new RetrofitHelper();
    }

}
