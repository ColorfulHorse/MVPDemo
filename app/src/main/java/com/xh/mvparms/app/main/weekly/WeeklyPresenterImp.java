package com.xh.mvparms.app.main.weekly;

import android.annotation.SuppressLint;
import android.util.Log;


import com.jess.xinghuo.di.scope.FragmentScope;
import com.jess.xinghuo.mvp.BasePresenter;
import com.jess.xinghuo.utils.RxLifecycleUtils;
import com.xh.mvparms.app.model.bean.Forecast;

import javax.inject.Inject;

@FragmentScope
public class WeeklyPresenterImp extends BasePresenter<WeeklyModel, WeeklyContract.View> implements WeeklyContract.Presenter {

    public static final String TAG = WeeklyPresenterImp.class.getSimpleName();


    @Inject
    public WeeklyPresenterImp() {

    }

    @SuppressLint("CheckResult")
    @Override
    public void getData() {
        if (isAttached()){
            WeeklyContract.View view = getView();
            view.showLoading(true);
            mModel.getData(view.getCityId())
                    .compose(RxLifecycleUtils.bindToLifecycle(view))
                    .doOnDispose(() -> Log.e(TAG, "dispose"))
                    .subscribe(res -> {
                        Log.e(TAG, "ok");
                        if (isAttached()){
                            view.onData(res);
                        }
                    }, err -> {
                        Log.e(TAG, "fail");
                        if (isAttached()){
                            view.showLoading(false);
                            view.onFailed(err);
                        }
                    }, () -> {
                        Log.e(TAG, "complete");
                        if (isAttached()){
                            view.showLoading(false);
                        }
                    });
        }
    }


    @Override
    public void goDetail(Forecast forecast) {
        if (isAttached()){
            getView().goDetail(forecast);
        }
    }
}
