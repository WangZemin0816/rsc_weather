package com.renshuchan.weather.model.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HWeather {

    // 基础信息
    @SerializedName("basic")
    private HBasic basic;

    // 接口更新时间
    @SerializedName("update")
    private HUpdate update;

    // 返回的状态码
    @SerializedName("status")
    private String status;

    // 实况天气
    @SerializedName("now")
    private HNow now;

    // 天气预报
    @SerializedName("daily_forecast")
    private List<HDailyForecast> dailyForecasts;

    // 生活指数未来3天预报
    @SerializedName("lifestyle")
    private List<HLifeStyle> lifeStyles;

    public HBasic getBasic() {
        return basic;
    }

    public void setBasic(HBasic basic) {
        this.basic = basic;
    }

    public HUpdate getUpdate() {
        return update;
    }

    public void setUpdate(HUpdate update) {
        this.update = update;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HNow getNow() {
        return now;
    }

    public void setNow(HNow now) {
        this.now = now;
    }

    public List<HDailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    public void setDailyForecasts(List<HDailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

    public List<HLifeStyle> getLifeStyles() {
        return lifeStyles;
    }

    public void setLifeStyles(List<HLifeStyle> lifeStyles) {
        this.lifeStyles = lifeStyles;
    }
}
