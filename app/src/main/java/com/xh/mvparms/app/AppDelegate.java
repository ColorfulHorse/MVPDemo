package com.xh.mvparms.app;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.jess.xinghuo.base.delegate.BaseAppDelegate;
import com.jess.xinghuo.di.component.BaseComponent;
import com.xh.mvparms.app.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


/**
 * @author greensun
 *
 * @date 2018/8/21
 *
 * @desc 实现HasActivityInjector接口用于管理activity
 */
public class AppDelegate extends BaseAppDelegate implements HasActivityInjector{
    @Inject
    DispatchingAndroidInjector<Activity> mActivityInjector;


    public AppDelegate(@NonNull Context context) {
        super(context);
    }


    @Override
    public void bindSubComponent(BaseComponent baseComponent) {

        DaggerAppComponent.builder()
                .baseComponent(baseComponent)
                .build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mActivityInjector;
    }
}
