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
import org.xwc.frameworkdemo.UI.util.IBaseShowItemList;
import org.xwc.frameworkdemo.UI.util.ListFactory;
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

    private IBaseShowItemList<GankItemBean> baseShowItemList;
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
    public void showContent(List<GankItemBean> mList,boolean isRefresh) {
        baseShowItemList = new ListFactory<GankItemBean>().createShowItemList(mAdapter, mRefreshLayout);
        baseShowItemList.showData(isRefresh, mList);

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
