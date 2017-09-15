package com.qingmei2.module.http.cache;

import com.qingmei2.module.http.entity.UserInfo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.LifeCache;


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
