package com.qingmei2.mvparchitecture.di;

import com.qingmei2.module.di.component.BaseActivityComponent;
import com.qingmei2.module.di.scope.ActivityScope;
import com.qingmei2.mvparchitecture.di.activity.MainActivityModule;
import com.qingmei2.mvparchitecture.mvp.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */
@Module(subcomponents = {
        BaseActivityComponent.class
})
public abstract class ActivitiesModuleApp {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivitytInjector();
}
