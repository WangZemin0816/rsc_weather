package com.renshuchan.weather.model.json;

import com.google.gson.annotations.SerializedName;

/**
 * @author WangZemin
 * @since 2018-09-26
 * 和风天气返回的basic字段
 */
public class HBasic {

    //地区／城市名称
    @SerializedName("location")
    private String location;

    //地区／城市ID
    @SerializedName("cid")
    private String cid;

    //地区／城市纬度
    @SerializedName("lat")
    private String latitude;

    //地区／城市经度
    @SerializedName("lon")
    private String longitude;

    //该地区／城市的上级城市
    @SerializedName("parent_city")
    private String parentCity;

    //该地区／城市所属行政区域
    @SerializedName("admin_area")
    private String adminArea;

    //该地区／城市所属国家名称
    @SerializedName("cnty")
    private String country;

    //该地区／城市所在时区
    @SerializedName("tz")
    private String timeZone;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getParentCity() {
        return parentCity;
    }

    public void setParentCity(String parentCity) {
        this.parentCity = parentCity;
    }

    public String getAdminArea() {
        return adminArea;
    }

    public void setAdminArea(String adminArea) {
        this.adminArea = adminArea;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
