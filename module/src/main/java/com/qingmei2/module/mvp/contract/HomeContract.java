package com.qingmei2.module.mvp.contract;

import com.qingmei2.module.base.IModel;
import com.qingmei2.module.base.IPresenter;
import com.qingmei2.module.base.IView;
import com.qingmei2.module.http.entity.UserInfo;

import rx.Observable;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public interface HomeContract {

    public interface View extends IView {
        void onGetUserInfo(UserInfo userInfo);

        void onError(String errorMassage);
    }

    public interface Presenter extends IPresenter {
        void requestUserInfo(String userName);
    }

    public interface Model extends IModel {
        Observable<UserInfo> requestUserInfo(String userName);
    }
}
