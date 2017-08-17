package com.qingmei2.module.http.cache;

import android.support.v4.content.ContextCompat;

import com.qingmei2.module.base.BaseApplication;

import io.rx_cache.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;

/**
 * Created by TaoPu on 17/7/6.
 */

public class CacheProviders {

    private static UserInfoCacheProviders userInfoCacheProviders;

    public static UserInfoCacheProviders getUserInfoCacheProviders() {
        if (userInfoCacheProviders == null) {
            synchronized (UserInfoCacheProviders.class) {
                userInfoCacheProviders = new RxCache.Builder()
                        .persistence(ContextCompat.getExternalCacheDirs(BaseApplication.getInstance())[0], new GsonSpeaker())
                        .using(UserInfoCacheProviders.class);
            }
        }
        return userInfoCacheProviders;
    }
}
