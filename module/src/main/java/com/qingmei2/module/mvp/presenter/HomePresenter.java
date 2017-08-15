package com.qingmei2.module.mvp.presenter;

import com.annimon.stream.Optional;
import com.qingmei2.module.base.BasePresenter;
import com.qingmei2.module.mvp.contract.HomeContract;
import com.qingmei2.module.util.RxUtils;

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

    @Override
    public void requestUserInfo(String userName) {
        mModel.requestUserInfo(userName)
                .compose(RxUtils.bindToLifecycle(mRootView))
                .subscribe(info -> Optional.ofNullable(info)
                                .ifPresentOrElse(userInfo -> mRootView.onGetUserInfo(userInfo)
                                        , () -> mRootView.onError("用户信息为空"))
                        , e -> mRootView.onError(e.getMessage()));
    }
}
