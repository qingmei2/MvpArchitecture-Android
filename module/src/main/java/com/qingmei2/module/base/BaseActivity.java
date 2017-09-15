package com.qingmei2.module.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public abstract class BaseActivity<P extends IPresenter> extends RxAppCompatActivity implements IActivity {

    private Unbinder mUnbinder;

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        componentInject();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.onDestroy();
        }
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
        this.presenter = null;
        this.mUnbinder = null;
        super.onDestroy();
    }

    protected abstract int getLayoutId();

    protected void componentInject() {
        AndroidInjection.inject(this);
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
