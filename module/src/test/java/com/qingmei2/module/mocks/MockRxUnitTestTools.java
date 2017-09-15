package com.qingmei2.module.mocks;


/**
 * Created by QingMei on 2017/6/27.
 * desc:
 */

public class MockRxUnitTestTools {

    /**
     * 把异步变成同步，方便测试
     */
    public static void asyncToSync() {
//        Function<Scheduler, Scheduler> schedulerFunc = new Function<Scheduler, Scheduler>() {
//            @Override
//            public Scheduler call(Scheduler scheduler) {
//                return Schedulers.start();
//            }
//        };
//        TestSubscriber
//        RxAndroid2SchedulersHook rxAndroidSchedulersHook = new RxAndroidSchedulersHook() {
//            @Override
//            public Scheduler getMainThreadScheduler() {
//                return Schedulers.start();
//            }
//        };
//        RxJavaPlugins.
//        RxJavaHooks.reset();
//        RxJavaHooks.setOnIOScheduler(schedulerFunc);
//        RxJavaHooks.setOnComputationScheduler(schedulerFunc);
//
//        RxAndroidPlugins.getInstance().reset();
//        RxAndroidPlugins.getInstance().registerSchedulersHook(rxAndroidSchedulersHook);
    }
}
