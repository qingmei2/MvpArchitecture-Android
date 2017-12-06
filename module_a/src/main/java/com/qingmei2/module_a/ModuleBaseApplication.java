package com.qingmei2.module_a;

import com.qingmei2.module.base.BaseApplication;
import com.qingmei2.module_a.di.DaggerModuleAppComponent;

/**
 * Created by QingMei on 2017/12/5.
 * desc:
 */

public class ModuleBaseApplication extends BaseApplication {

    @Override
    protected void injectApp() {
        DaggerModuleAppComponent.builder()
                .cacheModule(getCacheModule())
                .appModule(getAppModule())
                .globalConfigModule(getGlobalConfigModule())
                .httpClientModule(getHttpClientModule())
                .serviceModule(getServiceModule())
                .build()
                .inject(this);
    }
}
