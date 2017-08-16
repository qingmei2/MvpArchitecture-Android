package com.qingmei2.module.di.module;

import com.qingmei2.module.di.component.BaseActivityComponent;
import com.qingmei2.module.di.module.activity.HomeActivityModule;
import com.qingmei2.module.mvp.ui.HomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */
@Module(subcomponents = {
        BaseActivityComponent.class
})
public abstract class AllActivitysModule {

    @ContributesAndroidInjector(modules = HomeActivityModule.class)
    abstract HomeActivity contributeHomeActivitytInjector();

}
