package com.nikolaykul.weatherapp.data.remote.error;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nikolaykul.weatherapp.R;

import java.io.IOException;

public class PlaceNotFoundThrowable extends IOException implements HasLocalizedMessage {
    @Override public String getMessage(@NonNull Context context) {
        return context.getString(R.string.error_place_not_found);
    }
}