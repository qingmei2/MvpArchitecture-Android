package com.qingmei2.module_a.mvp.presenter

import com.google.gson.Gson
import com.nhaarman.mockito_kotlin.*
import com.qingmei2.module.http.entity.UserInfo
import com.qingmei2.module.testframework.basekt.BaseTestPresenter
import com.qingmei2.module.testframework.tools.MockAssetReader
import com.qingmei2.module.testframework.tools.RxTestTransformer
import com.qingmei2.module_a.data.MockAsset
import com.qingmei2.module_a.mvp.contract.HomeContract
import io.reactivex.Maybe
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.anyString

/**
 * Created by QingMei on 2017/11/8.
 * desc:
 */
class HomePresenterTest : BaseTestPresenter() {

    private val view: HomeContract.View = mock()

    private val model: HomeContract.Model = mock()

    private var presenter: HomePresenter = HomePresenter(view, model)

    @Before
    fun setUp() {
        presenter = spy(presenter)
        doReturn(RxTestTransformer<Any>()).whenever(presenter).bindViewMaybe<Any>(view)
    }

    @Test
    fun requestUserInfoSuccess() {
        val s = MockAssetReader.readFile(MockAsset.USER_DATA)
        val user = Gson().fromJson(s, UserInfo::class.java)
        whenever(model.requestUserInfo(anyString())).thenReturn(Maybe.just(user))

        //testing
        presenter.requestUserInfo("qingmei2")

        val captor: ArgumentCaptor<UserInfo> = ArgumentCaptor.forClass(UserInfo::class.java)
        verify(view).onGetUserInfo(captor.capture())
        verify(view, never()).onError(anyString())

        assert(user == captor.value)
    }

    @Test
    fun requestUserInfoFailedError() {
        val s = MockAssetReader.readFile(MockAsset.error)
        val user = Gson().fromJson(s, UserInfo::class.java)
        whenever(model.requestUserInfo(anyString())).thenReturn(Maybe.just(user))

        presenter.requestUserInfo("qingmei2")

        verify(view, never()).onGetUserInfo(any())
        verify(view).onError("用户信息为空")
    }
}