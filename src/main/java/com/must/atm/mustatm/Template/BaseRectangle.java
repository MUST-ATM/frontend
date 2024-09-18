package com.must.atm.mustatm.Template;

import java.util.ArrayList;

public abstract class BaseRectangle {

    protected  double arcWidth;
    protected  double arcHeight;
    protected  int colorR;
    protected  int colorG;
    protected  int colorB;

    public BaseRectangle(double arcWidth, double arcHeight, int colorR, int colorG, int colorB)
    {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }


    public double getArcWidth()
    {return arcWidth;}

    public double getArcHeight()
    {return arcHeight;}
    public int getColorR()
    {return colorR;}




}
