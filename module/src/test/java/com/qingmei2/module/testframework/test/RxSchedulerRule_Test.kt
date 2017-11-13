package com.qingmei2.module.testframework.test

import com.qingmei2.module.testframework.tools.RxSchedulerRule
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit


/**
 * Created by QingMei on 2017/11/9.
 * desc:
 */

class RxSchedulerRule_Test {

    @Rule
    @JvmField
    val rxRule = RxSchedulerRule()

    @Test
    fun testAdvanceTo_noComplete() {
        val observer = startRangeLoopThread()

        //将时间轴跳到第5秒，模拟执行发生的事件
        rxRule.advanceTimeTo(5, TimeUnit.SECONDS)

        assertNoComplete(observer)
    }

    @Test
    fun testAdvanceTo_complete() {
        val observer = startRangeLoopThread()

        //将时间轴跳到第5秒，模拟执行发生的事件
        rxRule.advanceTimeTo(5, TimeUnit.SECONDS)
        rxRule.advanceTimeTo(10, TimeUnit.SECONDS)

        assertComplete(observer)
    }

    @Test
    fun testAdvanceBy_noComplete() {
        val observer = startRangeLoopThread()

        //将时间轴提前5秒，模拟执行发生的事件
        rxRule.advanceTimeBy(5, TimeUnit.SECONDS)

        assertNoComplete(observer)
    }

    @Test
    fun testAdvanceBy_complete() {
        val observer = startRangeLoopThread()

        rxRule.advanceTimeBy(4, TimeUnit.SECONDS)
        rxRule.advanceTimeBy(5, TimeUnit.SECONDS)

        assertComplete(observer)
    }

    private fun startRangeLoopThread(): TestObserver<Long> {
        val observer = TestObserver<Long>()
        val observable = getThread()
        observable.subscribe(observer)
        return observer
    }

    //开启一个子线程，每隔一秒发送一个数据，共发射10次,结果 0~9
    private fun getThread(): Observable<Long> {
        return Observable.intervalRange(0, 10, 0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
    }

    private fun assertComplete(observer: TestObserver<Long>) {
        observer.assertValueCount(10)
                .assertComplete()
                .assertNoErrors()
                .assertValueAt(0, 0)
                .assertValueAt(9, 9)
    }

    private fun assertNoComplete(observer: TestObserver<Long>){
        observer.assertValueCount(6)
                .assertNotComplete()
                .assertNoErrors()
                .assertValueAt(0, 0)
                .assertValueAt(5, 5)
    }
}
