package com.renshuchan.weather.view.thermometer;

import android.graphics.Canvas;

/**
 * @author RSC
 * @since 2018-10-03
 * 温度计抽象类
 */
public abstract class AThermometer {
    // 温度计左侧的刻度
    private AVerticalScale leftScale;

    // 温度计右侧的刻度
    private AVerticalScale rightScale;

    // 温度计水银柱
    private AMercuryColumn mercuryColumn;

    // 定义温度计控件的宽度(包括边缘的宽度)
    private float thermometerViewWith;

    // 定义温度计控件的高度(包括边缘的高度)
    private float thermometerViewHeight;

    // 温度计上当前显示的温度
    private float currentTemperature = (float)0;

    // 温度计上目标温度,由仪器传送过来的数据
    private float targetTemperature = (float)40;

    // 温度计显示的最小温度
    private int minTemperature = 0;

    // 温度计显示几大格温度
    private int maxScaleNum = 12;

    // 每大格代表的温度的数值
    private int maxScaleUnit = 5;

    // 温度计上方与画布边缘的距离
    private float marginTopBottom;

    // 设置温度计控件的大小
    public AThermometer(float thermometerViewWith,float thermometerViewHeight) {
        this.thermometerViewHeight = thermometerViewHeight;
        this.thermometerViewWith = thermometerViewWith;
        // 温度计顶部底部空白
        this.marginTopBottom = thermometerViewHeight/12;
    }


    // 根据目标温度和当前温度绘制水银柱
    public void updateTemperature(Canvas canvas){
        updateCurrentTemperature();
        float ratio = (currentTemperature-minTemperature)/(maxScaleUnit*maxScaleNum);
        float curentHeight = mercuryColumn.getHeight()*ratio;
        mercuryColumn.drawMercuryColumn(canvas,curentHeight);
    }


    // 绘制温度计的背景
    public void drawBG(Canvas canvas){
        initMercury();
        initScale();
        leftScale.drawScale(canvas);
        rightScale.drawScale(canvas);
        mercuryColumn.drawContainer(canvas);
    }

    // 根据当前温度和目标温度，计算下一次应该显示的温度,赋值给currentTemperature
    public void updateCurrentTemperature() {
        // 计算总共应该上升的幅度
        float difference = targetTemperature - currentTemperature;

        // 需要变化的温度差占真个温度区间的比例
        float ratio = difference / (maxScaleNum * maxScaleUnit);

        // 本次刷新上升的幅度
        float changeValue = ratio/10*(maxScaleNum * maxScaleUnit);

        if(ratio<0.001)
            currentTemperature = targetTemperature;
        else
            currentTemperature = currentTemperature+changeValue;
    }



    // 初始化温度计刻度
    protected abstract void initScale();

    // 初始化水银
    protected abstract void initMercury();


    public AVerticalScale getLeftScale() {
        return leftScale;
    }

    public void setLeftScale(AVerticalScale leftScale) {
        this.leftScale = leftScale;
    }

    public AVerticalScale getRightScale() {
        return rightScale;
    }

    public void setRightScale(AVerticalScale rightScale) {
        this.rightScale = rightScale;
    }

    public AMercuryColumn getMercuryColumn() {
        return mercuryColumn;
    }

    public void setMercuryColumn(AMercuryColumn mercuryColumn) {
        this.mercuryColumn = mercuryColumn;
    }

    public float getThermometerViewWith() {
        return thermometerViewWith;
    }

    public void setThermometerViewWith(float thermometerViewWith) {
        this.thermometerViewWith = thermometerViewWith;
    }

    public float getThermometerViewHeight() {
        return thermometerViewHeight;
    }

    public void setThermometerViewHeight(float thermometerViewHeight) {
        this.thermometerViewHeight = thermometerViewHeight;
    }

    public float getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(float currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public float getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(float targetTemperature) {
        if(targetTemperature<minTemperature)
            this.targetTemperature = minTemperature;
        else if(targetTemperature>minTemperature*maxScaleNum*maxScaleNum)
            this.targetTemperature=minTemperature*maxScaleNum*maxScaleNum;
        else
            this.targetTemperature = targetTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMaxScaleNum() {
        return maxScaleNum;
    }

    public void setMaxScaleNum(int maxScaleNum) {
        this.maxScaleNum = maxScaleNum;
    }

    public int getMaxScaleUnit() {
        return maxScaleUnit;
    }

    public void setMaxScaleUnit(int maxScaleUnit) {
        this.maxScaleUnit = maxScaleUnit;
    }

    public float getMarginTopBottom() {
        return marginTopBottom;
    }

    public void setMarginTopBottom(float marginTopBottom) {
        this.marginTopBottom = marginTopBottom;
    }
}
