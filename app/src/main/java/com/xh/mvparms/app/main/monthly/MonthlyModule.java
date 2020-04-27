package com.xh.mvparms.app.main.monthly;


import com.jess.xinghuo.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MonthlyModule {

    @FragmentScope
    @Binds
    abstract MonthlyContract.View provideView(MonthlyFragment fragment);
}
