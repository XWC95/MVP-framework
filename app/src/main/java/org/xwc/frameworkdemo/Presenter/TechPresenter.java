package org.xwc.frameworkdemo.Presenter;

import org.xwc.frameworkdemo.App.Constants;
import org.xwc.frameworkdemo.Base.RxPresenter;
import org.xwc.frameworkdemo.Model.bean.GankItemBean;
import org.xwc.frameworkdemo.Model.http.GankHttpResponse;
import org.xwc.frameworkdemo.Model.http.RetrofitHelper;
import org.xwc.frameworkdemo.Presenter.contract.TechContract;

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

        Flowable<GankHttpResponse<List<GankItemBean>>> flowable = mRetrofitHelper.fetchTechList(tech, Constants.NUM_OF_PAGE, mCurrentPager);

        ResourceSubscriber subscriber = new ResourceSubscriber<GankHttpResponse<List<GankItemBean>>>() {

            @Override
            public void onNext(GankHttpResponse<List<GankItemBean>> data) {
                if(getView()!=null)
                    getView().showContent(data.getResults());
            }

            @Override
            public void onError(Throwable t) {
                if(getView()!=null)
                    getView().showError("数据加载失败");
            }

            @Override
            public void onComplete() {

            }
        };
        addSubscription(mRetrofitHelper.startObservable(flowable,subscriber));
    }
}
