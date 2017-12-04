package com.qingmei2.module.base;

import android.support.annotation.VisibleForTesting;

import com.qingmei2.module.di.module.sheduler.SchedulerProvider;
import com.qingmei2.module.http.base.BaseServiceManager;
import com.qingmei2.module.http.cache.CacheProviders;

import javax.inject.Inject;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public class BaseModel<S extends BaseServiceManager> implements IModel {

    /**
     * Retrofit Service Manager
     */
    @VisibleForTesting
    public S serviceManager;

    @Inject
    protected CacheProviders cacheProviders;

    @Inject
    @VisibleForTesting
    public SchedulerProvider schedulers;

    public BaseModel(S serviceManager) {
        this.serviceManager = serviceManager;
    }


    @Override
    public void onDestroy() {
        serviceManager = null;
    }

}
