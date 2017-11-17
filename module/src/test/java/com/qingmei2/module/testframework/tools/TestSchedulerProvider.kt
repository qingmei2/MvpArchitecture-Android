package com.qingmei2.module.testframework.tools

import com.qingmei2.module.di.module.sheduler.SchedulerProvider
import io.reactivex.schedulers.Schedulers

/**
 * Created by QingMei on 2017/11/13.
 * desc:
 */
class TestSchedulerProvider : SchedulerProvider {

    override fun io() = Schedulers.io()

    override fun ui() = Schedulers.io()
}