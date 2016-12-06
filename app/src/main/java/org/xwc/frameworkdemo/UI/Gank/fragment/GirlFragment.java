package org.xwc.frameworkdemo.UI.Gank.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.xwc.frameworkdemo.Base.BaseFragment;
import org.xwc.frameworkdemo.Base.BaseRecyclerAdapter;
import org.xwc.frameworkdemo.Model.bean.GankItemBean;
import org.xwc.frameworkdemo.Presenter.GirlPresenter;
import org.xwc.frameworkdemo.Presenter.contract.GirlContract;
import org.xwc.frameworkdemo.R;
import org.xwc.frameworkdemo.UI.Gank.adapter.GirlAdapter;
import org.xwc.frameworkdemo.Utils.LogUtil;
import org.xwc.frameworkdemo.Widget.RecyclerRefreshLayout;

import java.util.List;

import butterknife.BindView;

/**
 * Created by xuwc on 2016/11/30.
 */
public class GirlFragment extends BaseFragment<GirlPresenter> implements GirlContract.View, RecyclerRefreshLayout.SuperRefreshLayoutListener, BaseRecyclerAdapter.OnItemClickListener {


    private GirlAdapter mAdapter;


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh)
    RecyclerRefreshLayout mRefreshLayout;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_refresh_recycleview;
    }

    @Override
    protected void initView() {
        mRefreshLayout.setSuperRefreshLayoutListener(this);
        GridLayoutManager layoutManager = new GridLayoutManager(mActivity,2);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new GirlAdapter(mActivity, Glide.with(this));
        mRecyclerView.setAdapter(mAdapter);
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
    public void showError(String msg) {
        LogUtil.d(msg);
    }

    @Override
    public void showContent(List<GankItemBean> list) {
        if (mRefreshLayout.isRefreshing()) {
            //cache the time
            mAdapter.clear();
            mAdapter.addAll(list);
            mRefreshLayout.setRefreshing(false);
        } else {
            mAdapter.addAll(list);
            mRefreshLayout.setOnLoading(false);  //设置可加加载
        }
        if (list == null || list.size() < 20) {
            mAdapter.setState(BaseRecyclerAdapter.STATE_NO_MORE, true);
            mRefreshLayout.setOnLoading(true);  //设置不可加更多
        }else{
            mAdapter.setState(BaseRecyclerAdapter.STATE_LOAD_MORE, true);
        }
    }
    @Override
    public void onItemClick(int position, long itemId) {
        Toast.makeText(mActivity, "点", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRefreshing() {
        mPresenter.getGirlData(true);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getGirlData(false);
    }


}
