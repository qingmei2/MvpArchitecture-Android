package com.qingmei2.module_a;

import com.google.gson.Gson;
import com.qingmei2.module.base.BaseApplication;
import com.qingmei2.module.di.module.AppModule;
import com.qingmei2.module.di.module.CacheModule;
import com.qingmei2.module.di.module.GlobalConfigModule;
import com.qingmei2.module.di.module.HttpClientModule;
import com.qingmei2.module.di.module.ServiceModule;
import com.qingmei2.module.http.service.ServiceManager;
import com.qingmei2.module_a.di.AActivitiesModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import okhttp3.OkHttpClient;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AppModule.class,
        HttpClientModule.class,
        GlobalConfigModule.class,
        ServiceModule.class,
        CacheModule.class,
        AActivitiesModule.class
})
public interface AAppComponent {

    Gson gson();

    ServiceManager serviceManager();

    OkHttpClient okHttpClient();

    BaseApplication baseApplication();

    void inject(BaseApplication application);
}
