package com.olegsagenadatrytwo.jpmccodingchallenge.injection.mainactivity;

import com.olegsagenadatrytwo.jpmccodingchallenge.view.mainactivity.MainActivity;

import dagger.Component;


@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}