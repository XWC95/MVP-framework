package org.xwc.frameworkdemo.Presenter;

import org.xwc.frameworkdemo.App.Constants;
import org.xwc.frameworkdemo.Base.RxPresenter;
import org.xwc.frameworkdemo.Model.bean.WxItemBean;
import org.xwc.frameworkdemo.Model.http.RetrofitHelper;
import org.xwc.frameworkdemo.Model.http.WxHttpResponse;
import org.xwc.frameworkdemo.Presenter.contract.AContract;
import org.xwc.frameworkdemo.Utils.CommonSubscriber;
import org.xwc.frameworkdemo.Utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by xuwc on 2016/11/24.
 */
public class Apresenter extends RxPresenter<AContract.View> implements AContract.Presenter {

    private int mCurrentPage = 1;

    private RetrofitHelper mRetrofitHelper;


    @Inject
    public Apresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }


    @Override
    public void getGankData(Boolean isRefresh) {
        if (isRefresh) {
            mCurrentPage = 1;
        } else {
            mCurrentPage++;
        }


        addSubscription(mRetrofitHelper.fetchWxList(Constants.NUM_OF_PAGE, mCurrentPage)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleWxResult())
                .subscribeWith(new CommonSubscriber<List<WxItemBean>>(getView()) {
                    @Override
                    public void onNext(List<WxItemBean> wxItemBeans) {
                        getView().showContent(wxItemBeans, isRefresh);
                    }
                }));
    }
}
