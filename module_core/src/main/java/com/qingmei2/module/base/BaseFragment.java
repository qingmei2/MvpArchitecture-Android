package com.qingmei2.module.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public abstract class BaseFragment<P extends IPresenter, B extends ViewDataBinding> extends BaseDaggerFragment implements IFragment {

    protected B b;

    protected View mRootView;
    @Inject
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getContext()).inflate(getLayoutRes(), container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        b = DataBindingUtil.bind(view);
        initView(view);
        initData();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        this.mPresenter = null;
        this.mRootView = null;
        super.onDestroy();
    }

    protected abstract void initView(View view);

    protected abstract void initData();

    protected abstract int getLayoutRes();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
