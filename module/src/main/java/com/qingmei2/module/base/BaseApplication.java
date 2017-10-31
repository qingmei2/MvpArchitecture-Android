package com.qingmei2.module.base;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.support.v4.content.ContextCompat;

import com.qingmei2.module.di.component.DaggerAppComponent;
import com.qingmei2.module.di.module.AppModule;
import com.qingmei2.module.di.module.CacheModule;
import com.qingmei2.module.di.module.GlobalConfigModule;
import com.qingmei2.module.di.module.HttpClientModule;
import com.qingmei2.module.di.module.ServiceModule;
import com.qingmei2.module.http.Api;
import com.qingmei2.module.http.base.interceptor.HttpRequestHandler;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasBroadcastReceiverInjector;
import dagger.android.HasContentProviderInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.HasServiceInjector;
import dagger.android.support.HasSupportFragmentInjector;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public class BaseApplication extends Application implements HasActivityInjector,
        HasBroadcastReceiverInjector,
        HasFragmentInjector,
        HasServiceInjector,
        HasContentProviderInjector,
        HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;
    @Inject
    DispatchingAndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector;
    @Inject
    DispatchingAndroidInjector<BroadcastReceiver> broadcastReceiverInjector;
    @Inject
    DispatchingAndroidInjector<Service> serviceInjector;
    @Inject
    DispatchingAndroidInjector<ContentProvider> contentProviderInjector;

    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        inject();
    }

    private void inject() {
        BaseApplication.instance = this;
        DaggerAppComponent.builder()
                .cacheModule(getCacheModule())
                .appModule(getAppModule())
                .globalConfigModule(getGlobalConfigModule())
                .httpClientModule(getHttpClientModule())
                .serviceModule(getServiceModule())
                .build()
                .inject(this);
    }

    private AppModule getAppModule() {
        return new AppModule(this);
    }

    private GlobalConfigModule getGlobalConfigModule() {
        return GlobalConfigModule.buidler()
                .baseurl(Api.BASE_API)
                //这行代码为log打印网络请求信息，可以考虑在release版中取消该行代码
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .globeHttpHandler(new HttpRequestHandler() {
                    @Override
                    public Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, Response response) {
                        return response;
                    }

                    @Override
                    public Request onHttpRequestBefore(Interceptor.Chain chain, Request request) {
                        return request;
                    }
                })
                .build();
    }

    private HttpClientModule getHttpClientModule() {
        return new HttpClientModule();
    }

    private ServiceModule getServiceModule() {
        return new ServiceModule();
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    public CacheModule getCacheModule() {
        return new CacheModule(ContextCompat.getExternalCacheDirs(this)[0]);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override
    public AndroidInjector<BroadcastReceiver> broadcastReceiverInjector() {
        return broadcastReceiverInjector;
    }

    @Override
    public AndroidInjector<ContentProvider> contentProviderInjector() {
        return contentProviderInjector;
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return serviceInjector;
    }

    @Override
    public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }
}
