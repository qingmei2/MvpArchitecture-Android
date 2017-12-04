package com.qingmei2.module.testframework.test

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by QingMei on 2017/11/7.
 * desc:
 */
interface TestService {

    @GET("/test/api")
    fun getUser(@Query("login") login: String): Observable<User>
}