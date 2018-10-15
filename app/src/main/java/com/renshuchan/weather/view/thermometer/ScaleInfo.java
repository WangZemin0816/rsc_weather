package com.renshuchan.weather.view.thermometer;

/**
 * @author rsc
 * @since 2018-10-14
 * 刻度上的最大值、最小值以及单位等信息
 * 刻度尺上的刻度十小格一大格，五小格一大格
 */
public class ScaleInfo {

    // 刻度尺的最小值
    private int minValue;

    // 刻度尺的最大值
    private int maxValue;

    // 刻度尺上一大格代表的单位长度
    private int unit;

    // 刻度线在左侧还是右侧 left:false,right :true
    private boolean inRight;

    public ScaleInfo(int minValue, int maxValue, int unit) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = Math.abs(unit);
    }

    // 从下往上数第ii个刻度线是不是长刻度线
    public boolean isLongest(int ii){
        return getDistTimes(ii)%10==0;
    }

    // 从下往上数第ii个刻度线是不是中等刻度线
    public boolean isMidLong(int ii){
        return getDistTimes(ii)%5==0;
    }

    // 第ii 个刻度与 最小label之间相差几个小间隔
    private int getDistTimes(int ii){
        // 每小格之间代表的长度
        float smallUnit = (float) unit / 10;
        // 当前刻度与最下标签刻度之间的差值
        float diff = Math.abs(minValue + ii * smallUnit - getMinLabelValue());
        // 当前差值是小刻度线间距的几倍
        return (int) (diff / smallUnit);
    }

    // 计算标签的最小值
    public int getMinLabelValue(){
        return (int) Math.ceil((float)minValue/unit)*unit;
    }
    // 返回刻度线的总数目
    public int getScaleNums() {
        return (int) ((float) (maxValue - minValue) / (float) unit * 10)+1;
    }

    public int getDirection(){
        if (inRight)
            return 1;
        return -1;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public boolean isInRight() {
        return inRight;
    }

    public void setInRight(boolean inRight) {
        this.inRight = inRight;
    }
}
