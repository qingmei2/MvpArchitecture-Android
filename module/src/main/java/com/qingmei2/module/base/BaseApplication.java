package com.qingmei2.module.base;

import android.app.Application;

import com.qingmei2.module.di.component.AppComponent;
import com.qingmei2.module.di.component.AppComponentHolder;
import com.qingmei2.module.di.component.DaggerAppComponent;
import com.qingmei2.module.di.module.BaseApplicationModule;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        inject();
    }

    private void inject() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .baseApplicationModule(new BaseApplicationModule(this))
                .build();
        AppComponentHolder.setAppComponent(appComponent);
    }
}
