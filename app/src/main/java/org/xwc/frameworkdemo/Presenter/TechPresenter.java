package org.xwc.frameworkdemo.Presenter;

import org.xwc.frameworkdemo.App.Constants;
import org.xwc.frameworkdemo.Base.RxPresenter;
import org.xwc.frameworkdemo.Model.bean.GankItemBean;
import org.xwc.frameworkdemo.Model.http.GankHttpResponse;
import org.xwc.frameworkdemo.Model.http.RetrofitHelper;
import org.xwc.frameworkdemo.Presenter.contract.TechContract;
import org.xwc.frameworkdemo.Utils.CommonSubscriber;
import org.xwc.frameworkdemo.Utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by xuwc on 2016/11/30.
 */
public class TechPresenter extends RxPresenter<TechContract.View> implements TechContract.Presenter {


    private RetrofitHelper mRetrofitHelper;

    private int mCurrentPager = 1;

    @Inject
    public TechPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }


    @Override
    public void getGankData(String tech, boolean isRefresh) {
        if (isRefresh) {
            mCurrentPager = 1;
        } else {
            mCurrentPager++;
        }
        addSubscription(mRetrofitHelper.fetchTechList(tech, Constants.NUM_OF_PAGE, mCurrentPager)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleGankResult())
                .subscribeWith(new CommonSubscriber<List<GankItemBean>>(getView()) {
                    @Override
                    public void onNext(List<GankItemBean> data) {
                        getView().showContent(data, isRefresh);
                    }
                }));

    }
}
