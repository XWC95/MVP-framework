package org.xwc.frameworkdemo.Presenter;

import org.xwc.frameworkdemo.App.Constants;
import org.xwc.frameworkdemo.Base.RxPresenter;
import org.xwc.frameworkdemo.Model.bean.GankItemBean;
import org.xwc.frameworkdemo.Model.bean.WxItemBean;
import org.xwc.frameworkdemo.Model.http.GankHttpResponse;
import org.xwc.frameworkdemo.Model.http.RetrofitHelper;
import org.xwc.frameworkdemo.Presenter.contract.GirlContract;
import org.xwc.frameworkdemo.Utils.CommonSubscriber;
import org.xwc.frameworkdemo.Utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by xuwc on 2016/12/1.
 */
public class GirlPresenter extends RxPresenter<GirlContract.View> implements GirlContract.Presenter {

    private RetrofitHelper mRetrofitHelper;

    private int mCurrentPage = 1;


    @Inject
    public GirlPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getGirlData(boolean isRefreshing) {

        if (isRefreshing) {
            mCurrentPage = 1;
        } else mCurrentPage++;


        addSubscription(mRetrofitHelper.fetchGirlList(Constants.NUM_OF_PAGE, mCurrentPage)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleGankResult())
                .subscribeWith(new CommonSubscriber<List<GankItemBean>>(getView()) {
                    @Override
                    public void onNext(List<GankItemBean> data) {
                        getView().showContent(data, isRefreshing);
                    }
                }));

    }
}
