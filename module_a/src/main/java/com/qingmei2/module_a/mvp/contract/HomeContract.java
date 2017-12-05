package com.qingmei2.module_a.mvp.contract;

import com.qingmei2.module.base.IModel;
import com.qingmei2.module.base.IPresenter;
import com.qingmei2.module.base.IView;
import com.qingmei2.module.http.entity.UserInfo;

import io.reactivex.Maybe;


/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public interface HomeContract {

    interface View extends IView {
        void onGetUserInfo(UserInfo userInfo);

        void onError(String errorMassage);
    }

    interface Presenter extends IPresenter {
        void requestUserInfo(String user);
    }

    interface Model extends IModel {
        Maybe<UserInfo> requestUserInfo(String userName);
    }
}
