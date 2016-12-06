package org.xwc.frameworkdemo.Presenter;

import org.xwc.frameworkdemo.App.Constants;
import org.xwc.frameworkdemo.Base.RxPresenter;
import org.xwc.frameworkdemo.Model.bean.GankItemBean;
import org.xwc.frameworkdemo.Model.http.GankHttpResponse;
import org.xwc.frameworkdemo.Model.http.RetrofitHelper;
import org.xwc.frameworkdemo.Presenter.contract.GirlContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by xuwc on 2016/12/1.
 */
public class GirlPresenter extends RxPresenter<GirlContract.View> implements GirlContract.Presenter{

    private RetrofitHelper mRetrofitHelper;

    private int mCurrentPage = 1;


    @Inject
    public GirlPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public void getGirlData(boolean isRefreshing) {

        if(isRefreshing){
            mCurrentPage = 1;
        }else mCurrentPage++;
        Flowable<GankHttpResponse<List<GankItemBean>>> flowable = mRetrofitHelper.fetchGirlList(Constants.NUM_OF_PAGE, mCurrentPage);
        mRetrofitHelper.startObservable(flowable, new ResourceSubscriber<GankHttpResponse<List<GankItemBean>>>() {

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
        });


    }
}
