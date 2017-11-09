package com.qingmei2.module.mvp.model

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.spy
import com.nhaarman.mockito_kotlin.whenever
import com.qingmei2.module.http.entity.UserInfo
import com.qingmei2.module.http.service.UserInfoService
import com.qingmei2.module.testframework.tools.RxTestTransformer
import com.qingmei2.module.testframework.basekt.BaseTestModel
import com.qingmei2.module.testframework.tools.MockAssest
import com.qingmei2.module.testframework.tools.MockRetrofit
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.ArgumentMatchers.anyString

/**
 * Created by QingMei on 2017/11/8.
 * desc:
 */
class HomeModelTest() : BaseTestModel() {

    private val retrofit: MockRetrofit = MockRetrofit()

    private var homeModel: HomeModel = HomeModel(mock())

    @Before
    fun setUp() {

        homeModel = spy(homeModel)
        val service = retrofit.create(UserInfoService::class.java)
        whenever(homeModel.serviceManager.userInfoService).thenReturn(service)
        doReturn(RxTestTransformer<UserInfo>()).whenever(homeModel).getUserInfoCache(anyString(), anyBoolean())
    }

    @Test
    fun requestUserInfo() {
        retrofit.path = MockAssest.USER_DATA

        val maybe = homeModel.requestUserInfo("qingmei2")

        maybe.test()
                .assertValue { it ->
                    it.login == "login"
                            && it.name == "name"
                }
    }
}