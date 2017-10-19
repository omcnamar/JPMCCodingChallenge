package com.olegsagenadatrytwo.jpmccodingchallenge.injection.settingsactivity;

import com.olegsagenadatrytwo.jpmccodingchallenge.view.settingsactivity.SettingsActivity;

import dagger.Component;

@Component(modules = SettingsActivityModule.class)
public interface SettingsActivityComponent {

    void inject(SettingsActivity settingsActivity);
}
