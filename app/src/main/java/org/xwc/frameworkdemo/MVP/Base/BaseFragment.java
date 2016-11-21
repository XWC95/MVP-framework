package org.xwc.frameworkdemo.MVP.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by xuwc on 2016/11/21.
 */
public abstract class BaseFragment extends Fragment {

    public Context mContext;
    private View mRootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = initView(inflater,container);
        mContext = getActivity();
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    protected abstract View initView(LayoutInflater inflater,ViewGroup container);

}
