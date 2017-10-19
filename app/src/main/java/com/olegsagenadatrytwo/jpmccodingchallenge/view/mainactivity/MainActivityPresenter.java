package com.olegsagenadatrytwo.jpmccodingchallenge.view.mainactivity;

import com.olegsagenadatrytwo.jpmccodingchallenge.entitities.weatherInfo.WeatherInfo;
import com.olegsagenadatrytwo.jpmccodingchallenge.entitities.weatherInfoHourly.HourlyWeatherInfo;
import com.olegsagenadatrytwo.jpmccodingchallenge.injection.mainactivitypresenter.DaggerMainActivityPresenterComponent;
import com.olegsagenadatrytwo.jpmccodingchallenge.injection.mainactivitypresenter.MainActivityPresenterModule;
import com.olegsagenadatrytwo.jpmccodingchallenge.model.remote.IRemote;
import com.olegsagenadatrytwo.jpmccodingchallenge.model.remote.Remote;

import javax.inject.Inject;

public class MainActivityPresenter implements MainActivityContract.Presenter, IRemote {

    private MainActivityContract.View view;
    @Inject
    Remote remote;

    /**
     * attachView will initialize the MainActivityContract View interface to communicate to activity
     */
    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    /**
     * attachRemote will initialize Remote, so Remote can communicate back
     */
    @Override
    public void attachRemote() {
        DaggerMainActivityPresenterComponent
                .builder()
                .mainActivityPresenterModule(new MainActivityPresenterModule(this))
                .build()
                .insert(this);
    }

    /**
     * method that downloads data from weather channel
     */
    @Override
    public void downloadWeatherData(String zipCode) {

        //make request to get the data
        remote.getWeather(zipCode);
    }

    /**
     * method that downloads data from weather channel
     */
    @Override
    public void downloadWeatherDataHourly(String zipCode) {
        //make request to get the data
        remote.getWeatherDays(zipCode);
    }

    /**
     *  this method is called from inside Remote to let us know weather was downloaded
     */
    @Override
    public void sendWeather(WeatherInfo weatherInfo) {
        //let activity know to update UI
        view.weatherDownloadedUpdateUI(weatherInfo);
    }

    /**
     *  this method is called from inside Remote to let us know weather was downloaded
     */
    @Override
    public void sendWeatherHourly(HourlyWeatherInfo hourlyWeatherInfo) {
        //let activity know to update UI
        view.hourlyWeatherDownloadedUpdateUI(hourlyWeatherInfo);
    }
}
