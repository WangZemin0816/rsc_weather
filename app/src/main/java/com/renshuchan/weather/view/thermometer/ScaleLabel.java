package com.renshuchan.weather.view.thermometer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * @author rsc
 * @since 2018-10-12
 * 水银温度计刻度线标签
 */
public class ScaleLabel {

    // 标签绘制的画笔
    private Paint paint;

    // 标签所在的方形区域
    private RectF rect;

    public ScaleLabel(RectF rect){
        this.rect = rect;
        this.paint = getDefaultPaint();
    }

    // 在指定高度区域内绘制标签 0,10,20之类的标签 maxNum:绘制大刻度的区间个数
    public void draw(Canvas canvas, ScaleInfo scaleInfo){

        // 刻度之间的间隔
        float interval = rect.height()/(scaleInfo.getScaleNums()-1);

        // 刻度顶部的坐标,默认左侧
        float bottomX = rect.right;
        float bottomY = rect.bottom;

        int   direction = (scaleInfo.getDirection()-1)/2;
        if(scaleInfo.isInRight()){
            bottomX = rect.left;
        }
        // 当前显示标签的值
        int cueLabelValue = scaleInfo.getMinLabelValue();
        // 逐条绘制刻度线
        for(int ii=0;ii<scaleInfo.getScaleNums();ii++){
            float curY = bottomY-interval*ii+getHeight()/2;
            if(scaleInfo.isLongest(ii)){
                String curLabel = cueLabelValue+"";
                float curX = bottomX+direction*paint.measureText(curLabel);
                canvas.drawText(curLabel,curX,curY,paint);
                cueLabelValue = cueLabelValue+scaleInfo.getUnit();
            }
        }
    }

    // 获取标签的高度
    public float getHeight(){
        return paint.getTextSize();
    }

    // 获取默认画笔
    private Paint getDefaultPaint(){
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(32);
        paint.setShader(null);
        return paint;
    }

}
