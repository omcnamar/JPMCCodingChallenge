package com.olegsagenadatrytwo.jpmccodingchallenge.model.remote;

import com.olegsagenadatrytwo.jpmccodingchallenge.entitities.weatherInfo.WeatherInfo;
import com.olegsagenadatrytwo.jpmccodingchallenge.entitities.weatherInfoHourly.HourlyWeatherInfo;

public interface IRemote {
    void sendWeather(WeatherInfo weatherInfo);
    void sendWeatherHourly(HourlyWeatherInfo hourlyWeatherInfo);
}
