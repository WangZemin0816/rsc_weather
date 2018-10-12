package com.renshuchan.weather.model.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;

import com.renshuchan.weather.model.json.HWeather;
import com.renshuchan.weather.model.heweather.HeWeather;
import com.renshuchan.weather.util.SharedManaged;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AutoGetWeatherService extends Service {

    // 不支持绑定操作
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // 服务启动的时候执行的操作,使用采用AlarmManager机制循环执行该操作
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //从SharedPreferences中获取是否更新天气的标志
        boolean isUpdateTime = SharedManaged.getBoolean(this,"isUpdateWeather", true);

        // 获取自动更新的周期时间，设定时间单位为小时，这里转化为ms
        int autoUpdatePeriod = SharedManaged.getInt(this,"autoUpdatePeriod", 60);

        if (isUpdateTime == true) {

            // 更新天气并且为下次更新定时
            updateAndAlarm(autoUpdatePeriod);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    // 更新天气并且为下次更新定时
    private void updateAndAlarm(int autoUpdatePeriod){
        // 更新天气
        updateWeather();

        // 获取定时闹钟的AlarmManager对象
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // 计算下一次更新天气的时间点
        long triggerAtTime = SystemClock.elapsedRealtime() + autoUpdatePeriod;

        // 下一次继续开启本服务进行程序的循环执行
        Intent intent1 = new Intent(this, AutoGetWeatherService.class);

        // 获取可以不立即执行的PendingIntent
        PendingIntent pi = PendingIntent.getService(this, 0, intent1, 0);

        // 撤回旧的PendingIntent
        manager.cancel(pi);

        // triggerAtTime时间点执行PendingIntent
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
    }


     // 更新天气信息，更新的信息保存在SharedPreferences中
    private void updateWeather() {

        String cityName =  SharedManaged.getString(this,"cityName", null);
        if (cityName != null) {
            HeWeather.getWeather(cityName, new Callback() {

                // 如果请求天气信息失败，那么什么都不做
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                // 如果请求天气信息成功，那么将返回的天气信息存储在SharedPreferences中
                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    // 获取返回的json内容
                    String responseText = response.body().string();

                    // 将json返回值转化为weather对象
                    HWeather weather = HeWeather.json2Weather(responseText);

                    // 如果返回的天气格式正确，那么存入SharedPreferences中
                    if (weather != null && "ok".equals(weather.getStatus())) {
                        SharedManaged.putString(AutoGetWeatherService.this,"weatherResponse", responseText);
                    }
                }
            });
        }
    }
}
