package org.xwc.frameworkdemo.Presenter.contract;

import org.xwc.frameworkdemo.Base.BasePresenter;
import org.xwc.frameworkdemo.Base.BaseView;
import org.xwc.frameworkdemo.Model.bean.GankItemBean;

import java.util.List;

/**
 * Created by xuwc on 2016/11/30.
 */
public interface TechContract {

    interface View extends BaseView {

        void showContent(List<GankItemBean> mList,boolean isRefresh);

    }

    interface Presenter extends BasePresenter<View> {

        void getGankData(String tech,boolean isRefresh);

    }
}
