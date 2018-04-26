package org.xwc.frameworkdemo.Utils;

import android.text.TextUtils;

import org.xwc.frameworkdemo.Base.BaseView;
import org.xwc.frameworkdemo.Model.http.ApiException;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * Created by xwc on 2018/3/14.
 */
public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    protected CommonSubscriber(BaseView view) {
        this.mView = view;
    }

    protected CommonSubscriber(BaseView view, String errorMsg) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(BaseView view, boolean isShowErrorState) {
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(BaseView view, String errorMsg, boolean isShowErrorState) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showError(mErrorMsg);
        } else if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            mView.showError(apiException.getMessage());
        } else if (e instanceof HttpException) {
            mView.showError("数据加载失败");
        } else {
            mView.showError("未知错误");
            LogUtil.d(e.toString());
        }
        //TODO
//        if (isShowErrorState) {
//
//        }
    }
}