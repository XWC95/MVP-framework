package org.xwc.frameworkdemo.UI.Gank.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import org.xwc.frameworkdemo.App.Constants;
import org.xwc.frameworkdemo.Base.SimpleActivity;
import org.xwc.frameworkdemo.Base.ViewPagerAdapterFragment;
import org.xwc.frameworkdemo.R;
import org.xwc.frameworkdemo.UI.Gank.fragment.GirlFragment;
import org.xwc.frameworkdemo.UI.Gank.fragment.TechFragment;

import butterknife.BindView;

public class GankMainActivity extends SimpleActivity {


    private ViewPagerAdapterFragment mAdapter;
    String[] tabTitle = new String[]{"Android", "福利"};
    String[] tabTag = new String[]{"wo", "cao"};


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    @Override
    protected int getLayout() {
        return R.layout.activity_zhihu_main;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolbar, "知乎");

        mAdapter = new ViewPagerAdapterFragment(getSupportFragmentManager(), this);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_BUNDLE_TECH_FRAGMENT, "Android");
        mAdapter.addTab(tabTitle[0], tabTag[0], TechFragment.class, bundle);
        mAdapter.addTab(tabTitle[1],tabTag[1],GirlFragment.class,null);
        mViewpager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(mViewpager);

    }

}
