package com.qingmei2.module.testframework.basekt

import com.qingmei2.module.testframework.tools.RxSchedulerRule
import org.junit.Rule

/**
 * Created by QingMei on 2017/11/8.
 * desc:
 */
open class BaseTestModel {

    @Rule
    @JvmField
    val rxRule = RxSchedulerRule()

    internal fun triggerActions() {
        rxRule.getScheduler().triggerActions()
    }

}