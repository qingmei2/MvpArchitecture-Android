package com.qingmei2.mvparchitecture.mvp.presenter;

import com.qingmei2.module.base.BasePresenter;
import com.qingmei2.mvparchitecture.mvp.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by QingMei on 2017/12/5.
 * desc:
 */

public class MainPresenter extends BasePresenter<MainContract.View, MainContract.Model> implements MainContract.Presenter{

    @Inject
    public MainPresenter(MainContract.View rootView, MainContract.Model model) {
        super(rootView, model);
    }
}
