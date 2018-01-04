package com.qingmei2.module.base;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.CallSuper;
import android.support.annotation.MainThread;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;

/**
 * Created by QingMei on 2017/8/14.
 */
public class BasePresenter<V extends IView, M extends IModel> implements IPresenter {

    private static final String TAG = "com.qingmei2.module.base.BasePresenter";

    @Getter
    protected V mRootView;

    @Getter
    protected M mModel;

    public BasePresenter(V rootView, M model) {
        this.mRootView = rootView;
        this.mModel = model;
    }

    @Override
    @CallSuper
    @MainThread
    public void onLifecycleChanged(@NotNull LifecycleOwner owner, @NotNull Lifecycle.Event event) {

    }

    @Override
    @CallSuper
    @MainThread
    public void onCreate(@NotNull LifecycleOwner owner) {

    }

    @Override
    @CallSuper
    @MainThread
    public void onDestroy(@NotNull LifecycleOwner owner) {
        if (mModel != null) {
            mModel.onDestroy();
            this.mModel = null;
        }
        this.mRootView = null;
    }

}
