package com.renshuchan.weather.model.json;

import com.google.gson.annotations.SerializedName;

/**
 * @author WangZemin
 * @since 2018-09-26
 * 和风天气返回的update字段
 */
public class HUpdate {

    // 当地时间，24小时制，格式yyyy-MM-dd HH:mm
    @SerializedName("loc")
    private String localTime;

    // UTC时间，24小时制，格式yyyy-MM-dd HH:mm
    @SerializedName("utc")
    private String utcTime;

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(String utcTime) {
        this.utcTime = utcTime;
    }
}
