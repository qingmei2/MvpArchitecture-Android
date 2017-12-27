package com.qingmei2.module.base;

import android.app.Activity;

import com.trello.rxlifecycle2.components.support.RxFragment;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by QingMei on 2017/12/27.
 * desc:
 */

public abstract class BaseDaggerFragment extends RxFragment {

    protected void inject() {
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onAttach(Activity activity) {
        inject();
        super.onAttach(activity);
    }
}
