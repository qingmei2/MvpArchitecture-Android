package com.qingmei2.mvparchitecture.di.activity;


import com.qingmei2.module.di.scope.ActivityScope;
import com.qingmei2.module_business.router.RouterFactory;
import com.qingmei2.module_business.router.RouterService;
import com.qingmei2.mvparchitecture.mvp.contract.MainContract;
import com.qingmei2.mvparchitecture.mvp.model.MainModel;
import com.qingmei2.mvparchitecture.mvp.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */
@Module
public class MainActivityModule {

    @Provides
    static MainContract.View provideView(MainActivity activity) {
        return activity;
    }

    @Provides
    static MainContract.Model provideModel(MainModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    static RouterService providerRouter(MainActivity activity, RouterFactory routerFactory) {
        return routerFactory.provideRouter(activity);
    }
}
