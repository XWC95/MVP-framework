package org.xwc.frameworkdemo.Presenter.contract;

import org.xwc.frameworkdemo.Base.BasePresenter;
import org.xwc.frameworkdemo.Base.BaseView;
import org.xwc.frameworkdemo.Model.bean.WxItemBean;

import java.util.List;

/**
 * Created by xuwc on 2016/11/24.
 */
public interface AContract {

    interface View extends BaseView {
        void showContent(List<WxItemBean> mList);
    }

    interface Presenter extends BasePresenter<View> {

        void getGankData(Boolean isRefresh);

    }

}
