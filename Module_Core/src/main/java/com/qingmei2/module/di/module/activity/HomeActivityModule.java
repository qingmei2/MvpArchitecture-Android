package com.qingmei2.module.di.module.activity;

import com.qingmei2.module.mvp.contract.HomeContract;
import com.qingmei2.module.mvp.model.HomeModel;
import com.qingmei2.module.mvp.ui.HomeActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */
@Module
public class HomeActivityModule {

    @Provides
    static HomeContract.View provideView(HomeActivity activity) {
        return activity;
    }

    @Provides
    static HomeContract.Model provideModel(HomeModel homeModel) {
        return homeModel;
    }
}
