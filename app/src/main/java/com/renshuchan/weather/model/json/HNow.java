package com.renshuchan.weather.model.json;

import com.google.gson.annotations.SerializedName;

/**
 * @author WangZemin
 * @since 2018-09-26
 * 和风天气返回的实况天气
 */
public class HNow {

    // 体感温度，默认单位：摄氏度
    @SerializedName("fl")
    private String sendibleTemperature;

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

    //	降水量
    @SerializedName("pcpn")
    private String precipitation;

    //大气压强
    @SerializedName("pres")
    private String pressure;

    //能见度，单位：公里
    @SerializedName("vis")
    private String  visibility;

    // 云量
    @SerializedName("cloud")
    private String cloud;

    public String getSendibleTemperature() {
        return sendibleTemperature;
    }

    public void setSendibleTemperature(String sendibleTemperature) {
        this.sendibleTemperature = sendibleTemperature;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCondCode() {
        return condCode;
    }

    public void setCondCode(String condCode) {
        this.condCode = condCode;
    }

    public String getCondTxt() {
        return condTxt;
    }

    public void setCondTxt(String condTxt) {
        this.condTxt = condTxt;
    }

    public String getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(String windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindForce() {
        return windForce;
    }

    public void setWindForce(String windForce) {
        this.windForce = windForce;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }
}
