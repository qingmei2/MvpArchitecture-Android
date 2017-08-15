package com.qingmei2.module.base.di.module;

import com.google.gson.Gson;
import com.qingmei2.module.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */
@Module
public class BaseApplicationModule {

    private final BaseApplication application;

    public BaseApplicationModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }
}
