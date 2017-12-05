package com.qingmei2.module_a;

import com.qingmei2.module.base.BaseApplication;

/**
 * Created by QingMei on 2017/12/5.
 * desc:
 */

public class ABaseApplication extends BaseApplication{

    @Override
    protected void injectApp() {
        DaggerAAppComponent.builder()
                .cacheModule(getCacheModule())
                .appModule(getAppModule())
                .globalConfigModule(getGlobalConfigModule())
                .httpClientModule(getHttpClientModule())
                .serviceModule(getServiceModule())
                .build()
                .inject(this);
    }
}
