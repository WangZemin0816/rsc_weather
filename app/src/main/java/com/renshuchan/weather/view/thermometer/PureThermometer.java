package com.renshuchan.weather.view.thermometer;

public class PureThermometer extends  AThermometer{


    // 设置温度计控件的大小
    public PureThermometer(float thermometerViewWith,int thermometerViewHeight) {
        super(thermometerViewWith,thermometerViewHeight);

    }


    protected void initMercury(){
        // 水银的宽度计算,设定为整个视图宽度的1/15
        float mercuryWith = getThermometerViewWith()/15;
        // 水银的总高度计算
        float mercuryHeight = getThermometerViewHeight()*7/10;
        //水银柱的位置计算
        float mercuryTopX = getThermometerViewWith()/2;
        float mercuryTopY = getMarginTopBottom();
        setMercuryColumn(new PureMercuryColumn(mercuryTopX,mercuryTopY,mercuryWith,mercuryHeight));
    }

    // 温度计刻度参数初始化,必须先初始化水银柱再初始化刻度
    protected void initScale(){

        // 最短刻度线的长度计算，设定为与水银宽度相同
        float minScaleLong = getThermometerViewWith()/30;
        // 中等刻度线的长度计算，设定为最短刻度线的8/5
        float midScaleLong = minScaleLong*8/5;
        // 最长刻度线的长度计算，设定为中等刻度线的3/2
        float maxScaleLong = midScaleLong*4/3;

        // 刻度总长度
        float scaleTotalLong = getMercuryColumn().getHeight();

        // 计算左右刻度的坐标
        float scaleTopY = getMarginTopBottom();
        float leftScaleTopX = getMercuryColumn().getTopX() - getMercuryColumn().getWidth()/2;
        float rightScaleTopX =  getMercuryColumn().getTopX() + getMercuryColumn().getWidth()/2;
        setLeftScale(new NormalVerticalScale(getMinTemperature(),getMaxScaleNum(),getMaxScaleUnit(),leftScaleTopX,scaleTopY));
        getLeftScale().setMaxScaleLong(maxScaleLong);
        getLeftScale().setMidScaleLong(midScaleLong);
        getLeftScale().setMinScaleLong(minScaleLong);
        getLeftScale().setTotalLong(scaleTotalLong);
        getLeftScale().setRightOrLeft(-1);
        getLeftScale().setLabelSize(28);
        // 右边的刻度是左边的复制
        setRightScale(getLeftScale().clone());
        getRightScale().setRightOrLeft(1);
        getRightScale().setTopX(rightScaleTopX);

    }
}
