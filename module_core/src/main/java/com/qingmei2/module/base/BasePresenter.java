package com.qingmei2.module.base;


import android.support.annotation.VisibleForTesting;

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
}
