package com.xh.mvparms.app.network;

import com.xh.mvparms.app.model.response.ForecastResult;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.LifeCache;

/**
 * @author greensun
 *
 * @date 2018/8/21
 *
 * @desc 用于RxCache的service
 */
public interface ApiCacheProvider {
    String FORECAST_KEY = "KEY_FOREACST";

    /**
     *
     * @param result 这是个Observable类型的对象，简单来说，这就是你将要缓存的数据对象。
     * @param key    DynamicKey类型，顾名思义，就是一个动态的key，我们以它作为tag，将数据存储到对应名字的File中
     * @param clear 可以明确地清理指定的数据 ，很简单，如果我们该参数传入为true，那么RxCache就会驱逐对应的缓存数据直接进行网络的新一次请求（即使缓存没有过期）。
     *              果传入为false，说明不驱逐缓存数据，如果缓存数据没有过期，那么就不请求网络，直接读取缓存数据返回。
     * @return
     */
    @LifeCache(duration = 3, timeUnit = TimeUnit.MINUTES)
    Observable<ForecastResult> getForecast(Observable<ForecastResult> result, DynamicKey key, EvictDynamicKey clear);
}
