package com.olegsagenadatrytwo.jpmccodingchallenge.model.remote;

import com.olegsagenadatrytwo.jpmccodingchallenge.entitities.weatherInfo.WeatherInfo;
import com.olegsagenadatrytwo.jpmccodingchallenge.entitities.weatherInfoHourly.HourlyWeatherInfo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;


class RetrofitHelper {
    private static final String BASE_URL = "https://api.wunderground.com/";
    private static final String KEY = "d3e9f2825d24ab13";
    private static final String PATH = "api/" + KEY + "/conditions/hourly/q/{zipcode}.json";
    private static final String PATH_10DAYS = "api/" + KEY + "/conditions/hourly10day/q/{zipcode}.json";

    private static Retrofit create(){

        //create a logging interceptor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //create a custom client to add the interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    static Call<WeatherInfo> getWeatherCall(String query){
        Retrofit retrofit = create();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        return weatherService.getWeatherData(query);
    }

    static Call<HourlyWeatherInfo> getWeatherCallDays(String query){
        Retrofit retrofit = create();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        return weatherService.getWeatherDataDays(query);
    }

    interface WeatherService{

        @GET(PATH)
        Call<WeatherInfo> getWeatherData(@Path("zipcode") String zipCode);

        @GET(PATH_10DAYS)
        Call<HourlyWeatherInfo> getWeatherDataDays(@Path("zipcode") String zipCode);
    }

}
