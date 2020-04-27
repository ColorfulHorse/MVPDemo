package com.xh.mvparms.app.main.weekly;


import com.jess.xinghuo.mvp.BasePresenter;
import com.jess.xinghuo.mvp.IView;
import com.xh.mvparms.app.model.bean.Forecast;
import com.xh.mvparms.app.model.bean.ForecastList;

public interface WeeklyContract {

    interface View extends IView {
        Long getCityId();

        void showLoading(boolean show);

        void onData(ForecastList data);

        void onFailed(Throwable throwable);

        void goDetail(Forecast forecast);
    }

    interface Presenter {
        void getData();

        void goDetail(Forecast forecast);
    }

}
