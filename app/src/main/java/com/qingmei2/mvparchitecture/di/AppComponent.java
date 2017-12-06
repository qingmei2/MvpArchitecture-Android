package com.qingmei2.mvparchitecture.di;

import com.google.gson.Gson;
import com.qingmei2.module.base.BaseApplication;
import com.qingmei2.module.di.module.AppModule;
import com.qingmei2.module.di.module.CacheModule;
import com.qingmei2.module.di.module.GlobalConfigModule;
import com.qingmei2.module.di.module.HttpClientModule;
import com.qingmei2.module.di.module.ServiceModule;
import com.qingmei2.module.http.service.ServiceManager;
import com.qingmei2.module_a.di.AbstractModuleActivitiesModule;

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
        AbstractAppActivitiesModule.class,
        AbstractModuleActivitiesModule.class
        //下面应该是所有module对应的所有Activities:
        //BActivitiesModule.class
        //CActivitiesModule.class
})
public interface AppComponent {

    Gson gson();

    ServiceManager serviceManager();

    OkHttpClient okHttpClient();

    BaseApplication baseApplication();

    void inject(BaseApplication application);
}
