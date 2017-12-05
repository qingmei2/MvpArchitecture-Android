package com.qingmei2.module.di.component;

import android.content.BroadcastReceiver;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by QingMei on 2017/10/31.
 * desc:
 */
@Subcomponent(modules = {
        AndroidInjectionModule.class,
})
public interface BroadcastsComponent extends AndroidInjector<BroadcastReceiver> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BroadcastReceiver> {
    }
}
