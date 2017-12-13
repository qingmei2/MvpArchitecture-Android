package com.qingmei2.mvparchitecture.mvp.ui;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jakewharton.rxbinding2.view.RxView;
import com.qingmei2.module.base.BaseActivity;
import com.qingmei2.module_business.model.UserModel;
import com.qingmei2.module_business.router.RouterConstants;
import com.qingmei2.mvparchitecture.R;
import com.qingmei2.mvparchitecture.databinding.AppActivityMainBinding;
import com.qingmei2.mvparchitecture.mvp.contract.MainContract;
import com.qingmei2.mvparchitecture.mvp.presenter.MainPresenter;

import java.util.concurrent.TimeUnit;

/**
 * Created by QingMei on 2017/12/5.
 * desc:
 */
public class MainActivity extends BaseActivity<MainPresenter, AppActivityMainBinding> implements MainContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.app_activity_main;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        RxView.clicks(b.btnJump)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(v -> ARouter.getInstance()
                        .build(RouterConstants.ModuleA.ACTIVITY_HOME)
                        .withObject("user", new UserModel("qingmei2", "123456"))
                        .navigation());
    }
}
