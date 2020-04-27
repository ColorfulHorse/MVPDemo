package com.xh.mvparms.app.di;


import com.jess.xinghuo.di.scope.ActivityScope;
import com.xh.mvparms.app.main.MainFragmentModule;
import com.xh.mvparms.app.main.MainModule;
import com.xh.mvparms.app.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author greensun
 *
 * @date 2018/8/21
 *
 * @desc 用于注入Activity，将每个Activity的component添加到map
 * 此module用来统一管理app component 的子activity component
 */
@Module
public abstract class ActivityModule {

    /**
     * {@link ContributesAndroidInjector} 相当于创建了了一个用于注入MainActivity的AppComponent的子Component,
     * modules：此component所依赖的modules。
     * 提供activity依赖  所生成代码：build/下： ActivityModule_ForecastListActivityInjector
     * @return
     */
    @ContributesAndroidInjector(modules = {
            MainModule.class,
            MainFragmentModule.class,
    })
    @ActivityScope
    abstract MainActivity provideForecastListActivity();
}
