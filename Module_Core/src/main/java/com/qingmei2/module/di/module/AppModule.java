package com.qingmei2.module.di.module;

import com.qingmei2.module.base.BaseApplication;
import com.qingmei2.module.di.module.sheduler.AppSchedulerProvider;
import com.qingmei2.module.di.module.sheduler.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */
@Module
public class AppModule {

    private BaseApplication application;

    public AppModule(BaseApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public BaseApplication provideApplication() {
        return application;
    }

    @Singleton
    @Provides
    public SchedulerProvider provideSchedulers() {
        return new AppSchedulerProvider();
    }
}
