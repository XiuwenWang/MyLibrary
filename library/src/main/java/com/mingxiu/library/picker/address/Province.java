package com.mingxiu.library.picker.address;

import java.util.ArrayList;
import java.util.List;

public class Province {
    String areaId;
    String areaName;
    List<City> cities = new ArrayList();

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

}
