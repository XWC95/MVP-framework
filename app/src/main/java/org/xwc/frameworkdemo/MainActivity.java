package org.xwc.frameworkdemo;

import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.xwc.frameworkdemo.MVP.Base.BaseHoldBackActivity;
import org.xwc.frameworkdemo.MVP.Entity.MainTabs;
import org.xwc.frameworkdemo.Widget.FragmentTabHost;

import butterknife.BindView;

public class MainActivity extends BaseHoldBackActivity {


    @BindView(R.id.fl_tab_content)
    FrameLayout mFlTabContent;
    @BindView(R.id.tabhost)
    FragmentTabHost mTabHost;

    private long mBackPressedTime;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        mTabHost.setup(this, getSupportFragmentManager(), R.id.fl_tab_content);
        //去除tab分割线
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
            mTabHost.getTabWidget().setShowDividers(0);
        }
        MainTabs[] mainTabs = MainTabs.values();
        MainTabs tab = null;
        for (int i = 0; i < mainTabs.length; i++) {
            tab = mainTabs[i];
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getResName()));
            View indicator = getTabItemView(i, tab);
            tabSpec.setIndicator(indicator);
            mTabHost.addTab(tabSpec, tab.getClz(), null);

        }
    }

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index, MainTabs tab) {
        View view = getLayoutInflater().inflate(R.layout.view_tab_item, null);
        TextView title = (TextView) view.findViewById(R.id.iv_tab_title);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        title.setText(getString(tab.getResName()));
        img.setBackgroundResource(tab.getResIcon());
        return view;
    }

    @Override
    public void onClick(View view) {

    }


    @Override
    public void onBackPressed() {
        if (true) {
            long curTime = SystemClock.uptimeMillis();
            if ((curTime - mBackPressedTime) < (3 * 1000)) {
                finish();
            } else {
                mBackPressedTime = curTime;
                Toast.makeText(this, "再点一下", Toast.LENGTH_LONG).show();
            }
        } else {
            AppManager.getAppManager().AppExit();
        }
    }

}
