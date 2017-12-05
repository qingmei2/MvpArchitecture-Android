package com.qingmei2.mvparchitecture.mvp.model;

import com.qingmei2.module.base.BaseModel;
import com.qingmei2.module.http.service.ServiceManager;
import com.qingmei2.mvparchitecture.mvp.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by QingMei on 2017/12/5.
 * desc:
 */
public class MainModel extends BaseModel<ServiceManager> implements MainContract.Model {

    @Inject
    public MainModel(ServiceManager serviceManager) {
        super(serviceManager);
    }
}
