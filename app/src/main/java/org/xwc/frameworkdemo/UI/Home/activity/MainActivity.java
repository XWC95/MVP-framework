package org.xwc.frameworkdemo.UI.Home.activity;

import android.support.v7.widget.Toolbar;

import org.xwc.frameworkdemo.Base.SimpleActivity;
import org.xwc.frameworkdemo.R;
import org.xwc.frameworkdemo.UI.Home.fragment.Afragment;

import butterknife.BindView;

public class MainActivity extends SimpleActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    Afragment afragment;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolbar, "A");
        afragment = new Afragment();
        loadRootFragment(R.id.fl_main_content, afragment);
    }


}
