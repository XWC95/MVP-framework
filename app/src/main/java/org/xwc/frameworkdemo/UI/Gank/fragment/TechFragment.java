package org.xwc.frameworkdemo.UI.Gank.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.orhanobut.logger.Logger;

import org.xwc.frameworkdemo.App.Constants;
import org.xwc.frameworkdemo.Base.BaseFragment;
import org.xwc.frameworkdemo.Base.BaseRecyclerAdapter;
import org.xwc.frameworkdemo.Model.bean.GankItemBean;
import org.xwc.frameworkdemo.Presenter.TechPresenter;
import org.xwc.frameworkdemo.Presenter.contract.TechContract;
import org.xwc.frameworkdemo.R;
import org.xwc.frameworkdemo.UI.Gank.adapter.TechAdapter;
import org.xwc.frameworkdemo.Widget.RecyclerRefreshLayout;

import java.util.List;

import butterknife.BindView;

/**
 * Created by xuwc on 2016/11/30.
 */
public class TechFragment extends BaseFragment<TechPresenter>  implements  TechContract.View, RecyclerRefreshLayout.SuperRefreshLayoutListener {


    private String tech;
    private TechAdapter mAdapter;

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
        return R.layout.fragment_tech;
    }

    @Override
    protected void initView() {
        tech = getArguments().getString(Constants.KEY_BUNDLE_TECH_FRAGMENT);
        mAdapter = new TechAdapter(mContext);
        mAdapter.setState(BaseRecyclerAdapter.STATE_HIDE, false);
        mRefreshLayout.setSuperRefreshLayoutListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
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
        Logger.d(msg);
    }

    @Override
    public void showContent(List<GankItemBean> mList) {
        if (mRefreshLayout.isRefreshing()) {
            //cache the time
            mAdapter.clear();
            mAdapter.addAll(mList);
            mRefreshLayout.setRefreshing(false);
        } else {
            mAdapter.addAll(mList);
            mRefreshLayout.setOnLoading(false);  //设置可加加载
        }
        if (mList == null || mList.size() < 20) {
            mAdapter.setState(BaseRecyclerAdapter.STATE_NO_MORE, true);
            mRefreshLayout.setOnLoading(true);  //设置不可加更多
        }else{
            mAdapter.setState(BaseRecyclerAdapter.STATE_LOAD_MORE, true);
        }
    }

    @Override
    public void onRefreshing() {
        mPresenter.getGankData(tech,true);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getGankData(tech,false);
    }
}
