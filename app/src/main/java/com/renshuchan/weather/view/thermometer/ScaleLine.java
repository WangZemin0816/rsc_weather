package com.renshuchan.weather.view.thermometer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * @author rsc
 * @since 2018-10-12
 * 水银温度计刻度线 具体的刻度线
 */
public class ScaleLine {

    // 绘制刻度线的画笔
    private Paint paint;

    // 刻度线所在的矩形区域
    private RectF rect;

    // 初始化刻度线的长度
    public ScaleLine(RectF rect) {
        this.rect = rect;
        this.paint = getDefaultPaint();
    }

    // 在指定区域内绘制刻度线
    public void draw(Canvas canvas, ScaleInfo scaleInfo){

        // 刻度之间的间隔
        float interval = rect.height()/(scaleInfo.getScaleNums()-1);

        // 刻度底部的坐标
        float bottomX = rect.right;
        float bottomY = rect.bottom;
        int   direction = scaleInfo.getDirection();
        if(scaleInfo.isInRight()){
            bottomX = rect.left;
        }
        // 逐条绘制刻度线
        for(int ii=0;ii<scaleInfo.getScaleNums();ii++){
            float curY = bottomY-interval*ii;
            if(scaleInfo.isLongest(ii))
                drawLine(canvas,bottomX,curY,getLongestScale()*direction);
            else if(scaleInfo.isMidLong(ii))
                drawLine(canvas,bottomX,curY,getMidLongScale()*direction);
            else
                drawLine(canvas,bottomX,curY,getShortestScale()*direction);
        }
    }

    // 绘制一条长度为length的横线
    private void drawLine(Canvas canvas, float startX, float startY, float length){
        float stopX = startX + length;
        canvas.drawLine(startX, startY,stopX, startY, paint);
    }


    // 获取刻度线默认画笔
    private Paint getDefaultPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        return paint;
    }

    // 获取最长刻度线的长度
    private float getLongestScale(){
        return rect.width()*6/7;
    }

    // 获取中等刻度线的长度
    private float getMidLongScale(){
        return rect.width()*5/8;
    }

    // 获取中等刻度线的长度
    private float getShortestScale(){
        return rect.width()*3/7;
    }



    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
