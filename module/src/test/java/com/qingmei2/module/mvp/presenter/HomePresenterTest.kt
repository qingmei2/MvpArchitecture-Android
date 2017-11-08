package com.qingmei2.module.mvp.presenter

import com.google.gson.Gson
import com.nhaarman.mockito_kotlin.*
import com.qingmei2.module.http.entity.UserInfo
import com.qingmei2.module.mvp.contract.HomeContract
import com.qingmei2.module.testframework.TestRxTransformer
import com.qingmei2.module.testframework.basekt.BaseTestPresenter
import com.qingmei2.module.testframework.mocks.MockAssest
import io.reactivex.Maybe
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.anyString

/**
 * Created by QingMei on 2017/11/8.
 * desc:
 */
class HomePresenterTest() : BaseTestPresenter() {

    val view: HomeContract.View = mock()

    val model: HomeContract.Model = mock()

    var presenter: HomePresenter = HomePresenter(view, model)

    @Before
    fun setUp() {
        presenter = spy(presenter)
        doReturn(TestRxTransformer<Any>()).whenever(presenter).bindViewMaybe<Any>(view)
    }

    @Test
    fun requestUserInfo_success() {

        val s = MockAssest.readFile(MockAssest.USER_DATA)
        val user = Gson().fromJson(s, UserInfo::class.java)
        whenever(model.requestUserInfo(anyString())).thenReturn(Maybe.just(user))

        //testing
        presenter.requestUserInfo("qingmei2")

        val captor: ArgumentCaptor<UserInfo> = ArgumentCaptor.forClass(UserInfo::class.java)
        verify(view).onGetUserInfo(captor.capture());
        verify(view, never()).onError(anyString());

        assert(user.equals(captor.value))
    }

    @Test
    fun requestUserInfo_failed_error() {
        val s = MockAssest.readFile(MockAssest.error)
        val user = Gson().fromJson(s, UserInfo::class.java)
        whenever(model.requestUserInfo(anyString())).thenReturn(Maybe.just(user))

        presenter.requestUserInfo("qingmei2")

        verify(view, never()).onGetUserInfo(any());
        verify(view).onError("用户信息为空");
    }
}