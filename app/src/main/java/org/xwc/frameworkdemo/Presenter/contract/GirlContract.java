package org.xwc.frameworkdemo.Presenter.contract;

import org.xwc.frameworkdemo.Base.BasePresenter;
import org.xwc.frameworkdemo.Base.BaseView;
import org.xwc.frameworkdemo.Model.bean.GankItemBean;

import java.util.List;

/**
 * Created by xuwc on 2016/12/1.
 */
public interface GirlContract {

    interface  View extends BaseView{
        void showContent(List<GankItemBean> list, boolean isRefresh);
    }


    interface  Presenter extends BasePresenter<View>{
        void getGirlData(boolean isRefreshing);
    }

}
