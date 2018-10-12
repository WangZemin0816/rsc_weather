package com.renshuchan.weather.model.json;

import com.google.gson.annotations.SerializedName;

public class HHourly {

    // 预报时间，格式yyyy-MM-dd hh:mm
    @SerializedName("time")
    private String time;

    // 温度，默认单位：摄氏度
    @SerializedName("tmp")
    private String temperature;

    // 实况天气状况代码
    @SerializedName("cond_code")
    private String condCode;

    // 实况天气状况描述
    @SerializedName("cond_txt")
    private String condTxt;

    //风向360角度
    @SerializedName("wind_deg")
    private String windDegree;

    //风向
    @SerializedName("wind_dir")
    private String windDirection;

    //风力
    @SerializedName("wind_sc")
    private String windForce;

    //风速，公里/小时
    @SerializedName("wind_spd")
    private String windSpeed;

    //	相对湿度
    @SerializedName("hum")
    private String humidity;

    // 大气压强
    @SerializedName("pres")
    private String pressure;

    // 露点温度
    @SerializedName("dew")
    private String dewTemperature;

    // 云量
    @SerializedName("cloud")
    private String cloud;
}
