package com.xh.mvparms.app.main.weekly;


import com.jess.xinghuo.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class WeeklyModule {

    @FragmentScope
    @Binds
    abstract WeeklyContract.View provideView(WeeklyFragment fragment);
}
