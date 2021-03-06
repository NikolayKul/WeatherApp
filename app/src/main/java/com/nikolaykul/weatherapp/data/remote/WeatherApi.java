package com.nikolaykul.weatherapp.data.remote;

import com.nikolaykul.weatherapp.data.model.WeatherModel;
import com.nikolaykul.weatherapp.data.remote.constant.WeatherApiConst;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface WeatherApi {

    @GET(WeatherApiConst.Route.DAILY)
    Observable<WeatherModel> fetchForecast(@Query("lat") double lat,
                                           @Query("lon") double lon,
                                           @Query("cnt") int dayCount);

    @GET(WeatherApiConst.Route.DAILY)
    Observable<WeatherModel> fetchForecast(@Query("q") String city,
                                           @Query("cnt") int dayCount);

}
