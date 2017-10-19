package com.olegsagenadatrytwo.jpmccodingchallenge.entitities.custom;

import com.olegsagenadatrytwo.jpmccodingchallenge.entitities.weatherInfoHourly.HourlyForecast;

import java.util.List;

public class DayData {

    private List<HourlyForecast> hourlyList;

    public DayData(List<HourlyForecast> hourlyList) {
        this.hourlyList = hourlyList;
    }

    public List<HourlyForecast> getHourlyList() {
        return hourlyList;
    }

    public void setHourlyList(List<HourlyForecast> hourlyList) {
        this.hourlyList = hourlyList;
    }
}
