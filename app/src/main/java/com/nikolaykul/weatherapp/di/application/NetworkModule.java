package com.nikolaykul.weatherapp.di.application;

import android.content.Context;
import android.net.ConnectivityManager;

import com.nikolaykul.weatherapp.util.NetworkManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.CallAdapter;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

@Module
class NetworkModule {

    @Provides
    @Singleton
    CallAdapter.Factory provideCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    ConnectivityManager provideConnectivityManager(@AppContext Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Provides
    @Singleton
    NetworkManager provideNetworkManager(ConnectivityManager cm) {
        return new NetworkManager(cm);
    }

}
