package com.qingmei2.module_a.mvp.ui;

import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.qingmei2.module.base.BaseActivity;
import com.qingmei2.module.http.entity.UserInfo;
import com.qingmei2.module.image.GlideApp;
import com.qingmei2.module_a.R;
import com.qingmei2.module_a.databinding.ActivityHomeBinding;
import com.qingmei2.module_a.mvp.contract.HomeContract;
import com.qingmei2.module_a.mvp.presenter.HomePresenter;

import java.util.concurrent.TimeUnit;

public class HomeActivity extends BaseActivity<HomePresenter, ActivityHomeBinding> implements HomeContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        RxView.clicks(b.btnUserInfo)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(v -> presenter.requestUserInfo("qingmei2"));
    }

    @Override
    public void onGetUserInfo(UserInfo userInfo) {
        b.tvUserInfo.setText("网络请求Login:" + userInfo.toString());
        GlideApp.with(this)
                .load(userInfo.getAvatarUrl())
                .circleCrop()
                .into(b.ivTest);
    }

    @Override
    public void onError(String errorMassage) {
        Toast.makeText(this, errorMassage, Toast.LENGTH_SHORT).show();
    }

}
