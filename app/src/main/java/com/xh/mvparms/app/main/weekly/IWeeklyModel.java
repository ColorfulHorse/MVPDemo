package com.xh.mvparms.app.main.weekly;


import com.jess.xinghuo.mvp.IModel;
import com.xh.mvparms.app.model.bean.ForecastList;

import io.reactivex.Observable;

public interface IWeeklyModel {
    Observable<ForecastList> getData(Long cityId);
}
