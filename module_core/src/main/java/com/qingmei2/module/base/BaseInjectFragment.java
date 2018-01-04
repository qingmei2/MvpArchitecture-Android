package com.qingmei2.module.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

import dagger.android.support.AndroidSupportInjection;

/**
 * The class for controlling the dependency injection category.
 * <p>
 * Dependency injection that developers should be concerned about is the *Dagger* and the *ARouter*
 * <p>
 * Created by QingMei on 2017/12/27.
 */

public abstract class BaseInjectFragment extends Fragment {

    protected void inject() {
        AndroidSupportInjection.inject(this);
        if (injectRouter())
            ARouter.getInstance().inject(this);
    }

    protected boolean injectRouter() {
        return false;
    }

    @Override
    public void onAttach(Activity activity) {
        inject();
        super.onAttach(activity);
    }
}
