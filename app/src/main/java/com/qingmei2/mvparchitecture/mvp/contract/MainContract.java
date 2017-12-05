package com.qingmei2.mvparchitecture.mvp.contract;

import com.qingmei2.module.base.IModel;
import com.qingmei2.module.base.IPresenter;
import com.qingmei2.module.base.IView;

/**
 * Created by QingMei on 2017/12/5.
 * desc:
 */

public interface MainContract {

    interface View extends IView {
    }

    interface Presenter extends IPresenter {
    }

    interface Model extends IModel {
    }
}
