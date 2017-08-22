package com.qingmei2.module.http.service;

import com.qingmei2.module.http.entity.UserInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by QingMei on 2017/8/15.
 * desc:
 */

public interface UserInfoService {

    @GET("users/{user}")
    Observable<UserInfo> getUserInfo(@Path("user") String user);

}
