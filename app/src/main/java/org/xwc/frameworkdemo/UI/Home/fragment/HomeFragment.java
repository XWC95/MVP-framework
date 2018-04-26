package org.xwc.frameworkdemo.UI.Home.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.orhanobut.logger.Logger;

import org.xwc.frameworkdemo.Base.BaseFragment;
import org.xwc.frameworkdemo.Base.BaseRecyclerAdapter;
import org.xwc.frameworkdemo.Model.bean.GankItemBean;
import org.xwc.frameworkdemo.Model.bean.WxItemBean;
import org.xwc.frameworkdemo.Presenter.Apresenter;
import org.xwc.frameworkdemo.Presenter.contract.AContract;
import org.xwc.frameworkdemo.R;
import org.xwc.frameworkdemo.UI.Gank.activity.GankMainActivity;
import org.xwc.frameworkdemo.UI.Home.adapter.Aadapter;
import org.xwc.frameworkdemo.UI.util.IBaseShowItemList;
import org.xwc.frameworkdemo.UI.util.ListFactory;
import org.xwc.frameworkdemo.Widget.RecyclerRefreshLayout;

import java.util.List;

import butterknife.BindView;

/**
 * Created by xuwc on 2016/12/7.
 * 最近修改时间 2018年4月18日16:49:24
 */
public class HomeFragment extends BaseFragment<Apresenter> implements AContract.View, RecyclerRefreshLayout.SuperRefreshLayoutListener, BaseRecyclerAdapter.OnItemClickListener {

    private IBaseShowItemList<WxItemBean> baseShowItemList;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    RecyclerRefreshLayout mRefreshLayout;
    private Aadapter mAdapter;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initView() {
        mAdapter = new Aadapter(mContext);
        mAdapter.setState(BaseRecyclerAdapter.STATE_HIDE, false);
        mRefreshLayout.setSuperRefreshLayoutListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {
        mRefreshLayout.post(() -> {
            mRefreshLayout.setRefreshing(true);
            onRefreshing();
        });
    }


    @Override
    public void showContent(List<WxItemBean> data,boolean isRefresh) {

        baseShowItemList = new ListFactory<WxItemBean>().createShowItemList(mAdapter, mRefreshLayout);
        baseShowItemList.showData(isRefresh, data);
    }

    @Override
    public void showError(String msg) {
        Logger.d(msg);
    }

    @Override
    public void onItemClick(int position, long itemId) {
        startActivity(new Intent(mContext, GankMainActivity.class));
    }


    @Override
    public void onRefreshing() {
        mPresenter.getGankData(true);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getGankData(false);
    }


}

