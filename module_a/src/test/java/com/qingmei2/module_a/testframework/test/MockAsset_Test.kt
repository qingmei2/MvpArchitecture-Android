package com.qingmei2.module.testframework.test

import com.qingmei2.module.testframework.tools.MockAssetReader
import io.reactivex.Observable
import org.junit.Test

/**
 * Created by QingMei on 2017/11/7.
 * desc:
 */
class MockAsset_Test {

    @Test
    fun assetTest() {
        val content = MockAssetReader.readFile(MockAssetReader.USER_DATA)
        Observable.just(content)
                .test()
                .assertValue("{\n" + "    \"login\": \"login\",\n" + "    \"name\": \"name\"\n" + "}")
    }

}