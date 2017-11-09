package com.qingmei2.module.testframework.tools

import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers

/**
 * Created by QingMei on 2017/11/9.
 * desc:
 */

object RxTestTools {

    fun asyncToSync() {
        RxJavaPlugins.reset()
        RxJavaPlugins.setIoSchedulerHandler({ _ -> Schedulers.trampoline() })
    }

}
