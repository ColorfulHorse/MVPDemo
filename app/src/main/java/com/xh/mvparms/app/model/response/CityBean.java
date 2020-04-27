package com.xh.mvparms.app.model.response;

/**
 * Created by green sun on 2018/4/26.
 */

public class CityBean {
    /**
     * id : 1795563
     * name : Shenzhen Shi
     * coord : {"lon":114.1259,"lat":22.6177}
     * country : CN
     * population : 0
     */

    private Long id;
    private String name;
    private CoordBean coord;
    private String country;
    private int population;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    public CoordBean getCoord() {
        return coord;
    }

    public void setCoord(CoordBean coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country == null ? "" : country;
    }

    public void setCountry(String country) {
        this.country = country == null ? "" : country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
