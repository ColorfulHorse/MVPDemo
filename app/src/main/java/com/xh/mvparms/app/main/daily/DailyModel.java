package com.xh.mvparms.app.main.daily;



import com.jess.xinghuo.di.scope.FragmentScope;
import com.jess.xinghuo.mvp.BaseModel;

import javax.inject.Inject;

@FragmentScope
public class DailyModel extends BaseModel implements IDailyModel {

    @Inject
    public DailyModel() {

    }
}
