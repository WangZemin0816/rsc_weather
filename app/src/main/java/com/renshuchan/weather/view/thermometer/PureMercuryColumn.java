package com.renshuchan.weather.view.thermometer;

import android.graphics.Canvas;

/**
 * @author
 * @since 2018-09-30
 * 纯色水银
 */
public class PureMercuryColumn extends AMercuryColumn{

    public PureMercuryColumn(float topX, float topY, float width, float height){
        super(topX, topY,width,height);
    }
    // 在画布上画水银柱
    public void drawMercuryColumn(Canvas canvas,float curHeight){
        if(curHeight<=0)
            curHeight=0;
        else if(curHeight>getHeight())
            curHeight = getHeight();
        float left = getTopX() - getWidth()/2;
        float right = getTopX() + getWidth()/2;
        float bottom = getTopY()+getHeight();
        float top = getTopY()+getHeight()-curHeight;
        canvas.drawRect(left,top,right,bottom,getMercuryColumnPaint());
    }

    //绘制温度计底部的水银球
    public void drawContainer(Canvas canvas){
        canvas.drawCircle(getTopX(),getTopY()+getHeight()+ getWidth(),
                getWidth()*3/2,getContainerPaint());
    }
}
