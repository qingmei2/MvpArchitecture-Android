package com.qingmei2.module.http.cache;

import com.qingmei2.module.http.entity.UserInfo;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import rx.Observable;

/**
 * Created by QingMei on 2017/8/17.
 * desc:
 */

public class CacheUtils {

    public static final String DYNAMIC_USER_INFO = "dynamicKey_userInfo_";

    public static Observable.Transformer<UserInfo, UserInfo> saveCaches(DynamicKey dynamicKey, boolean refresh) {
        return tObservable -> CacheProviders
                .getUserInfoCacheProviders()
                .getUserInfo(tObservable, dynamicKey, new EvictDynamicKey(refresh));
    }
}
