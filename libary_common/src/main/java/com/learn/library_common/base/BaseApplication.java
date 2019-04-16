package com.learn.library_common.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.learn.library_common.view.Gloading;
import com.learn.library_common.view.GlobalAdapter;

public class BaseApplication extends Application {

    public static boolean IS_DEBUG=true;

    private static ApplicationComponent component=null;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        //打印日志
        ARouter.openLog();
        //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！
        //线上版本需要关闭,否则有安全风险)
        ARouter.openDebug();
        ARouter.init(this);
        //加载动画
        Gloading.initDefault(new GlobalAdapter());

    }

    private void initializeInjector(){
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
