package org.xwc.frameworkdemo.UI.Home.activity;

import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;

import org.xwc.frameworkdemo.App.Constants;
import org.xwc.frameworkdemo.Base.SimpleActivity;
import org.xwc.frameworkdemo.R;
import org.xwc.frameworkdemo.UI.Home.fragment.AFragment;
import org.xwc.frameworkdemo.UI.Home.fragment.BFragment;
import org.xwc.frameworkdemo.UI.Home.fragment.CFragment;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends SimpleActivity implements RadioGroup.OnCheckedChangeListener {


    private AFragment mAFragment;
    private BFragment mBFragment;
    private CFragment mCFragment;

    private int hideFragment = Constants.TYPE_A;
    private int showFragment = Constants.TYPE_A;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.home_radio)
    RadioGroup mHomeRadio;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolbar, "A");
        mAFragment = new AFragment();
        mBFragment = new BFragment();
        mCFragment = new CFragment();

        loadMultipleRootFragment(R.id.fl_main_content, 0, mAFragment, mBFragment, mCFragment);
        mHomeRadio.setOnCheckedChangeListener(this);
        showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
    }




    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_1:
                showFragment = Constants.TYPE_A;
                break;
            case R.id.rb_2:
                showFragment = Constants.TYPE_B;
                break;
            case R.id.rb_3:
                showFragment = Constants.TYPE_C;
                break;
        }
        showHideFragment(getTargetFragment(showFragment), getTargetFragment(hideFragment));
        hideFragment = showFragment;
    }


    private SupportFragment getTargetFragment(int item) {
        switch (item) {
            case Constants.TYPE_A:
                return mAFragment;
            case Constants.TYPE_B:
                return mBFragment;
            case Constants.TYPE_C:
                return mCFragment;
        }
        return mAFragment;
    }


}
