package com.xh.mvparms.app.network;


import com.xh.mvparms.app.model.response.ForecastResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by green sun on 2018/4/16.
 */

public interface ApiService {

    String BASE_URL = "http://api.openweathermap.org/data/";
    String API_KEY = "15646a06818f61f7b8d7823ca833e1ce";
    String SUB_URL = String.format("2.5/forecast/daily?mode=json&units=metric&cnt=7&APPID=%s",API_KEY);
    Long DEFAULT_ID = 1795563L;

    @GET
    Observable<ForecastResult> getForecast(@Url String url, @Query("id") Long cityId);
}
