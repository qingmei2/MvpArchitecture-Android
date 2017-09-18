package com.qingmei2.module.util;

import com.qingmei2.module.base.IView;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import io.reactivex.FlowableTransformer;
import io.reactivex.MaybeTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Glooory on 17/5/15.
 */

public class RxUtils {

    public static <T> LifecycleTransformer<T> bindToLifecycle(IView view) {
        if (view instanceof RxAppCompatActivity) {
            return ((RxAppCompatActivity) view).bindToLifecycle();
        } else if (view instanceof RxFragment) {
            return ((RxFragment) view).bindToLifecycle();
        } else {
            throw new IllegalArgumentException("view isn't activity or fragment");
        }
    }

    public static <T> MaybeTransformer<T, T> bindView_maybe(IView view) {
        return bindToLifecycle(view);
    }

    public static <T> ObservableTransformer<T, T> bindView_observable(IView view) {
        return bindToLifecycle(view);
    }

    public static <T> SingleTransformer<T, T> bindView_single(IView view) {
        return bindToLifecycle(view);
    }

    public static <T> FlowableTransformer<T, T> bindView_flowable(IView view) {
        return bindToLifecycle(view);
    }

    public static <T> MaybeTransformer<T, T> switchThread_maybe() {
        return maybe ->
                maybe
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<T, T> switchThread_observable() {
        return observable ->
                observable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> SingleTransformer<T, T> switchThread_single() {
        return single ->
                single
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> FlowableTransformer<T, T> switchThread_flowable() {
        return flowable ->
                flowable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }
}
