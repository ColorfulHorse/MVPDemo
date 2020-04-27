package com.xh.mvparms.app;

import android.app.Activity;

import com.jess.xinghuo.base.delegate.BaseAppDelegate;
import com.jess.xinghuo.base.BaseApplication;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * @author greensun
 *
 * @date 2018/8/21
 *
 * @desc dagger-android application必须实现HasActivityInjector才能对activity进行管理，
 * 这里把具体操作都交由@{@link AppDelegate}，依赖也注入到了@{@link AppDelegate}
 */
public class App extends BaseApplication implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> mActivityInjector;

    private AppDelegate appDelegate;


    @Override
    public BaseAppDelegate attachAppDelegate() {
        appDelegate = new AppDelegate(getBaseContext());
        return appDelegate;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return appDelegate.activityInjector();
    }
}
