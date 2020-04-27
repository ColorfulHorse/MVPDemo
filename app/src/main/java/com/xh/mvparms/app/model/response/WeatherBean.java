package com.xh.mvparms.app.model.response;

/**
 * Created by green sun on 2018/4/26.
 */

public class WeatherBean {
    /**
     * id : 500
     * main : Rain
     * description : light rain
     * icon : 10d
     */

    private int id;
    private String main;
    private String description;
    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
