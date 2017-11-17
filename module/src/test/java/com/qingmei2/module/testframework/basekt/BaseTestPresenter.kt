package com.qingmei2.module.testframework.basekt

import com.qingmei2.module.testframework.tools.RxSchedulerRule
import org.junit.Rule

/**
 * Created by QingMei on 2017/11/8.
 * desc:
 */
open class BaseTestPresenter {
    @Rule
    @JvmField
    val rxRule = RxSchedulerRule()
}