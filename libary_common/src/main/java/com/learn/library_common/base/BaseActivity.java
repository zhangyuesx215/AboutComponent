package com.learn.library_common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.learn.library_common.utils.L;


public abstract class BaseActivity<T extends BasePresent> extends AppCompatActivity {

    public String TAG=getClass().getSimpleName();

    protected T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        ARouter.getInstance().inject(this);
        setContentView(getContentView());
        if (mPresenter != null){
            mPresenter.subscribe();
        }
        initView();
        initListener();
        initData();
        L.e(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        L.e(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        L.e(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        L.e(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        L.e(TAG,"onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        L.e(TAG,"onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.unSubscribe();
        }
        L.e(TAG,"onDestroy");
    }

    /**
     * 返回一个用于显示界面的布局id
     * @return          视图id
     */
    public abstract int getContentView();

    /** 初始化View的代码写在这个方法中 */
    public abstract void initView();

    /** 初始化监听器的代码写在这个方法中 */
    public abstract void initListener();

    /** 初始数据的代码写在这个方法中，用于从服务器获取数据 */
    public abstract void initData();

    public abstract  void initializeInjector();


}
