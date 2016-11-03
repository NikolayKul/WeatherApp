package com.nikolaykul.weatherapp.data.remote.error;

import android.content.Context;
import android.support.annotation.NonNull;

public interface HasLocalizedMessage {
    String getMessage(@NonNull Context context);
}