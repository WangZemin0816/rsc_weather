package com.renshuchan.weather.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


import com.renshuchan.weather.view.thermometer.AThermometer;
import com.renshuchan.weather.view.thermometer.PureThermometer;

import java.text.DecimalFormat;

/**
 * @author WangZemin
 * @since 2018-09-29
 * 黑白温度计界面实现
 */

public class ThermometerView extends SurfaceView implements SurfaceHolder.Callback ,Runnable{

    // 管理当前serface的SurfaceHolder
    private SurfaceHolder surfaceHolder;

    // 绘图的画布
    private Canvas canvas;

    // 控制绘画线程的标志位
    private volatile boolean isDrawing;

    // 温度计定义
    private AThermometer thermometer;

    // 背景图片设置
    private Bitmap bgBitmap;

    // 水银温度计刷新频率（次/s）
    int updateFrequency = 100;


    // 用户绘制的线程
    private Thread drawThread;

    // 根据目标温度改变要显示的当前温度的线程
    private Thread updateThread;

    //格式化float
    private DecimalFormat fomat;

    public ThermometerView(Context context) {
        this(context, null);
    }

    public ThermometerView(Context context, AttributeSet attrs) {
        super(context,attrs);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

    }
    @Override
    protected void onMeasure(int with,int height){
        super.onMeasure(with, height);
        thermometer = new PureThermometer(getMeasuredWidth(),getMeasuredHeight());
    }
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

        isDrawing=true;
        drawThread =new Thread(this);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        isDrawing = false;
    }

    @Override
    public void run() {
        //不断进行绘制
        while(isDrawing){
            long start=System.currentTimeMillis();
            draw();
            long end=System.currentTimeMillis();
            if(end-start<updateFrequency){
                //这里控制一下，一秒绘制二十次。也就是五十秒绘制一次
                try {
                    Thread.sleep(updateFrequency-(end-start));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void draw() {

        try {
            canvas = surfaceHolder.lockCanvas();
            //这里要判断是不是为空，之因为在用户点击了home以后，可能已经执行到这里
            if(canvas!=null)
            {
                canvas.drawColor(Color.WHITE);
                thermometer.drawBG(canvas);
                thermometer.updateTemperature(canvas);
            }
        } catch (Exception e) {
                e.printStackTrace();//这里的异常不处理，
        } finally {
            if(canvas!=null){
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
    public void setTemperature(float temperature){
        thermometer.setTargetTemperature(temperature);
    }
}