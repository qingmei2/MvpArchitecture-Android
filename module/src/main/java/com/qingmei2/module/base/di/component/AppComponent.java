package com.qingmei2.module.base.di.component;

import com.google.gson.Gson;
import com.qingmei2.module.base.BaseApplication;
import com.qingmei2.module.base.di.module.BaseApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */
@Singleton
@Component(modules = BaseApplicationModule.class)
public interface AppComponent {

    Gson gson();

    void inject(BaseApplication application);
}
