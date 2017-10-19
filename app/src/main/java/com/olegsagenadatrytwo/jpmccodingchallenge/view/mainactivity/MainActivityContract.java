package com.olegsagenadatrytwo.jpmccodingchallenge.view.mainactivity;

import com.olegsagenadatrytwo.jpmccodingchallenge.BasePresenter;
import com.olegsagenadatrytwo.jpmccodingchallenge.BaseView;
import com.olegsagenadatrytwo.jpmccodingchallenge.entitities.weatherInfo.WeatherInfo;
import com.olegsagenadatrytwo.jpmccodingchallenge.entitities.weatherInfoHourly.HourlyWeatherInfo;

interface MainActivityContract {

    interface View extends BaseView {
        void weatherDownloadedUpdateUI(WeatherInfo weatherInfo);
        void hourlyWeatherDownloadedUpdateUI(HourlyWeatherInfo hourlyWeatherInfo);
    }

    interface Presenter extends BasePresenter<View> {
        void attachRemote();
        void downloadWeatherData(String zipCode);
        void downloadWeatherDataHourly(String zipCode);
    }
}
