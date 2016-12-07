package org.xwc.frameworkdemo.Dagger.Component;

import android.app.Activity;

import org.xwc.frameworkdemo.Dagger.FragmentScope;
import org.xwc.frameworkdemo.Dagger.Modul.FragmentModule;
import org.xwc.frameworkdemo.UI.Gank.fragment.GirlFragment;
import org.xwc.frameworkdemo.UI.Gank.fragment.TechFragment;
import org.xwc.frameworkdemo.UI.Home.fragment.AFragment;

import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();


    void inject(AFragment fragment);

    void inject(TechFragment fragment);

    void inject(GirlFragment fragment);
}