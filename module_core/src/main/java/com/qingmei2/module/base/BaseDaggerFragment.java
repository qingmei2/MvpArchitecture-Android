package com.qingmei2.module.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by QingMei on 2017/12/27.
 * desc:
 */

public abstract class BaseDaggerFragment extends Fragment {

    protected void inject() {
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onAttach(Activity activity) {
        inject();
        super.onAttach(activity);
    }
}
