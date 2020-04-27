package com.xh.mvparms.app.main;



import com.jess.xinghuo.di.scope.FragmentScope;
import com.xh.mvparms.app.di.ActivityModule;
import com.xh.mvparms.app.main.daily.DailyFragment;
import com.xh.mvparms.app.main.daily.DailyModule;
import com.xh.mvparms.app.main.monthly.MonthlyFragment;
import com.xh.mvparms.app.main.monthly.MonthlyModule;
import com.xh.mvparms.app.main.test.TestFragment;
import com.xh.mvparms.app.main.test.TestModule;
import com.xh.mvparms.app.main.weekly.WeeklyFragment;
import com.xh.mvparms.app.main.weekly.WeeklyModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author greensun
 *
 * @date 2018/8/21
 *
 * @desc 作用等同@{@link ActivityModule}，用于Activity Component管理其下fragments component
 */
@Module
public abstract class MainFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = DailyModule.class)
    abstract DailyFragment provideDailyFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = WeeklyModule.class)
    abstract WeeklyFragment provideWeeklyFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = MonthlyModule.class)
    abstract MonthlyFragment provideMonthlyFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = TestModule.class)
    abstract TestFragment provideTestFragment();
}
