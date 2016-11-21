package org.xwc.frameworkdemo.MVP.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xwc.frameworkdemo.MVP.Base.BaseFragment;
import org.xwc.frameworkdemo.R;

/**
 * Created by xuwc on 2016/11/21.
 */
public class B extends BaseFragment{
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }
}
