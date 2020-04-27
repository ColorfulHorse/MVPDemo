package com.xh.mvparms.app.model.bean;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by green sun on 2018/4/26.
 */
@Entity
public class Forecast {
    @Id
    public Long id;
    public Long date;
    public String desc;
    public double high;
    public double low;
    public String iconUrl;
    public ToOne<ForecastList> forecastList;

    public Forecast() {

    }
    public Forecast(Long id, Long date, String desc, double high, double low, String iconUrl) {
        this.id = id;
        this.date = date;
        this.desc = desc;
        this.high = high;
        this.low = low;
        this.iconUrl = iconUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }


    public ForecastList getForecastList() {
        return this.forecastList.getTarget();
    }

    public void setForecastList(ForecastList forecastList) {
        this.forecastList.setTarget(forecastList);
    }
}
