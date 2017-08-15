package com.qingmei2.module.http.service;

import com.qingmei2.module.http.base.BaseServiceManager;

import javax.inject.Inject;

import lombok.Getter;

/**
 * Created by Glooory on 17/5/15.
 */

public class ServiceManager implements BaseServiceManager {

    @Getter
    private UserInfoService userInfoService;


    @Inject
    public ServiceManager(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;

    }

    @Override
    public void destroy() {
        userInfoService = null;
    }

}
