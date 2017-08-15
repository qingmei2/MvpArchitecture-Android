package com.qingmei2.module.base;

import com.qingmei2.module.http.base.BaseServiceManager;

/**
 * Created by QingMei on 2017/8/14.
 * desc:
 */

public class BaseModel<S extends BaseServiceManager> implements IModel {

    /**
     * Retrofit Service Manager
     */
    protected S serviceManager;

    public BaseModel(S serviceManager) {
        this.serviceManager = serviceManager;
    }

    @Override
    public void onDestroy() {
        serviceManager = null;
    }
}
