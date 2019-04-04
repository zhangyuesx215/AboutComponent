package com.learn.library_common.base;

import android.app.Application;

public class BaseApplication extends Application {

    public static boolean IS_DEBUG=true;

    private static ApplicationComponent component=null;

    @Override
    public void onCreate() {
        super.onCreate();
        if (component==null){
            component=DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }

    }

    public static  ApplicationComponent getComponent(){

        return component;
    }
}
