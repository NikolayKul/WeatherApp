package com.nikolaykul.weatherapp.di.application;

import android.content.Context;

import com.nikolaykul.weatherapp.data.remote.WeatherApi;
import com.nikolaykul.weatherapp.util.Const;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Module
class WeatherApiModule {

    @Provides
    @WeatherApiQualifier
    Cache provideCache(@AppContext Context context) {
        final File cacheDir = new File(context.getCacheDir(), "cache");
        return new Cache(cacheDir, 10 * 1024 * 1024);
    }

    @Provides
    @WeatherApiQualifier
    OkHttpClient provideClient(@WeatherApiQualifier Cache cache) {
        final Interceptor authInterceptor = chain -> {
            final Request origin = chain.request();
            final HttpUrl url = origin.url().newBuilder()
                    .addQueryParameter(Const.API_WEATHER_KEY_NAME, Const.API_WEATHER_KEY_VALUE)
                    .addQueryParameter(Const.API_WEATHER_METRIC_NAME, Const.API_WEATHER_METRIC_VALUE)
                    .build();
            final Request request = origin.newBuilder()
                    .url(url)
                    .build();
            return chain.proceed(request);
        };
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(authInterceptor)
                .build();
    }

    @Provides
    @WeatherApiQualifier
    Retrofit provideRetrofit(@WeatherApiQualifier OkHttpClient client,
                             Converter.Factory converterFactory,
                             CallAdapter.Factory callAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(Const.API_WEATHER_HOST)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    WeatherApi provideApi(@WeatherApiQualifier Retrofit retrofit) {
        return retrofit.create(WeatherApi.class);
    }


}