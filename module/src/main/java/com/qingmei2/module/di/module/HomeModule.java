package com.qingmei2.module.di.module;

import com.qingmei2.module.base.di.scope.ActivityScope;
import com.qingmei2.module.mvp.contract.HomeContract;
import com.qingmei2.module.mvp.model.HomeModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */
@Module
public class HomeModule {

    private final HomeContract.View view;

    public HomeModule(HomeContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    HomeContract.View provideHomeView() {
        return view;
    }

    @ActivityScope
    @Provides
    HomeContract.Model provideHomeModel(HomeModel homeModel) {
        return homeModel;
    }
}
