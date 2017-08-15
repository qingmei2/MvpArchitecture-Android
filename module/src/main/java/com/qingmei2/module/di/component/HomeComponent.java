package com.qingmei2.module.di.component;

import com.qingmei2.module.base.di.component.AppComponent;
import com.qingmei2.module.base.di.scope.ActivityScope;
import com.qingmei2.module.di.module.HomeModule;
import com.qingmei2.module.mvp.ui.HomeActivity;

import dagger.Component;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */
@ActivityScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {

    void inject(HomeActivity activity);
}
