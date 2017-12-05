package com.qingmei2.module_a.di;

import com.qingmei2.module.di.component.BaseActivityComponent;
import com.qingmei2.module.di.scope.ActivityScope;
import com.qingmei2.module_a.di.activity.HomeActivityModule;
import com.qingmei2.module_a.mvp.ui.HomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */
@Module(subcomponents = {
        BaseActivityComponent.class
})
public abstract class AbstractModuleActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = HomeActivityModule.class)
    abstract HomeActivity contributeHomeActivitytInjector();

}
