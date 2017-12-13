package com.qingmei2.mvparchitecture.di.activity;


import com.qingmei2.mvparchitecture.mvp.contract.MainContract;
import com.qingmei2.mvparchitecture.mvp.model.MainModel;
import com.qingmei2.mvparchitecture.mvp.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by QingMei on 2017/8/16.
 * desc:
 */
@Module
public class MainActivityModule {

    @Provides
    static MainContract.View provideView(MainActivity activity) {
        return activity;
    }

    @Provides
    static MainContract.Model provideModel(MainModel model) {
        return model;
    }

}
