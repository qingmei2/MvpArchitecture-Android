package com.qingmei2.module_business.di;

import android.app.Application;

import com.baronzhang.android.router.Router;
import com.qingmei2.module_business.router.RouterService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by QingMei on 2017/12/5.
 * desc:
 */
@Module
public class RouterModule {

    private final Application app;

    public RouterModule(Application app) {
        this.app = app;
    }

    @Singleton
    @Provides
    RouterService provideRouterService() {
        return new Router(app).create(RouterService.class);
    }
}
