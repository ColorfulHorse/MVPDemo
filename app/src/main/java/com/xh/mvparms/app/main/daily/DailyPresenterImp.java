package com.xh.mvparms.app.main.daily;

import com.jess.xinghuo.di.scope.FragmentScope;
import com.jess.xinghuo.mvp.BasePresenter;

import javax.inject.Inject;

@FragmentScope
public class DailyPresenterImp extends BasePresenter<DailyModel, DailyContract.View> implements DailyContract.Presenter {

    @Inject
    public DailyPresenterImp() {
    }
}
