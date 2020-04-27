package com.xh.mvparms.app.main.test;

import com.jess.xinghuo.di.scope.FragmentScope;
import com.jess.xinghuo.mvp.BaseModel;

import javax.inject.Inject;

@FragmentScope
public class TestModel extends BaseModel implements ITestModel{
    @Inject
    public TestModel() {
    }
}
