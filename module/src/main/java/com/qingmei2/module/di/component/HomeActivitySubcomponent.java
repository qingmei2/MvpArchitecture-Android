package com.qingmei2.module.di.component;

import com.qingmei2.module.di.scope.ActivityScope;
import com.qingmei2.module.mvp.contract.HomeContract;
import com.qingmei2.module.mvp.model.HomeModel;
import com.qingmei2.module.mvp.ui.HomeActivity;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */
@ActivityScope
@Subcomponent(modules = {
        AndroidInjectionModule.class,
        HomeActivitySubcomponent.SubModule.class
})
public interface HomeActivitySubcomponent extends AndroidInjector<HomeActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<HomeActivity> {
    }

    @Module
    class SubModule {

        @Provides
        @ActivityScope
        HomeContract.View provideView(HomeActivity activity) {
            return activity;
        }

        @Provides
        @ActivityScope
        HomeContract.Model provideModel(HomeModel homeModel) {
            return homeModel;
        }
    }
}
