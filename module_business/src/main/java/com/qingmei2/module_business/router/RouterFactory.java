package com.qingmei2.module_business.router;

import android.content.Context;

import com.baronzhang.android.router.Router;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by QingMei on 2017/12/5.
 * desc:
 */
@Singleton
public class RouterFactory {

    private RouterService routerService;

    @Inject
    public RouterFactory() {
    }

    public RouterService provideRouter(Context context) {
        if (routerService == null) {
            routerService = new Router(context).create(RouterService.class);
        }
        return routerService;
    }
}
