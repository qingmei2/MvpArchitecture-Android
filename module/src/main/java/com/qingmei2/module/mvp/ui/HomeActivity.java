package com.qingmei2.module.mvp.ui;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.qingmei2.module.R;
import com.qingmei2.module.R2;
import com.qingmei2.module.base.BaseActivity;
import com.qingmei2.module.mvp.contract.HomeContract;
import com.qingmei2.module.mvp.presenter.HomePresenter;

import butterknife.BindView;

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    @BindView(R2.id.tv_user_info)
    TextView tvUserInfo;
    @BindView(R2.id.btn_user_info)
    Button btnUserInfo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        RxView.clicks(btnUserInfo)
                .subscribe(v -> presenter.requestUserInfo("qingmei2"));
    }

    @Override
    public void onGetUserInfo(String loginName) {
        tvUserInfo.setText("网络请求Login:" + loginName);
    }

    @Override
    public void onError(String errorMassage) {
        Toast.makeText(this, errorMassage, Toast.LENGTH_SHORT).show();
    }
}
