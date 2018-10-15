package com.renshuchan.weather.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.renshuchan.weather.view.thermometer.Thermometer;


/**
 * @author WangZemin
 * @since 2018-09-29
 * 黑白温度计界面实现
 */

public class ThermometerView extends SurfaceView implements SurfaceHolder.Callback ,Runnable {

    // 管理当前serface的SurfaceHolder
    private SurfaceHolder surfaceHolder;

    // 绘图的画布
    private Canvas canvas;

    // 控制绘画线程的标志位
    private volatile boolean isDrawing;

    // 温度计定义
    private Thermometer thermometer;

    // 温度计上当前显示的温度
    private volatile float currentTemperature = (float)0;

    // 温度计上目标温度,由仪器传送过来的数据
    private volatile float targetTemperature = (float)50;

    // 温度计温度动态显示，多长时间刷新一次,单位：ms
    private volatile long thermometerUpdateTime=20;


    public ThermometerView(Context context) {
        this(context, null);
    }

    public ThermometerView(Context context, AttributeSet attrs) {
        super(context,attrs);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        RectF thermometerRectF = new RectF(0,0,getWidth(),getHeight());
        thermometer = new Thermometer(thermometerRectF);

    }




    @Override
    public void run() {
        //不断进行绘制
        while(isDrawing){
            long start= System.currentTimeMillis();
            updateTemperature();
            draw();
            long end= System.currentTimeMillis();
            if(end-start<thermometerUpdateTime){
                //这里控制一下，一秒绘制二十次。也就是五十秒绘制一次
                try {
                    Thread.sleep(thermometerUpdateTime-(end-start));
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
                thermometer.draw(canvas,currentTemperature);
            }
        } catch (Exception e) {
                e.printStackTrace();//这里的异常不处理，
        } finally {
            if(canvas!=null){
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        isDrawing=true;
        Thread drawThread =new Thread(this);
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,
                               int format, int width, int height){}

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        isDrawing = false;
    }

    @Override
    protected void onMeasure(int with,int height){
        super.onMeasure(with, height);
        RectF thermometerRectF = new RectF(0,0,getMeasuredWidth(), getMeasuredHeight());
        thermometer.setRectF(thermometerRectF);
    }

    public void setTemperature(float temperature){
        targetTemperature=temperature;
    }


    /**
     * 设定目标温度之后，温度计不会立马跳转至该温度，而是有一个上升的动画过程
     * 以下程序中，设置温度每次上升需要上升幅度的十分之一
     */
    public void updateTemperature(){
        float diff = targetTemperature-currentTemperature;
        currentTemperature = currentTemperature+diff/50;
        //温度差值比较小，那么直接上升为目标温度
        if(Math.abs(diff)<0.1)
            currentTemperature =targetTemperature;
    }
}