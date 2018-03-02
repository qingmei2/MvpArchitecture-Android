package com.qingmei2.module_a.mvp.presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import com.qingmei2.module.base.BasePresenter;
import com.qingmei2.module_a.mvp.contract.HomeContract;

import javax.inject.Inject;

public class HomePresenter extends BasePresenter<HomeContract.View, HomeContract.Model> implements HomeContract.Presenter {

    private static final String TAG = "HomePresenter";

    @Inject
    public HomePresenter(HomeContract.View rootView, HomeContract.Model model) {
        super(rootView, model);
    }

    @SuppressLint("VisibleForTests")
    @Override
    public void requestUserInfo(String userName) {
        mModel.requestUserInfo(userName)
                .doOnDispose(() -> Log.d(TAG, "HomePresenter.requestUserInfo.dispose"))
                .as(bindLifecycle())
                .subscribe(info -> mRootView.onGetUserInfo(info),
                        e -> mRootView.onError("请求出现异常"));
    }
}
