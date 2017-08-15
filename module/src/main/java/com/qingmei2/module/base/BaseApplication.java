package com.qingmei2.module.base;

import android.app.Application;

import com.qingmei2.module.base.di.component.AppComponent;
import com.qingmei2.module.base.di.component.AppComponentHolder;
import com.qingmei2.module.di.component.DaggerAppComponent;
import com.qingmei2.module.base.di.module.BaseApplicationModule;


/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        inject();
    }

    private void inject() {
        BaseApplication.instance = this;
        AppComponent appComponent = DaggerAppComponent.builder()
                .baseApplicationModule(new BaseApplicationModule(this))
                .build();
        AppComponentHolder.setAppComponent(appComponent);
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
