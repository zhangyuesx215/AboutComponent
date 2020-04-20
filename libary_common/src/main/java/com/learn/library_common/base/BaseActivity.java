package com.learn.library_common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.learn.library_common.utils.L;
import com.learn.library_common.view.Gloading;



public abstract class BaseActivity<T extends BasePresent> extends AppCompatActivity {

    public String TAG=getClass().getSimpleName();
    protected T mPresenter;
    /**
     * 加载动画
     */
    protected Gloading.Holder mHolder;


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

    /**
     * make a Gloading.Holder wrap with current activity by default
     * override this method in subclass to do special initialization
     */
    protected void initLoadingStatusViewIfNeed(View view) {
        if (mHolder == null) {
            //bind status view to activity root view by default
            mHolder = Gloading.getDefault().wrap(view).withRetry(new Runnable() {
                @Override
                public void run() {
                    onLoadRetry();
                }
            });
        }
    }
    protected void onLoadRetry() {
        // override this method in subclass to do retry task

    }
    public void showLoading(View view) {
        initLoadingStatusViewIfNeed(view);
        mHolder.showLoading();
    }

    public void showLoadSuccess(View view) {
        initLoadingStatusViewIfNeed(view);
        mHolder.showLoadSuccess();
    }

    public void showLoadFailed(View view) {
        initLoadingStatusViewIfNeed(view);
        mHolder.showLoadFailed();
    }

    public void showEmpty(View view) {
        initLoadingStatusViewIfNeed(view);
        mHolder.showEmpty();
    }
}
