package com.qingmei2.module.base;

import android.arch.lifecycle.Lifecycle;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

/**
 * Created by QingMei on 2017/8/14.
 */

public abstract class BaseFragment<P extends IPresenter, B extends ViewDataBinding> extends BaseInjectFragment implements IFragment {

    protected B b;

    protected View rootView;

    @Inject
    protected P presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getContext()).inflate(getLayoutRes(), container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        b = DataBindingUtil.bind(view);
        initLifecycleObserver(getLifecycle());
        initView(view);
        initData();
    }

    @Override
    public void onDestroy() {
        this.rootView = null;
        super.onDestroy();
    }

    @CallSuper
    @MainThread
    protected void initLifecycleObserver(@NotNull Lifecycle lifecycle) {
        lifecycle.addObserver(presenter);
    }

    protected abstract void initView(View view);

    protected abstract void initData();

    protected abstract int getLayoutRes();

    @MainThread
    @Override
    public void showLoading() {

    }

    @MainThread
    @Override
    public void hideLoading() {

    }
}
