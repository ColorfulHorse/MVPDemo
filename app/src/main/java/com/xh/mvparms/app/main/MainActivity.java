package com.xh.mvparms.app.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jess.xinghuo.base.AdapterViewPager;
import com.jess.xinghuo.base.BaseActivity;
import com.jess.xinghuo.integration.AppManager;
import com.xh.mvparms.R;
import com.xh.mvparms.app.base.BaseLazyFragment;
import com.xh.mvparms.app.main.daily.DailyFragment;
import com.xh.mvparms.app.main.monthly.MonthlyFragment;
import com.xh.mvparms.app.main.weekly.WeeklyFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * @author greensun
 *
 * @date 2018/8/21
 *
 * @desc activity有fragment时需要实现@{@link HasSupportFragmentInjector}
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    AppManager appManager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private AdapterViewPager mAdapter;
    private List<BaseLazyFragment> fragments = new ArrayList<>();

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        String[] tabs = getResources().getStringArray(R.array.tabs);
        fragments.add(DailyFragment.newInstance());
        fragments.add(WeeklyFragment.newInstance());
        fragments.add(MonthlyFragment.newInstance());
        mAdapter = new AdapterViewPager(getSupportFragmentManager(), fragments, tabs);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
