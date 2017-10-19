package com.olegsagenadatrytwo.jpmccodingchallenge.model.remote;

import com.olegsagenadatrytwo.jpmccodingchallenge.entitities.weatherInfo.WeatherInfo;
import com.olegsagenadatrytwo.jpmccodingchallenge.entitities.weatherInfoHourly.HourlyWeatherInfo;

public class Remote {

    private IRemote iremote;

    public Remote(IRemote iremote){
        this.iremote = iremote;
    }

    /**
     *  method that will make a rest call for weather data and talk back to caller
     */
    public void getWeather(String query){
        retrofit2.Call<WeatherInfo> weatherDataCall = RetrofitHelper.getWeatherCall(query);
        weatherDataCall.enqueue(new retrofit2.Callback<WeatherInfo>() {
            @Override
            public void onResponse(retrofit2.Call<WeatherInfo> call, retrofit2.Response<WeatherInfo> response) {
                WeatherInfo weatherInfo = response.body();
                iremote.sendWeather(weatherInfo);
            }

            @Override
            public void onFailure(retrofit2.Call<WeatherInfo> call, Throwable t) {
                iremote.sendWeather(null);
            }
        });
    }

    /**
     *  method that will make a rest call for weather data and talk back to caller
     */
    public void getWeatherDays(String query){
        retrofit2.Call<HourlyWeatherInfo> weatherDataCall = RetrofitHelper.getWeatherCallDays(query);
        weatherDataCall.enqueue(new retrofit2.Callback<HourlyWeatherInfo>() {
            @Override
            public void onResponse(retrofit2.Call<HourlyWeatherInfo> call, retrofit2.Response<HourlyWeatherInfo> response) {
                HourlyWeatherInfo hourlyWeatherInfo = response.body();
                iremote.sendWeatherHourly(hourlyWeatherInfo);
            }

            @Override
            public void onFailure(retrofit2.Call<HourlyWeatherInfo> call, Throwable t) {
                iremote.sendWeather(null);
            }
        });
    }

}
