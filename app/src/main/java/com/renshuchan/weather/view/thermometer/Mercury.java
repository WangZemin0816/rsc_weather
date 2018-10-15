package com.renshuchan.weather.view.thermometer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * @author rsc
 * @since 2018-10-12
 * 水银温度计水银柱部分
 */
public class Mercury {

    // 可以绘制水银柱的区域
    private RectF columnRectF;

    // 水银容器的绘制区域
    private RectF containerRectF;

    // 水银柱绘制的画笔
    private Paint paint;

    public Mercury(RectF columnRectF, RectF containerRectF) {
        // 参数应该为正数
        this.columnRectF = columnRectF;
        this.containerRectF = containerRectF;
        this.paint = getDefaultPaint();
    }


    private Paint getDefaultPaint(){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    // 在画布上画水银柱
    public void draw(Canvas canvas, float ratio){

        // 绘制水银柱的高度应该在0-height之间
        ratio = ratio>0?ratio:0;
        ratio = ratio>1?1:ratio;

        // 计算水银柱的长方形区域并填充
        float top = columnRectF.bottom-columnRectF.height()*ratio;

        // 使用paint画笔填充区域
        canvas.drawRect(columnRectF.left,top,columnRectF.right,columnRectF.bottom,paint);

        drawContainer(canvas);

    }
    public void drawContainer(Canvas canvas){

        // 绘制水银温度计下端的圆球
        float redius = containerRectF.width()/2;
        float centerX = containerRectF.centerX();
        float centerY = containerRectF.bottom-redius;
        canvas.drawCircle(centerX,centerY,redius,paint);

        // 将水银柱和圆球进行连接
        float left = columnRectF.left;
        float right = columnRectF.right;
        float top = columnRectF.bottom;
        float bottom = centerY;
        canvas.drawRect(left,top,right,bottom,paint);
    }

    public RectF getColumnRectF() {
        return columnRectF;
    }

    public void setColumnRectF(RectF columnRectF) {
        this.columnRectF = columnRectF;
    }

    public RectF getContainerRectF() {
        return containerRectF;
    }

    public void setContainerRectF(RectF containerRectF) {
        this.containerRectF = containerRectF;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}
