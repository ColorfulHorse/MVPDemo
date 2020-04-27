package com.xh.mvparms.app.main.test;

import com.jess.xinghuo.base.BaseFragment;
import com.jess.xinghuo.di.scope.FragmentScope;
import com.jess.xinghuo.mvp.BasePresenter;

import javax.inject.Inject;

@FragmentScope
public class TestPresenterImp extends BasePresenter<TestModel, TestContract.View> implements TestContract.Presenter{

    @Inject
    public TestPresenterImp() {
    }
}
