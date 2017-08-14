package com.qingmei2.module.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qingmei2.module.di.component.AppComponent;
import com.qingmei2.module.di.component.AppComponentHolder;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public abstract class BaseActivity<P extends IPresenter> extends RxAppCompatActivity implements IActivity {

    private Unbinder mUnbinder;

    @Inject
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        componentInject();
        initData();
        initView();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
        this.mPresenter = null;
        this.mUnbinder = null;
        super.onDestroy();
    }

    protected abstract int getLayoutId();

    protected void componentInject() {
        setupActivityComponent(AppComponentHolder.getAppComponent());
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void setupActivityComponent(AppComponent appComponent);

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
