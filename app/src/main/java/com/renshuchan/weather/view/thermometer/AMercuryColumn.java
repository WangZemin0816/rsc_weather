package com.renshuchan.weather.view.thermometer;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @author rsc
 * @since 2018-09-30
 * 温度计柱水银抽象类
 */

public abstract class AMercuryColumn {

    // 水银柱顶部中心坐标的X和，示例图—*—
    private float topX;
    private float topY;

    // 水银柱的宽度
    private float width;

    // 水银柱的高度
    private float height;

    // 水银柱绘制的画笔
    private Paint mercuryColumnPaint;

    //水银柱容器绘制的画笔
    private Paint containerPaint;

    public AMercuryColumn(float topX, float topY, float width, float height) {
        this.topX = Math.abs(topX);
        this.topY = Math.abs(topY);
        this.width = Math.abs(width);
        this.height = Math.abs(height);

        // 初始化俩只画笔
        mercuryColumnPaint = new Paint();
        mercuryColumnPaint.setStyle(Paint.Style.FILL);
        containerPaint = new Paint();
        containerPaint.setStyle(Paint.Style.FILL);
    }

    // 绘制水银容器，比如玻璃温度计的玻璃泡
    public abstract void drawContainer(Canvas canvas);

    // 绘制水银柱，用于显示温度值
    public abstract void drawMercuryColumn(Canvas canvas, float curHeight);

    public float getTopX() {
        return topX;
    }

    public float getTopY() {
        return topY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Paint getMercuryColumnPaint() {
        return mercuryColumnPaint;
    }

    public Paint getContainerPaint() {
        return containerPaint;
    }
}
