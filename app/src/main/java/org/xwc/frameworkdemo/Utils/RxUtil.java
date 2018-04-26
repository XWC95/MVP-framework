package org.xwc.frameworkdemo.Utils;

import org.xwc.frameworkdemo.Model.http.ApiException;
import org.xwc.frameworkdemo.Model.http.GankHttpResponse;
import org.xwc.frameworkdemo.Model.http.WxHttpResponse;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xwc on 2018/3/14.
 */
public class RxUtil {

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<GankHttpResponse<T>, T> handleGankResult() {
        return new FlowableTransformer<GankHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<GankHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<GankHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(GankHttpResponse<T> response) {
                        if (!response.getError()) {
                            return createData(response.getResults());
                        } else {
                            return Flowable.error(new ApiException("服务器异常"));
                        }
                    }
                });
            }
        };
    }

    public static <T> FlowableTransformer<WxHttpResponse<T>, T> handleWxResult() {
        return new FlowableTransformer<WxHttpResponse<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<WxHttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<WxHttpResponse<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(WxHttpResponse<T> response) {
                        if (response.getCode() == 200) {
                            return createData(response.getNewslist());
                        } else {
                            return Flowable.error(new ApiException(response.getMsg()));
                        }
                    }
                });
            }
        };
    }


    /**
     * 生成Flowable
     *
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }
}