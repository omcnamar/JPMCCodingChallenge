package com.olegsagenadatrytwo.jpmccodingchallenge.injection.settingsactivity;


import com.olegsagenadatrytwo.jpmccodingchallenge.view.settingsactivity.SettingsActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
class SettingsActivityModule {

    @Provides
    SettingsActivityPresenter providesSettingsActivityPresenter(){
        return new SettingsActivityPresenter();
    }
}
