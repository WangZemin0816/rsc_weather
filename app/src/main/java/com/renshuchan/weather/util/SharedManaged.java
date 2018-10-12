package com.renshuchan.weather.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.renshuchan.weather.model.service.AutoGetWeatherService;

/**
 * SharedPreferences读写操作
 */
public class SharedManaged {

    // 向指定context的SharedPreferences中存入key,(String)value
    public static void putString(Context context ,String key,String val){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(key, val);
        editor.apply();
    }

    // 向指定context的SharedPreferences中存入key,(int)value
    public static void putInt(Context context ,String key,int val){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(key, val);
        editor.apply();
    }

    // 向指定context的SharedPreferences中存入key,(boolean)value
    public static void putBoolean(Context context ,String key,boolean val){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(key, val);
        editor.apply();
    }


    //从指定context的SharedPreferences中获取对应的Boolean值，默认返回为true
    public static boolean  getBoolean(Context context ,String key,boolean defVal){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getBoolean(key, defVal);
    }

    //从指定context的SharedPreferences中获取对应的String值，默认返回为null
    public static String  getString(Context context ,String key,String defVal){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getString(key, defVal);
    }

    //从指定context的SharedPreferences中获取对应的String值，默认返回为null
    public static int  getInt(Context context ,String key,int defVal){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getInt(key, defVal);
    }


}
