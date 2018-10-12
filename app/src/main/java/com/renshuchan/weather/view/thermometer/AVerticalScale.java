package com.renshuchan.weather.view.thermometer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * @author rsc
 * @since 2018-09-30
 * 温度计上的刻度对应的抽象类
 */
public abstract class AVerticalScale implements Cloneable{

    private int labelSize=24;
    // 刻度线画笔
    private Paint scalePaint;

    // 标签画笔
    private Paint labelPaint;

    // 刻度显示数字的最小值
    private int minValue;

    // 刻度尺上一共有几个最大的刻度
    private int maxScaleNum;

    // 最大的刻度的单位长度
    private int maxScaleUnit;

    // 顶部第一条刻度线对应的X坐标
    private float topX;

    // 顶部第一条刻度线对应的Y坐标
    private float topY;

    // 有刻度区域的长度
    private float totalLong = 500;

    // 左侧显示刻度还是右侧显示刻度,1:右边，-1:左边
    private int rightOrLeft = -1;

    // 十的倍数的线长度
    private float maxScaleLong=50;

    // 五的倍数的线的长度
    private float midScaleLong=35;

    // 短刻度线的长度
    private float minScaleLong=20;


    public AVerticalScale(int minValue, int maxScaleNum, int maxScaleUnit,float topX,float topY) {
        this.minValue = minValue;
        this.maxScaleNum = Math.abs(maxScaleNum);
        this.maxScaleUnit = Math.abs(maxScaleUnit);
        this.topX = topX;
        this.topY = topY;
        initPaint();

    }

    private void initPaint(){
        scalePaint = new Paint();
        scalePaint.setAntiAlias(true);
        scalePaint.setColor(Color.BLACK);
        scalePaint.setStyle(Paint.Style.STROKE);
        scalePaint.setStrokeWidth(1);

        labelPaint = new Paint();
        labelPaint.setColor(Color.BLACK);
        labelPaint.setTextSize(labelSize);
        labelPaint.setShader(null);
    }


    @Override
    public AVerticalScale clone(){
        try{
            AVerticalScale aVerticalScale = (AVerticalScale)super.clone();
            aVerticalScale.initPaint();
            return aVerticalScale;
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }

    }

    // 在canvas上绘制刻度
    public abstract void drawScale(Canvas canvas);

    public void setMinValue(int minValue) {
        this.minValue = Math.abs(minValue);
    }

    public void setMaxScaleNum(int maxScaleNum) {
        this.maxScaleNum = Math.abs(maxScaleNum);
    }

    public void setMaxScaleUnit(int maxScaleUnit) {
        this.maxScaleUnit = Math.abs(maxScaleUnit);
    }

    public void setTopX(float topX) {
        this.topX = topX;
    }

    public void setTopY(float topY) {
        this.topY = topY;
    }

    public void setTotalLong(float totalLong) {
        this.totalLong = Math.abs(totalLong);
    }

    public void setRightOrLeft(int rightOrLeft) {
        this.rightOrLeft = -1;
        if(rightOrLeft>0)
            this.rightOrLeft = 1;
    }

    public int getLabelSize() {
        return labelSize;
    }

    public void setLabelSize(int labelSize) {
        this.labelSize = labelSize;
    }

    public Paint getScalePaint() {
        return scalePaint;
    }

    public void setScalePaint(Paint scalePaint) {
        this.scalePaint = scalePaint;
    }

    public Paint getLabelPaint() {
        return labelPaint;
    }

    public void setLabelPaint(Paint labelPaint) {
        this.labelPaint = labelPaint;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxScaleNum() {
        return maxScaleNum;
    }

    public int getMaxScaleUnit() {
        return maxScaleUnit;
    }

    public float getTopX() {
        return topX;
    }

    public float getTopY() {
        return topY;
    }

    public float getTotalLong() {
        return totalLong;
    }

    public int getRightOrLeft() {
        return rightOrLeft;
    }

    public float getMaxScaleLong() {
        return maxScaleLong;
    }

    public void setMaxScaleLong(float maxScaleLong) {
        this.maxScaleLong = maxScaleLong;
    }

    public float getMidScaleLong() {
        return midScaleLong;
    }

    public void setMidScaleLong(float midScaleLong) {
        this.midScaleLong = midScaleLong;
    }

    public float getMinScaleLong() {
        return minScaleLong;
    }

    public void setMinScaleLong(float minScaleLong) {
        this.minScaleLong = minScaleLong;
    }
}
