package com.xh.mvparms.app.main.test;

import com.jess.xinghuo.di.scope.FragmentScope;
import com.xh.mvparms.app.main.monthly.MonthlyContract;
import com.xh.mvparms.app.main.monthly.MonthlyFragment;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TestModule {

    @FragmentScope
    @Binds
    abstract TestContract.View provideView(TestFragment fragment);
}
