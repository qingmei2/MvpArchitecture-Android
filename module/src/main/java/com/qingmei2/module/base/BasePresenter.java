package com.qingmei2.module.base;


import android.support.annotation.VisibleForTesting;

import com.qingmei2.module.util.RxUtils;

import io.reactivex.FlowableTransformer;
import io.reactivex.MaybeTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public class BasePresenter<V extends IView, M extends IModel> implements IPresenter {

    @VisibleForTesting
    public V mRootView;

    @VisibleForTesting
    public M mModel;

    public BasePresenter(V rootView, M model) {
        this.mRootView = rootView;
        this.mModel = model;
    }

    public BasePresenter(V rootView) {
        this.mRootView = rootView;
    }

    @Override
    public void onDestroy() {
        if (mModel != null) {
            mModel.onDestroy();
            this.mModel = null;
        }
        this.mRootView = null;
    }

    @VisibleForTesting
    public <T> MaybeTransformer<T, T> bindViewMaybe(IView view) {
        return RxUtils.bindViewMaybe(view);
    }

    @VisibleForTesting
    public <T> ObservableTransformer<T, T> bindViewObservable(IView view) {
        return RxUtils.bindViewObservable(view);
    }

    @VisibleForTesting
    public <T> FlowableTransformer<T, T> bindViewFlowable(IView view) {
        return RxUtils.bindViewFlowable(view);
    }

    @VisibleForTesting
    public <T> SingleTransformer<T, T> bindViewSingle(IView view) {
        return RxUtils.bindViewSingle(view);
    }
}
