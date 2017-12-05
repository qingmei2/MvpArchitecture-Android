package com.qingmei2.module_a.mvp.model

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.spy
import com.nhaarman.mockito_kotlin.whenever
import com.qingmei2.module.http.entity.UserInfo
import com.qingmei2.module.http.service.UserInfoService
import com.qingmei2.module.testframework.basekt.BaseTestModel
import com.qingmei2.module.testframework.tools.MockRetrofit
import com.qingmei2.module.testframework.tools.RxTestTransformer
import com.qingmei2.module.testframework.tools.TestSchedulerProvider
import com.qingmei2.module_a.data.MockAsset
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.ArgumentMatchers.anyString


/**
 * Created by QingMei on 2017/11/8.
 * desc:
 */
class HomeModelTest : BaseTestModel() {

    private var retrofit: MockRetrofit = MockRetrofit()

    private var homeModel: HomeModel = HomeModel(mock())

    private val provider = TestSchedulerProvider()

    @Before
    fun setUp() {
        homeModel.schedulers = provider
        homeModel = spy(homeModel)

        val service = retrofit.create(UserInfoService::class.java)
        whenever(homeModel.serviceManager.userInfoService).thenReturn(service)
    }

    @Test
    fun requestUserInfo() {
        val testObserver = TestObserver<UserInfo>()
        retrofit.path = MockAsset.USER_DATA
        doReturn(RxTestTransformer<UserInfo>()).whenever(homeModel).getUserInfoCache(anyString(), anyBoolean())

        val maybe = homeModel.requestUserInfo("qingmei2")
        maybe.subscribe(testObserver)

        triggerActions()

        testObserver.assertValue { it -> it.login == "login" && it.name == "name" }
    }
}