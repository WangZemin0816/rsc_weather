package com.renshuchan.weather.model.json;

import com.google.gson.annotations.SerializedName;

public class HLifeStyle {

    //生活指数简介
    @SerializedName("brf")
    private String brief;

    //生活指数详细描述
    @SerializedName("txt")
    private String txt;

    //生活指数生活指数类型
    @SerializedName("type")
    private String type;

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
