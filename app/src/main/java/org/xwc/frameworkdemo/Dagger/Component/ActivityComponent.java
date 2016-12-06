package org.xwc.frameworkdemo.Dagger.Component;

import android.app.Activity;

import org.xwc.frameworkdemo.Dagger.ActivityScope;
import org.xwc.frameworkdemo.Dagger.Modul.ActivityModule;

import dagger.Component;

/**
 * Created by xuwc on 2016/11/24.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

}
