package com.qingmei2.mvparchitecture;

import android.widget.Button;
import android.widget.TextView;

import com.qingmei2.module.base.BaseActivity;
import com.qingmei2.module.base.di.component.AppComponent;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.btn_user_info)
    Button btnUserInfo;
    @BindView(R.id.tv_user_info)
    TextView tvUserInfo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @OnClick(R.id.btn_user_info)
    public void onViewClicked() {

    }
}
