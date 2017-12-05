package com.qingmei2.module.testframework.test

import com.qingmei2.module.testframework.tools.MockAssetReader
import com.qingmei2.module.testframework.tools.MockRetrofit
import org.junit.Test

/**
 * Created by QingMei on 2017/11/7.
 * desc:
 */
class MockRetrofit_Test {

    @Test
    fun mockRetrofitTest() {
        val retrofit = MockRetrofit()
        val service = retrofit.create(TestService::class.java)
        retrofit.path = MockAssetReader.USER_DATA

        service.getUser("test")
                .test()
                .assertValue { it ->
                    it.login.equals("login")
                            && it.name.equals("name")
                }
    }
}