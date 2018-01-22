package com.qingmei2.module.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.support.multidex.MultiDexApplication;
import android.support.v4.content.ContextCompat;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;
import com.qingmei2.module.BuildConfig;
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
import okhttp3.internal.platform.Platform;


/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public abstract class BaseApplication extends MultiDexApplication implements HasActivityInjector,
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

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
        initDI();
    }

    /**
     * 初始化ARouter
     * <p>
     * {@link BuildConfig} 决定是否开启调试模式
     * (如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
     */
    protected void initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    private void initDI() {
        BaseApplication.instance = this;
        injectApp();
    }

    /**
     * 这是类库底层的injectApp代码示例，你应该在你的Module中重写该方法:
     * <p>
     * DaggerBaseAppComponent.builder()
     * .cacheModule(getCacheModule())
     * .appModule(getAppModule())
     * .globalConfigModule(getGlobalConfigModule())
     * .httpClientModule(getHttpClientModule())
     * .serviceModule(getServiceModule())
     * .build()
     * .initDI(this);
     */
    abstract protected void injectApp();

    protected AppModule getAppModule() {
        return new AppModule(this);
    }

    protected GlobalConfigModule getGlobalConfigModule() {
        return GlobalConfigModule.buidler()
                .baseurl(Api.BASE_API)
                .addInterceptor(new LoggingInterceptor.Builder()
                        .loggable(BuildConfig.DEBUG)
                        .setLevel(Level.BASIC)
                        .log(Platform.INFO)
                        .request("Request")
                        .response("Response")
                        .build())
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

    protected HttpClientModule getHttpClientModule() {
        return new HttpClientModule();
    }

    protected ServiceModule getServiceModule() {
        return new ServiceModule();
    }

    protected CacheModule getCacheModule() {
        return new CacheModule(ContextCompat.getExternalCacheDirs(this)[0]);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Dependencies Injection by dagger.android
    ///////////////////////////////////////////////////////////////////////////

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
