package com.xh.mvparms.app.main;

import com.jess.xinghuo.di.scope.ActivityScope;
import com.jess.xinghuo.mvp.BasePresenter;
import com.xh.mvparms.app.main.MainContract;
import com.xh.mvparms.app.main.MainModel;

import javax.inject.Inject;

/**
 * Created by xiong on 2018/7/11.
 */

@ActivityScope
public class MainPresenter extends BasePresenter<MainModel, MainContract.View> implements MainContract.Presenter{

    @Inject
    public MainPresenter() {

    }

}
