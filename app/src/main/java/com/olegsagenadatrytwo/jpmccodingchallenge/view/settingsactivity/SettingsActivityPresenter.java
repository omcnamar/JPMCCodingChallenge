package com.olegsagenadatrytwo.jpmccodingchallenge.view.settingsactivity;

import android.content.Context;

public class SettingsActivityPresenter implements SettingsActivityContract.Presenter {

    private SettingsActivityContract.View view;
    private Context context;

    @Override
    public void attachView(SettingsActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }
}
