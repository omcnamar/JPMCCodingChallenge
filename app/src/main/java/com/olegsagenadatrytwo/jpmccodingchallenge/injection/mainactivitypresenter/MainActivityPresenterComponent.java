package com.olegsagenadatrytwo.jpmccodingchallenge.injection.mainactivitypresenter;

import com.olegsagenadatrytwo.jpmccodingchallenge.view.mainactivity.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainActivityPresenterModule.class} )
public interface MainActivityPresenterComponent {
    void insert(MainActivityPresenter homeActivityPresenter);
}