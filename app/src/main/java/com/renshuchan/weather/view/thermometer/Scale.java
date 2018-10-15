package com.renshuchan.weather.view.thermometer;

import android.graphics.Canvas;
import android.graphics.RectF;

public class Scale {

    // 刻度尺包含的信息
    private ScaleInfo scaleInfo;

    //刻度尺上的标签
    private ScaleLabel scaleLabel;

    // 刻度尺上的刻度
    private ScaleLine scaleLine;

    // 刻度所占据的方形区域
    private RectF rectf;

    // 刻度线占据的比例
    private float lineRatio=(float)0.7;

    public Scale(RectF rectf, int minVal, int maxVal, int unit){
        this.scaleInfo = new ScaleInfo(minVal,maxVal,unit);
        this.rectf = rectf;

    }

    // 绘制刻度尺
    public void draw(Canvas canvas){
        this.initScaleLabel();
        this.initScaleLine();
        scaleLine.draw(canvas,scaleInfo);
        scaleLabel.draw(canvas,scaleInfo);
    }

    // 初始化刻度尺上的标签
    private void initScaleLabel(){
        float left = rectf.left;
        if(scaleInfo.isInRight())
            left = rectf.left+rectf.width()*lineRatio;
        float right = left+rectf.width()*(1-lineRatio);
        RectF labelRectF = new RectF(left,rectf.top,right,rectf.bottom);
        scaleLabel = new ScaleLabel(labelRectF);
    }

    // 初始化刻度尺上的刻度线
    private void initScaleLine(){
        float left = rectf.left+rectf.width()*(1-lineRatio);
        if(scaleInfo.isInRight())
            left = rectf.left;
        float right = left+rectf.width()*lineRatio;
        RectF labelRectF = new RectF(left,rectf.top,right,rectf.bottom);
        scaleLine = new ScaleLine(labelRectF);
    }

    public void setInRight(boolean inRight){
        scaleInfo.setInRight(inRight);
    }
}
