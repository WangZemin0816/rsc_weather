package com.renshuchan.weather.view.thermometer;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @author rsc
 * @since 2018-09-30
 * 温度计竖直方向的标尺
 */
public class NormalVerticalScale extends AVerticalScale implements Cloneable{

    public NormalVerticalScale(int minValue, int  maxScaleNum, int maxScaleUnit, float topX, float topY){
        super(minValue,maxScaleNum,maxScaleUnit,topX,topY);
    }


    // 在指定画布上绘制刻度
    public void drawScale(Canvas canvas){

        // 绘制刻度的画笔
        Paint scalePaint = getScalePaint();

        // 绘制坐标轴标签的画笔
        Paint labelPaint = getLabelPaint();

        // 最大的数值
        int maxValue =  getMinValue()+getMaxScaleUnit()*getMaxScaleNum();

        // 大刻度之间的间隔
        float maxScaleInterval = getTotalLong()/getMaxScaleNum();

        // 小刻度之间的间隔
        float minScaleInterval = getTotalLong()/getMaxScaleNum()/10;

        for(int ii=0;ii<=getMaxScaleNum();ii++){

            // 长的刻度线坐标计算
            float startX = getTopX();
            float startY = getTopY()+maxScaleInterval*ii;
            float stopX = startX+getRightOrLeft()*getMaxScaleLong();
            float stopY = startY;

            //长刻度的绘制
            canvas.drawLine(startX,startY,stopX,stopY,scalePaint);

            // 标签内容及标签绘制
            String labelText = maxValue-ii*getMaxScaleUnit()+"";
            canvas.drawText(labelText,getLabelX(labelText,labelPaint),stopY+labelPaint.getTextSize()/2,labelPaint);

            //最后一个至绘制最长的刻度
            if(ii==getMaxScaleNum())
                continue;

            //绘制子刻度线
            for(int jj=1;jj<=9;jj++){
                if(jj==5){      //绘制中等长度的刻度线
                    canvas.drawLine(startX,startY+minScaleInterval*jj,
                            startX+getRightOrLeft()*getMidScaleLong(),startY+minScaleInterval*jj,scalePaint);
                }else{     //绘制短刻度线
                    canvas.drawLine(startX,startY+minScaleInterval*jj,
                            startX+getRightOrLeft()*getMinScaleLong(),startY+minScaleInterval*jj,scalePaint);
                }
            }
        }
    }



    //根据标签大小计算标签水平方向的位置
    private float getLabelX(String text,Paint paint){

        // 获取标签的宽度
        float stringWidth = paint.measureText(text);

        // 标签与刻度之间间隙大小
        float margin = (float)paint.getTextSize()/3;

        if(getRightOrLeft()==1)
            return margin+getMaxScaleLong()+getTopX();
        else
            return getTopX()-margin-getMaxScaleLong()-stringWidth;
    }
    @Override
    public NormalVerticalScale clone(){
        return (NormalVerticalScale)super.clone();
    }

}
