package com.qingmei2.module.util;

import com.qingmei2.module.base.IView;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import io.reactivex.ObservableTransformer;
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

    public static <T> ObservableTransformer<T, T> switchThread() {
        return tObservable ->
                tObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }
}
