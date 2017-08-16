package com.qingmei2.module.di.module;

import android.app.Activity;

import com.qingmei2.module.di.component.HomeActivitySubcomponent;
import com.qingmei2.module.mvp.ui.HomeActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */
@Module(subcomponents = {
        HomeActivitySubcomponent.class
})
public abstract class AllActivitysModule {

    @Binds
    @IntoMap
    @ActivityKey(HomeActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivityInjectorFactory(HomeActivitySubcomponent.Builder builder);

}
