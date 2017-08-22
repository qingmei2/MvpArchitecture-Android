package com.qingmei2.module.mvp.model;

import android.support.annotation.VisibleForTesting;

import com.qingmei2.module.base.BaseModel;
import com.qingmei2.module.http.cache.CacheUtils;
import com.qingmei2.module.http.entity.UserInfo;
import com.qingmei2.module.http.service.ServiceManager;
import com.qingmei2.module.mvp.contract.HomeContract;
import com.qingmei2.module.util.RxUtils;

import javax.inject.Inject;

import io.rx_cache.DynamicKey;
import rx.Observable;

import static com.qingmei2.module.http.cache.CacheUtils.DYNAMIC_USER_INFO;

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
    public Observable<UserInfo> requestUserInfo(final String userName) {
        return serviceManager.getUserInfoService()
                .getUserInfo(userName)
                .compose(getUserInfoCache(userName, false))
                .compose(RxUtils.switchThread());
    }

    @VisibleForTesting
    public Observable.Transformer<UserInfo, UserInfo> getUserInfoCache(final String userName, final boolean refresh) {
        return CacheUtils.getUserInfoCacheTransformer(new DynamicKey(DYNAMIC_USER_INFO + userName), refresh);
    }
}
