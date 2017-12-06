package com.qingmei2.mvparchitecture;

import com.qingmei2.module.base.BaseApplication;
import com.qingmei2.mvparchitecture.di.DaggerAppComponent;

/**
 * Created by QingMei on 2017/12/5.
 * desc:
 */

public class AppBaseApplication extends BaseApplication {

    @Override
    protected void injectApp() {
        DaggerAppComponent.builder()
                .cacheModule(getCacheModule())
                .appModule(getAppModule())
                .globalConfigModule(getGlobalConfigModule())
                .httpClientModule(getHttpClientModule())
                .serviceModule(getServiceModule())
                .build()
                .inject(this);
    }
}
