package com.renshuchan.weather.model.json;

import com.google.gson.annotations.SerializedName;

public class HDailyForecast {

    // 预报日期
    @SerializedName("date")
    private String date;

    // 日出时间
    @SerializedName("sr")
    private String sunRise;

    // 日落时间
    @SerializedName("ss")
    private String sunSet;

    // 月升时间
    @SerializedName("mr")
    private String moonRise;

    // 月落时间
    @SerializedName("ms")
    private String moonSet;

    //最高温度
    @SerializedName("tmp_max")
    private String  temperatureMax;

    //最低温度
    @SerializedName("tmp_min")
    private String  temperatureMin;

    //白天天气状况代码
    @SerializedName("cond_code_d")
    private String condCodeDay;

    //晚间天气状况代码
    @SerializedName("cond_code_n")
    private String condCodeNight;

    //白天天气状况描述
    @SerializedName("cond_txt_d")
    private String condTxtDay;

    //晚间天气状况描述
    @SerializedName("cond_txt_n")
    private String condTxtNight;

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

    //降水概率
    @SerializedName("pop")
    private String rainProbability;

    //大气压强
    @SerializedName("pres")
    private String pressure;

    //紫外线强度指数
    @SerializedName("uv_index")
    private String UVIndex;

    //能见度，单位：公里
    @SerializedName("vis")
    private String  visibility;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSunRise() {
        return sunRise;
    }

    public void setSunRise(String sunRise) {
        this.sunRise = sunRise;
    }

    public String getSunSet() {
        return sunSet;
    }

    public void setSunSet(String sunSet) {
        this.sunSet = sunSet;
    }

    public String getMoonRise() {
        return moonRise;
    }

    public void setMoonRise(String moonRise) {
        this.moonRise = moonRise;
    }

    public String getMoonSet() {
        return moonSet;
    }

    public void setMoonSet(String moonSet) {
        this.moonSet = moonSet;
    }

    public String getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(String temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public String getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(String temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public String getCondCodeDay() {
        return condCodeDay;
    }

    public void setCondCodeDay(String condCodeDay) {
        this.condCodeDay = condCodeDay;
    }

    public String getCondCodeNight() {
        return condCodeNight;
    }

    public void setCondCodeNight(String condCodeNight) {
        this.condCodeNight = condCodeNight;
    }

    public String getCondTxtDay() {
        return condTxtDay;
    }

    public void setCondTxtDay(String condTxtDay) {
        this.condTxtDay = condTxtDay;
    }

    public String getCondTxtNight() {
        return condTxtNight;
    }

    public void setCondTxtNight(String condTxtNight) {
        this.condTxtNight = condTxtNight;
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

    public String getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(String rainProbability) {
        this.rainProbability = rainProbability;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getUVIndex() {
        return UVIndex;
    }

    public void setUVIndex(String UVIndex) {
        this.UVIndex = UVIndex;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
