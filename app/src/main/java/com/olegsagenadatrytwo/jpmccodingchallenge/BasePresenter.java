package com.olegsagenadatrytwo.jpmccodingchallenge;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void removeView();
}
