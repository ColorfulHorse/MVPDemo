package com.xh.mvparms.app.model.response;

import java.util.List;

/**
 * Created by green sun on 2018/4/26.
 */

public class ListBean {
    /**
     * dt : 1524715200
     * temp : {"day":24.36,"min":22.39,"max":26.2,"night":22.39,"eve":24.93,"morn":24.36}
     * pressure : 1021.23
     * humidity : 96
     * weather : [{"id":500,"main":"Rain","description":"light rain","icon":"10d"}]
     * speed : 3.87
     * deg : 90
     * clouds : 88
     * rain : 10.3
     */

    private int dt;
    private TempBean temp;
    private double pressure;
    private int humidity;
    private double speed;
    private int deg;
    private int clouds;
    private double rain;
    private List<WeatherBean> weather;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public TempBean getTemp() {
        return temp;
    }

    public void setTemp(TempBean temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public double getRain() {
        return rain;
    }

    public void setRain(double rain) {
        this.rain = rain;
    }

    public List<WeatherBean> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherBean> weather) {
        this.weather = weather;
    }
}
