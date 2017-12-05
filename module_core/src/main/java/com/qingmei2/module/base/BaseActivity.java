package com.qingmei2.module.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baronzhang.android.router.RouterInjector;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public abstract class BaseActivity<P extends IPresenter,B extends ViewDataBinding> extends RxAppCompatActivity implements IActivity {

    protected B b;

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        inject();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        b = DataBindingUtil.setContentView(this, getLayoutId());
        initData();
        initView();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.onDestroy();
        }
        this.presenter = null;
        super.onDestroy();
    }

    protected abstract int getLayoutId();

    protected void inject() {
        AndroidInjection.inject(this);
        RouterInjector.inject(this);
    }

    protected abstract void initData();

    protected abstract void initView();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
