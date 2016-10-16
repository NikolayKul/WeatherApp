package com.nikolaykul.weatherapp.data.remote;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface GooglePlacesApi {

    @GET("maps/api/place/autocomplete/json")
    Observable<GoogleRequest> findSuggestions(@Query("input") String city);

}