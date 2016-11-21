package org.xwc.frameworkdemo.MVP.Base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.xwc.frameworkdemo.AppManager;

import butterknife.ButterKnife;

/**
 * Created by xuwc on 2016/11/21.
 */
public abstract class BaseActivity  extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 锁定竖屏
        AppManager.getAppManager().addActivity(this);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }

        ButterKnife.bind(this);

        init(savedInstanceState);

        initView();
    }

    protected void   initView(){}

    protected   void init(Bundle savedInstanceState){}


    protected int getLayoutId() {
        return 0;
    }
}
