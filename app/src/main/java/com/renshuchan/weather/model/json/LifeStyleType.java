package com.renshuchan.weather.model.json;


//生活指数类型对应的中文名称
public enum LifeStyleType{

    COMF("comf","舒适度指数"),
    CW("cw","洗车指数"),
    DRSG("drsg","穿衣指数"),
    FLU("flu","感冒指数"),
    SPORT("sport","运动指数"),
    TRAV("trav","旅游指数"),
    UV("uv","紫外线指数"),
    AIR("air","空气污染扩散条件指数"),
    AC("ac","空调开启指数"),
    AG("ag","过敏指数"),
    GL("gl","太阳镜指数"),
    MU("mu","化妆指数"),
    AIRC("airc","晾晒指数"),
    PTFC("ptfc","交通指数"),
    FSH("fsh","钓鱼指数"),
    SPI("spi","防晒指数"),
    DFT("default","空");

    //防止字段值被修改，增加的字段也统一final表示常量
    private final String key;
    private final String value;

    private LifeStyleType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //根据key获取枚举
    public static LifeStyleType getEnumByKey(String key) {
        if (null == key)
            return LifeStyleType.DFT;

        for (LifeStyleType temp : LifeStyleType.values()) {
            if (temp.getKey().equals(key)) {
                return temp;
            }
        }
        return LifeStyleType.DFT;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}