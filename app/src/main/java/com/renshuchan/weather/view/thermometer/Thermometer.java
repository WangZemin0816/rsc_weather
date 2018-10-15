package com.renshuchan.weather.view.thermometer;

import android.graphics.Canvas;
import android.graphics.RectF;

public class Thermometer {

    // 温度计上的最低温度
    private int minTemperature = -30;

    // 温度计上的每大格代表的温度大小
    private int scaleUnit = 10;

    // 温度计上一共有几大格温度
    private int maxTemperature = 60;

    // 定义温度计控件的区域
    private RectF rectF;

    // 刻度尺上的左侧标签
    private Scale leftScale;

    // 刻度尺上的右侧标签
    private Scale rightScale;

    // 刻度尺上的水银柱
    private Mercury mercury;

    public Thermometer(RectF rectF) {
        this.rectF = rectF;
        this.initScale();
    }


    // 在温度计上显示一个温度
    public void draw(Canvas canvas, float temperature) {
        moveScale(temperature);
        float ratio = Math.abs((temperature - minTemperature) / (maxTemperature - minTemperature));
        drawBackground(canvas);
        mercury.draw(canvas, ratio);

    }

    // 绘制温度计的静态部分，比如刻度尺等信息
    public void drawBackground(Canvas canvas) {
        leftScale.draw(canvas);
        rightScale.draw(canvas);
        mercury.draw(canvas, 0);
    }

    // 初始化所有变量
    private void initScale(){
        this.initMercury();
        this.initLeftScale();
        this.initRightScale();
    }

    // 初始化水银温度计部分
    private void initMercury() {

        // 水银柱区域计算
        float columnLeft = rectF.centerX() - getColumnWidth() / 2;
        float columnRitght = rectF.centerX() + getColumnWidth() / 2;
        float columnTop = rectF.top + getTopMargin();
        float columnBottom = columnTop + getColumnHeight();
        RectF columnRectf = new RectF(columnLeft, columnTop, columnRitght, columnBottom);

        // 水银容器区域计算
        float containerLeft = rectF.centerX() - getContainerWidth() / 2;
        float containerRitght = rectF.centerX() + getContainerWidth() / 2;
        float containerBottom = columnBottom + getContainerHeight();
        RectF containerRectf = new RectF(containerLeft, columnBottom, containerRitght, containerBottom);

        // 生成一个水银温度计对象
        mercury = new Mercury(columnRectf, containerRectf);

    }

    // 初始化竖直刻度
    private void initLeftScale() {
        // 刻度线区域计算
        float scaleLeft = rectF.centerX() - getColumnWidth() / 2 - getScaleWidth();
        float scaleRitght = rectF.centerX() - getColumnWidth() / 2;
        float scaleTop = rectF.top + getTopMargin();
        float scaleBottom = scaleTop + getColumnHeight();
        RectF leftRectf = new RectF(scaleLeft, scaleTop, scaleRitght, scaleBottom);
        // 温度计竖直刻度由标签和刻度线组成
        leftScale = new Scale(leftRectf, minTemperature, maxTemperature, scaleUnit);
    }

    // 初始化竖直刻度
    private void initRightScale() {
        // 刻度线区域计算
        float scaleLeft = rectF.centerX() + getColumnWidth() / 2;
        float scaleRitght = rectF.centerX() + getColumnWidth() / 2 + getScaleWidth();
        float scaleTop = rectF.top + getTopMargin();
        float scaleBottom = scaleTop + getColumnHeight();
        RectF leftRectf = new RectF(scaleLeft, scaleTop, scaleRitght, scaleBottom);
        // 温度计竖直刻度由标签和刻度线组成
        rightScale = new Scale(leftRectf, minTemperature, maxTemperature, scaleUnit);
        rightScale.setInRight(true);
    }


    private float getTopMargin() {
        return rectF.height() * 1 / 10;
    }

    // 水银柱宽度占视图的宽度的比例
    private float getColumnWidth() {
        return rectF.width() * 1 / 10;
    }

    // 水银柱高度占视图的高度的比例
    private float getColumnHeight() {
        return rectF.height() * 7 / 10;
    }

    // 刻度线的宽度，高度与水银柱相同
    private float getScaleWidth() {
        return rectF.width() * 1 / 4;
    }

    // 水银容器所在正方形的边长
    private float getContainerWidth() {
        return rectF.width() * 4 / 15;
    }

    // 水银容器所在正方形的边长
    private float getContainerHeight() {
        return rectF.height()  * 2 / 15;
    }

    // 根据当前温度移动刻度区间，温度过高则把整个区间向上移动，过低则向下移动
    private void moveScale(float temperature) {
        // 当前温度在温度计显示的区域内，那么不移动区间
        if(temperature>minTemperature&&temperature<maxTemperature)
            return;
        int range = maxTemperature - minTemperature;
        if(temperature<minTemperature){
            minTemperature = (int) Math.floor(temperature);
            maxTemperature = minTemperature+range;
        }else{
            maxTemperature = (int) Math.ceil(temperature);
            minTemperature = maxTemperature-range;
        }
        initScale();

    }

    public void setRectF(RectF rectF) {
        this.rectF = rectF;
        initScale();
    }
}
