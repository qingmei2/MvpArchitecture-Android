package com.qingmei2.module.base.di.component;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public class ComponentHolder {

    public static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static void setAppComponent(AppComponent appComponent) {
        ComponentHolder.appComponent = appComponent;
    }
}
