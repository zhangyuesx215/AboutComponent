package com.learn.app_main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.library_common.arouter.RouterPath;
import com.learn.library_common.base.BaseActivity;

@Route(path = RouterPath.MAINACTIVITY)
public class MainActivity extends BaseActivity {

    //public String TAG=MainActivity.class.getSimpleName();

    @Override
    public int getContentView() {
        return R.layout.main_main_activity;
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

    }
}
