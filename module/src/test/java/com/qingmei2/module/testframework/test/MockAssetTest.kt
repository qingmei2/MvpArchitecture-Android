package com.qingmei2.module.testframework.test

import com.qingmei2.module.testframework.mocks.MockAssest
import io.reactivex.Observable
import org.junit.Test

/**
 * Created by QingMei on 2017/11/7.
 * desc:
 */
class MockAssetTest {

    @Test
    fun assetTest() {
        val content = MockAssest.readFile(MockAssest.USER_DATA)
        Observable.just(content)
                .test()
                .assertValue("{\n" + "    \"login\": \"qingmei2\",\n" + "    \"name\": \"qingmei\"\n" + "}")
    }

}