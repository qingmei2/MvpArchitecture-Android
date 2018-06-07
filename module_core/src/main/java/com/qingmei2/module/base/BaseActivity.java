package com.qingmei2.module.base;

import android.arch.lifecycle.Lifecycle;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;

import com.qingmei2.module.util.RxLifecycleUtils;
import com.uber.autodispose.AutoDisposeConverter;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public abstract class BaseActivity<P extends IPresenter, B extends ViewDataBinding> extends BaseInjectActivity implements IActivity {

    protected B b;

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        b = DataBindingUtil.setContentView(this, getLayoutId());
        initLifecycleObserver(getLifecycle());
        initView();
        initData();
    }

    protected <T> AutoDisposeConverter<T> bindLifecycle() {
        return RxLifecycleUtils.bindLifecycle(this);
    }

    @MainThread
    protected abstract int getLayoutId();

    @CallSuper
    @MainThread
    protected void initLifecycleObserver(@NotNull Lifecycle lifecycle) {
        presenter.setLifecycleOwner(this);
        lifecycle.addObserver(presenter);
    }

    @MainThread
    protected abstract void initView();

    @MainThread
    protected abstract void initData();

    @MainThread
    @Override
    public void showLoading() {

    }

    @MainThread
    @Override
    public void hideLoading() {

    }
}
