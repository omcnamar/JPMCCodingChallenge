package com.olegsagenadatrytwo.jpmccodingchallenge.injection.mainactivitypresenter;

import com.olegsagenadatrytwo.jpmccodingchallenge.model.remote.Remote;
import com.olegsagenadatrytwo.jpmccodingchallenge.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityPresenterModule {

    private MainActivityPresenter mainActivityPresenter;

    public MainActivityPresenterModule(MainActivityPresenter mainActivityPresenter) {
        this.mainActivityPresenter = mainActivityPresenter;
    }

    @Provides
    Remote providesRemote(){
        return new Remote(mainActivityPresenter);
    }
}