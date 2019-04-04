package com.learn.app_login.component;

import com.learn.app_login.activity.LoginActivity;
import com.learn.app_login.module.LoginModule;
import com.learn.library_common.base.ApplicationComponent;
import com.learn.library_common.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class,modules = {LoginModule.class})
public interface LoginComponent {

    void inject(LoginActivity activity);

}
