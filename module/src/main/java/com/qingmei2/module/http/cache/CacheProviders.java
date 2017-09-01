package com.qingmei2.module.http.cache;

import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.Getter;

@Singleton
public class CacheProviders {

    @Getter
    private UserInfoCacheProviders userInfoCacheProviders;

    @Inject
    public CacheProviders(UserInfoCacheProviders userInfoCacheProviders) {
        this.userInfoCacheProviders = userInfoCacheProviders;
    }

}
