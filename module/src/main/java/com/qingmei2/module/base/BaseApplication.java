package com.qingmei2.module.base;

import android.app.Application;
import android.util.Log;

import com.qingmei2.module.base.di.component.AppComponent;
import com.qingmei2.module.base.di.component.ComponentHolder;
import com.qingmei2.module.base.di.component.DaggerAppComponent;
import com.qingmei2.module.base.di.module.AppModule;
import com.qingmei2.module.base.di.module.GlobalConfigModule;
import com.qingmei2.module.base.di.module.HttpClientModule;
import com.qingmei2.module.base.di.module.ServiceModule;
import com.qingmei2.module.http.Api;
import com.qingmei2.module.http.base.interceptor.HttpRequestHandler;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


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
                .appModule(getAppModule())                      //注入application
                .globalConfigModule(getGlobalConfigModule())    //注入全局配置
                .httpClientModule(getHttpClientModule())        //注入http配置
                .serviceModule(getServiceModule())              //注入所有Service
                .build();
        Log.i("tag","ComponentHolder.setAppComponent");
        ComponentHolder.setAppComponent(appComponent);
    }

    private AppModule getAppModule() {
        return new AppModule(this);
    }

    private GlobalConfigModule getGlobalConfigModule() {
        return GlobalConfigModule.buidler()
                .baseurl(Api.BASE_API)
                //这行代码为log打印网络请求信息，可以考虑在release版中取消该行改吗
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
}
