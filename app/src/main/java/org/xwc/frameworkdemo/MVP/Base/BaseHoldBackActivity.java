package org.xwc.frameworkdemo.MVP.Base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.xwc.frameworkdemo.R;

import butterknife.BindView;

/**
 * 带放回按钮的avtivity
 * Created by xuwc on 2016/11/21.
 */
public abstract class BaseHoldBackActivity extends  BaseActivity{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.title)
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar.setTitle("");
        mTitle.setText(onSetTitle());
        mToolbar.setSubtitleTextColor(getResources().getColor(R.color.white));
        mToolbar.setNavigationIcon(R.mipmap.icon_back);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }



    protected   String onSetTitle(){
        return getString(R.string.app_name);
    }
}
