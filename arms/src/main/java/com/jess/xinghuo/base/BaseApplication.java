/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jess.xinghuo.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;


import com.jess.xinghuo.base.delegate.BaseAppDelegate;
import com.jess.xinghuo.base.delegate.AppLifecycles;
import com.jess.xinghuo.di.component.BaseComponent;
import com.jess.xinghuo.utils.ArmsUtils;
import com.jess.xinghuo.utils.Preconditions;

/**
 * ================================================
 * 本框架由 MVP + Dagger2 + Retrofit + RxJava + Androideventbus + Butterknife 组成
 * ================================================
 */

public abstract class BaseApplication extends Application implements IApp {
    private AppLifecycles mAppDelegate;

    /**
     * 这里会在 {@link BaseApplication#onCreate} 之前被调用,可以做一些较早的初始化
     * 常用于 MultiDex 以及插件化框架的初始化
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        if (mAppDelegate == null)
            this.mAppDelegate = attachAppDelegate();
        this.mAppDelegate.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mAppDelegate != null)
            this.mAppDelegate.onCreate(this);
    }

    /**
     * 在模拟环境中程序终止时会被调用
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mAppDelegate != null)
            this.mAppDelegate.onTerminate(this);
    }

    /**
     * 将 {@link BaseComponent} 返回出去, 供其它地方使用, {@link BaseComponent} 接口中声明的方法所返回的实例, 在 {@link #getAppComponent()} 拿到对象后都可以直接使用
     *
     * @see ArmsUtils#obtainAppComponentFromContext(Context) 可直接获取 {@link BaseComponent}
     * @return AppComponent
     */
    @NonNull
    @Override
    public BaseComponent getAppComponent() {
        Preconditions.checkNotNull(mAppDelegate, "%s cannot be null", BaseAppDelegate.class.getName());
        Preconditions.checkState(mAppDelegate instanceof IApp, "%s must be implements %s", BaseAppDelegate.class.getName(), IApp.class.getName());
        return ((IApp) mAppDelegate).getAppComponent();
    }

    public abstract BaseAppDelegate attachAppDelegate();

}
