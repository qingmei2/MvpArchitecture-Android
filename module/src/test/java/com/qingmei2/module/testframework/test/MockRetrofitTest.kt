package com.qingmei2.module.testframework.test

import com.qingmei2.module.testframework.mocks.MockAssest
import com.qingmei2.module.testframework.mocks.MockRetrofit
import org.junit.Test

/**
 * Created by QingMei on 2017/11/7.
 * desc:
 */
class MockRetrofitTest {

    @Test
    fun mockRetrofitTest() {
        val retrofit = MockRetrofit()
        val service = retrofit.create(TestService::class.java)
        retrofit.path = MockAssest.USER_DATA

        service.getUser("test")
                .test()
                .assertValue { it ->
                    it.login.equals("qingmei2")
                    it.name.equals("qingmei")
                }
    }
}