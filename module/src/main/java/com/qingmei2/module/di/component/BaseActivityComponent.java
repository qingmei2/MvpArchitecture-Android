package com.qingmei2.module.di.component;

import com.qingmei2.module.base.BaseActivity;
import com.qingmei2.module.di.module.activity.HomeActivityModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */
@Subcomponent(modules = {
        AndroidInjectionModule.class,
        //每添加一个ActivityModule,只需要在此处添加对应的Module依赖即可
        HomeActivityModule.class
})
public interface BaseActivityComponent extends AndroidInjector<BaseActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseActivity> {
    }

}
