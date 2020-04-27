package com.xh.mvparms.app.main;

import com.jess.xinghuo.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;

/**
 * Created by xiong on 2018/7/11.
 */

@Module
public abstract class MainModule {

    @ActivityScope
    @Binds
    abstract MainContract.View provideMainView(MainActivity activity);
}
