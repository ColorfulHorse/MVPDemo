package com.xh.mvparms.app.main;

import com.jess.xinghuo.di.scope.ActivityScope;
import com.jess.xinghuo.integration.IRepositoryManager;
import com.jess.xinghuo.mvp.BaseModel;

import javax.inject.Inject;

/**
 * Created by xiong on 2018/7/11.
 */

@ActivityScope
public class MainModel extends BaseModel implements IMainModel  {

    @Inject
    public MainModel() {

    }
}
