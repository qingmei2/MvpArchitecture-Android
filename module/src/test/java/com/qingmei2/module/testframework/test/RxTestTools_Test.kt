package com.qingmei2.module.testframework.test

import com.qingmei2.module.testframework.tools.RxTestTools
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import java.util.concurrent.TimeUnit

/**
 * Created by QingMei on 2017/11/9.
 * desc:
 */

class RxTestTools_Test {

    @Before
    fun setUp() {
        RxTestTools.asyncToSync()
    }

    @Test
    fun async2Sync() {
        Observable.just("123c")
                .delay(5, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe { System.out.print(it) }
    }
}
