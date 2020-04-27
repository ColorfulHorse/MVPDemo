package com.xh.mvparms.app.model.response;

import java.util.List;

/**
 * Created by green sun on 2018/4/25.
 */

public class ForecastResult {

    /**
     * city : {"id":1795563,"name":"Shenzhen Shi","coord":{"lon":114.1259,"lat":22.6177},"country":"CN","population":0}
     * cod : 200
     * message : 2.8933088
     * cnt : 7
     * list : [{"dt":1524715200,"temp":{"day":24.36,"min":22.39,"max":26.2,"night":22.39,"eve":24.93,"morn":24.36},"pressure":1021.23,"humidity":96,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":3.87,"deg":90,"clouds":88},{"dt":1524801600,"temp":{"day":23.51,"min":21.51,"max":24.73,"night":21.53,"eve":23.9,"morn":21.51},"pressure":1022.06,"humidity":100,"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"speed":2.71,"deg":98,"clouds":92,"rain":10.3},{"dt":1524888000,"temp":{"day":22.85,"min":21.08,"max":24.51,"night":22.15,"eve":24.51,"morn":21.08},"pressure":1023.05,"humidity":100,"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"speed":3.03,"deg":81,"clouds":92,"rain":4.11},{"dt":1524974400,"temp":{"day":25.62,"min":22.13,"max":25.62,"night":22.13,"eve":23.1,"morn":23.43},"pressure":1016.15,"humidity":0,"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"speed":3.59,"deg":147,"clouds":76,"rain":3.55},{"dt":1525060800,"temp":{"day":27.33,"min":21.25,"max":27.33,"night":21.25,"eve":23.89,"morn":23.39},"pressure":1013.15,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":3.35,"deg":159,"clouds":62,"rain":2.64},{"dt":1525147200,"temp":{"day":24.81,"min":21.95,"max":24.81,"night":21.95,"eve":23.35,"morn":23.39},"pressure":1013.04,"humidity":0,"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10d"}],"speed":2.61,"deg":166,"clouds":55,"rain":21.89},{"dt":1525233600,"temp":{"day":27.23,"min":22.21,"max":27.23,"night":22.21,"eve":24.34,"morn":24.35},"pressure":1012.81,"humidity":0,"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"speed":2.93,"deg":193,"clouds":11,"rain":6.39}]
     */

    private CityBean city;
    private String cod;
    private double message;
    private int cnt;
    private List<ListBean> list;

    public CityBean getCity() {
        return city;
    }

    public void setCity(CityBean city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }
}
