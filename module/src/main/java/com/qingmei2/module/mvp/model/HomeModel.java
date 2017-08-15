package com.qingmei2.module.mvp.model;

import com.qingmei2.module.base.BaseModel;
import com.qingmei2.module.http.entity.UserInfo;
import com.qingmei2.module.http.service.ServiceManager;
import com.qingmei2.module.mvp.contract.HomeContract;
import com.qingmei2.module.util.RxUtils;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public class HomeModel extends BaseModel<ServiceManager> implements HomeContract.Model {

    @Inject
    public HomeModel(ServiceManager serviceManager) {
        super(serviceManager);
    }

    @Override
    public Observable<UserInfo> requestUserInfo(String userName) {
        return serviceManager.getUserInfoService()
                .getRxUser(userName)
                .compose(RxUtils.switchThread());
    }
}
