package com.qingmei2.module.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qingmei2.module.base.di.component.AppComponent;
import com.qingmei2.module.base.di.component.AppComponentHolder;
import com.trello.rxlifecycle.components.support.RxFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public abstract class BaseFragment<P extends IPresenter> extends RxFragment implements IFragment {

    protected View mRootView;
    private Unbinder mUnbinder;
    @Inject
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = initView(container);
        mUnbinder = ButterKnife.bind(this, mRootView);
        setupViews();
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        componentInject();
    }

    @Override
    public void onDestroyView() {
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        this.mPresenter = null;
        this.mRootView = null;
        this.mUnbinder = null;
        super.onDestroy();
    }

    protected abstract void setupViews();

    protected void componentInject() {
        setupFragmentComponent(AppComponentHolder.getAppComponent());
    }

    protected abstract void setupFragmentComponent(AppComponent appComponent);

    protected abstract View initView(ViewGroup container);

    protected abstract void initData();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
