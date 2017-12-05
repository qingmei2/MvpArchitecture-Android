package com.qingmei2.module_a;

import com.qingmei2.module.base.BaseApplication;
import com.qingmei2.module_a.di.DaggerModuleAppComponent;
import com.qingmei2.module_business.di.RouterModule;

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
                .routerModule(new RouterModule(this))
                .build()
                .inject(this);
    }
}
