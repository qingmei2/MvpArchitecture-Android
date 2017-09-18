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

    protected V mRootView;
    protected M mModel;

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
    public <T> MaybeTransformer<T, T> bindView_maybe(IView view) {
        return RxUtils.bindView_maybe(view);
    }

    @VisibleForTesting
    public <T> ObservableTransformer<T, T> bindView_observable(IView view) {
        return RxUtils.bindView_observable(view);
    }

    @VisibleForTesting
    public <T> FlowableTransformer<T, T> bindView_flowable(IView view) {
        return RxUtils.bindView_flowable(view);
    }

    @VisibleForTesting
    public <T> SingleTransformer<T, T> bindView_single(IView view) {
        return RxUtils.bindView_single(view);
    }
}
