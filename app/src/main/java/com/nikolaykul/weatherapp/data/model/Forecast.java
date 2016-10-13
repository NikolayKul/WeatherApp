package com.nikolaykul.weatherapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("period") public String period;

    @SerializedName("icon_url") public String iconUrl;

    @SerializedName("title") public String title;

    @SerializedName("fcttext") public String description;

    @Override public String toString() {
        return period + ", " +
                iconUrl + ", " +
                title + ", " +
                description + ", ";
    }
}
