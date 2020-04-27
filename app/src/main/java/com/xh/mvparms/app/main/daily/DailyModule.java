package com.xh.mvparms.app.main.daily;



import com.jess.xinghuo.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DailyModule {

    @FragmentScope
    @Binds
    abstract DailyContract.View provideView(DailyFragment fragment);
}
