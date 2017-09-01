package com.qingmei2.module.di.module;

import android.support.v4.content.ContextCompat;

import com.qingmei2.module.base.BaseApplication;
import com.qingmei2.module.http.cache.UserInfoCacheProviders;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;

/**
 * Created by QingMei on 2017/9/1.
 * desc:
 */
@Module
public class CacheModule {

    @Provides
    @Singleton
    RxCache provideRxCache(BaseApplication application) {
        return new RxCache.Builder()
                .persistence(ContextCompat.getExternalCacheDirs(BaseApplication.getInstance())[0], new GsonSpeaker());
    }

    @Provides
    @Singleton
    UserInfoCacheProviders providers(RxCache rxCache) {
        return rxCache.using(UserInfoCacheProviders.class);
    }

}
