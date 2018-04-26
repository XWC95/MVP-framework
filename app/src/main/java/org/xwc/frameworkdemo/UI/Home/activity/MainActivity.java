package org.xwc.frameworkdemo.UI.Home.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import org.xwc.frameworkdemo.Base.SimpleActivity;
import org.xwc.frameworkdemo.R;
import org.xwc.frameworkdemo.UI.Home.fragment.HomeFragment;
import org.xwc.frameworkdemo.UI.Home.fragment.BFragment;
import org.xwc.frameworkdemo.UI.Home.fragment.MeFragment;

import butterknife.BindView;

public class MainActivity extends SimpleActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    private HomeFragment mHomeFragment;
    private BFragment mBFragment;
    private MeFragment mMeFragment;


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolbar, "微信精选");
        mHomeFragment = new HomeFragment();
        mBFragment = new BFragment();
        mMeFragment = new MeFragment();

        loadMultipleRootFragment(R.id.fl_main_content, 0, mHomeFragment, mBFragment, mMeFragment);

        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setItemIconTintList(null);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                showHideFragment(mHomeFragment);
                break;
        }
        return true;
    }
}
