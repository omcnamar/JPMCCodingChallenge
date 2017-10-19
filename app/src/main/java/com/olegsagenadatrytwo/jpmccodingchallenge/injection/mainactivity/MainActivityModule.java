package com.olegsagenadatrytwo.jpmccodingchallenge.injection.mainactivity;

import com.olegsagenadatrytwo.jpmccodingchallenge.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
class MainActivityModule {

    @Provides
    MainActivityPresenter providesMainActivityPresenter() {
        return new MainActivityPresenter();
    }

}