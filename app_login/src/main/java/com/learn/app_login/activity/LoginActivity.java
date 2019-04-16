package com.learn.app_login.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.app_login.R;
import com.learn.app_login.component.DaggerLoginComponent;
import com.learn.app_login.presenter.LoginPresent;
import com.learn.libary_core.arouter.RouterPath;
import com.learn.library_common.base.BaseActivity;
import com.learn.library_common.base.BaseApplication;
import com.learn.library_common.utils.L;

import javax.inject.Inject;

@Route(path = RouterPath.LOGINACTIVITY)
public class LoginActivity extends BaseActivity<LoginPresent> {

    @Inject
    LoginPresent present;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLoading();
        L.e(present.TAG);
    }

    @Override
    public int getContentView() {
        return R.layout.layout;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initializeInjector() {
        DaggerLoginComponent.builder().applicationComponent(BaseApplication.getComponent())
                .build().inject(this);
    }
}
