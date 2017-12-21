package com.qingmei2.module.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public abstract class BaseActivity<P extends IPresenter, B extends ViewDataBinding> extends BaseDaggerActivity implements IActivity {

    protected B b;

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
