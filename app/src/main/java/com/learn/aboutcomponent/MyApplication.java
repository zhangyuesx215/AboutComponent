package com.learn.aboutcomponent;

import com.learn.library_common.base.BaseApplication;
import com.learn.library_common.utils.L;

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        L.e("MYAPPLICATION");
    }
}
