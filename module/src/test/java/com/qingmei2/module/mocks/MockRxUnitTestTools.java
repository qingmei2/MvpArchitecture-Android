package com.qingmei2.module.mocks;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

/**
 * Created by QingMei on 2017/6/27.
 * desc:
 */

public class MockRxUnitTestTools {

    /**
     * 把异步变成同步，方便测试
     */
    public static void asyncToSync() {
        Func1<Scheduler, Scheduler> schedulerFunc = new Func1<Scheduler, Scheduler>() {
            @Override
            public Scheduler call(Scheduler scheduler) {
                return Schedulers.immediate();
            }
        };

        RxAndroidSchedulersHook rxAndroidSchedulersHook = new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        };

        RxJavaHooks.reset();
        RxJavaHooks.setOnIOScheduler(schedulerFunc);
        RxJavaHooks.setOnComputationScheduler(schedulerFunc);

        RxAndroidPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().registerSchedulersHook(rxAndroidSchedulersHook);
    }
}
