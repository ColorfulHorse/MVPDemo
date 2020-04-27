package com.xh.mvparms.app.model.bean;


import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * Created by green sun on 2018/4/26.
 */
@Entity
public class ForecastList {
    @Id(assignable = true)
    public Long id;
    public String city;
    public String country;
    @Backlink
    public ToMany<Forecast> dailyForecast;

    public ForecastList() {
    }

    public ForecastList(Long id, String city, String country) {
        this.id = id;
        this.city = city;
        this.country = country;
    }

    public ToMany<Forecast> getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(ToMany<Forecast> dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public Forecast get(int position){
        return dailyForecast.get(position);
    }
}
