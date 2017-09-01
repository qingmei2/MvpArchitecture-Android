package com.qingmei2.module.http.cache;

import com.qingmei2.module.http.entity.UserInfo;

import java.util.concurrent.TimeUnit;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.LifeCache;
import rx.Observable;

/**
 * Created by QingMei on 2017/8/17.
 * desc:UserInfo缓存
 */

public interface UserInfoCacheProviders {

    @LifeCache(duration = 10, timeUnit = TimeUnit.SECONDS)
    Observable<UserInfo> getUserInfo(
            Observable<UserInfo> userInfoObservable,
            DynamicKey dynamicKey,
            EvictDynamicKey evictDynamicKey
    );

}
