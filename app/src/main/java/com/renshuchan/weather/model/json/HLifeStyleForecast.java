package com.renshuchan.weather.model.json;

import com.google.gson.annotations.SerializedName;

public class HLifeStyleForecast {

    //生活指数简介
    @SerializedName("date")
    private String date;

    //生活指数简介
    @SerializedName("brf")
    private String brief;

    //生活指数详细描述
    @SerializedName("txt")
    private String txt;

    //生活指数生活指数类型
    @SerializedName("type")
    private LifeStyleType type;


}
