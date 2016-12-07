package org.xwc.frameworkdemo.UI.Home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xwc.frameworkdemo.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by xuwc on 2016/12/7.
 */
public class BFragment extends SupportFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_refresh_recycleview,null);
    }
}
