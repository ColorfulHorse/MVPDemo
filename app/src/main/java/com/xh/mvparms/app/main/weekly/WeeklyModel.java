package com.xh.mvparms.app.main.weekly;



import com.jess.xinghuo.di.scope.FragmentScope;
import com.jess.xinghuo.mvp.BaseModel;
import com.xh.mvparms.app.model.bean.Forecast;
import com.xh.mvparms.app.model.bean.ForecastList;
import com.xh.mvparms.app.model.response.ForecastResult;
import com.xh.mvparms.app.model.response.ListBean;
import com.xh.mvparms.app.network.ApiCacheProvider;
import com.xh.mvparms.app.network.ApiService;
import com.xh.mvparms.app.utils.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;

@FragmentScope
public class WeeklyModel extends BaseModel implements IWeeklyModel {

    public BoxStore mBoxStore;

    private Box<ForecastList> box;

    @Inject
    public WeeklyModel(BoxStore mBoxStore) {
        this.mBoxStore = mBoxStore;
        box = mBoxStore.boxFor(ForecastList.class);
    }

    @Override
    public Observable<ForecastList> getData(Long cityId) {
        ApiService apiService = mRepositoryManager.obtainRetrofitService(ApiService.class);
        ApiCacheProvider cacheProvider = mRepositoryManager.obtainCacheService(ApiCacheProvider.class);
        AtomicBoolean fromNet = new AtomicBoolean(false);

        Observable<ForecastResult> sourceService = apiService.getForecast(ApiService.SUB_URL, cityId)
                .doOnNext(x -> fromNet.set(true));
        // 使用RxCache
        Observable<ForecastList> cacheOb = cacheProvider.getForecast(sourceService, new DynamicKey(ApiCacheProvider.FORECAST_KEY), new EvictDynamicKey(false))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(err ->
                        Logger.e("doOnError", err.toString())
                )
                .map(this::ForecastResultToModel)
                .doOnNext(res -> {
                    if (fromNet.get()) {
                        box.put(res);
                    }
                });

       /* Observable<ForecastList> obDb = Observable.<ForecastList>create(emitter -> {
            ForecastList res = box.query().equal(ForecastList_.id, cityId).build().findUnique();
            if (res!=null){
                emitter.onNext(res);
            }

            Logger.e("onNext", "db");
            emitter.onComplete();
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());*/

        return  cacheOb
                .filter(res -> res != null && !res.getDailyForecast().isEmpty());
        /*Observable.concatDelayError(Arrays.asList(obServer, obDb))
                .firstElement()
                .toObservable();*/
    }



    private ForecastList ForecastResultToModel(ForecastResult res) {
        List<Forecast> list = new ArrayList<>();
        Forecast forecast;
        for (ListBean bean : res.getList()) {
            String iconUrl = String.format("http://openweathermap.org/img/w/%s.png", bean.getWeather().get(0).getIcon());
            forecast = new Forecast(0L, bean.getDt()*1000L, bean.getWeather().get(0).getDescription(), bean.getTemp().getMax(), bean.getTemp().getMin(), iconUrl);
            list.add(forecast);
        }
        ForecastList forecastList = new ForecastList(res.getCity().getId(), res.getCity().getName(), res.getCity().getCountry());
        box.removeAll();
        box.attach(forecastList);
        forecastList.getDailyForecast().addAll(list);
        return forecastList;
    }

}
