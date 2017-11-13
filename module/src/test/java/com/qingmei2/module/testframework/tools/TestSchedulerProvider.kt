package com.qingmei2.module.testframework.tools

import com.qingmei2.module.di.module.sheduler.SchedulerProvider
import io.reactivex.schedulers.TestScheduler

/**
 * Created by QingMei on 2017/11/13.
 * desc:
 */
class TestSchedulerProvider : SchedulerProvider {

    val testScheduler: TestScheduler = TestScheduler()

    override fun io() = testScheduler

    override fun ui() = testScheduler
}