package com.qingmei2.module_a.mvp.presenter;

import android.annotation.SuppressLint;

import com.annimon.stream.Optional;
import com.qingmei2.module.base.BasePresenter;
import com.qingmei2.module.http.entity.UserInfo;
import com.qingmei2.module_a.mvp.contract.HomeContract;

import javax.inject.Inject;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public class HomePresenter extends BasePresenter<HomeContract.View, HomeContract.Model> implements HomeContract.Presenter {

    @Inject
    public HomePresenter(HomeContract.View rootView, HomeContract.Model model) {
        super(rootView, model);
    }

    @SuppressLint("VisibleForTests")
    @Override
    public void requestUserInfo(String userName) {
        mModel.requestUserInfo(userName)
                .compose(bindViewMaybe(mRootView))
                .subscribe(info -> Optional.ofNullable(info)
                                .map(UserInfo::getLogin)
                                .ifPresentOrElse(image -> mRootView.onGetUserInfo(info)
                                        , () -> mRootView.onError("用户信息为空"))
                        , e -> mRootView.onError("请求出现异常"));
    }
}
