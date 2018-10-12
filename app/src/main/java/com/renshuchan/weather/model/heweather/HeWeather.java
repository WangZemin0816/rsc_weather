package com.renshuchan.weather.model.heweather;


import com.google.gson.Gson;
import com.renshuchan.weather.model.json.HWeather;
import com.renshuchan.weather.util.HttpUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import okhttp3.Callback;

/**
 * @author WangZemin
 * @since 2018-09-25
 * 向和风天气请求数据
 */
public class HeWeather {

    //h和风天气密钥,默认为已经申请得到的
    private static String key ="1933280f5a8049a2989407cea4b1a62e" ;

    //和风天气请求数据的url
    private static String url="https://free-api.heweather.com/s6/weather";

    //读写锁,保证线程安全
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    //向和风天气请求天气信息，并调用callBack中的回调函数
    public static void getWeather(String city, Callback callBack) {
        lock.readLock().lock();
        if (null == city || null == callBack)
            throw new IllegalArgumentException();
        String address = url + "?location=" + city + "&key=" + key;
        HttpUtil.sendOkHttpRequest(address,callBack);
        lock.readLock().unlock();
    }

    //json格式转为天气HWeather
    public static HWeather json2Weather(String jsonStr){
        try{
            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            HWeather weather = new Gson().fromJson(weatherContent, HWeather.class);
            return weather;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void setKeyAndUrl(String key,String url) {
        lock.writeLock().lock();
        HeWeather.key = key;
        HeWeather.url = url;
        lock.writeLock().unlock();
    }

}


