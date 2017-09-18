package com.qingmei2.module.mocks;

import org.reactivestreams.Publisher;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;

/**
 * Created by QingMei on 2017/9/18.
 * desc:
 */

public class TestRxTransformer<T> implements ObservableTransformer<T, T>,
        FlowableTransformer<T, T>,
        SingleTransformer<T, T>,
        MaybeTransformer<T, T>,
        CompletableTransformer {

    @Override
    public CompletableSource apply(Completable upstream) {
        return upstream;
    }

    @Override
    public Publisher<T> apply(Flowable<T> upstream) {
        return upstream;
    }

    @Override
    public MaybeSource<T> apply(Maybe<T> upstream) {
        return upstream;
    }

    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream;
    }

    @Override
    public SingleSource<T> apply(Single<T> upstream) {
        return upstream;
    }
}
