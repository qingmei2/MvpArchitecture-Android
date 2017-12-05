package com.qingmei2.mvparchitecture.mvp.ui;

import com.qingmei2.module.base.BaseActivity;
import com.qingmei2.mvparchitecture.R;
import com.qingmei2.mvparchitecture.databinding.AppActivityMainBinding;
import com.qingmei2.mvparchitecture.mvp.contract.MainContract;
import com.qingmei2.mvparchitecture.mvp.presenter.MainPresenter;

/**
 * Created by QingMei on 2017/12/5.
 * desc:
 */

public class MainActivity extends BaseActivity<MainPresenter, AppActivityMainBinding> implements MainContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.app_activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}
