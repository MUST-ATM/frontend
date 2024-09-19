package com.must.atm.mustatm.Template;
import java.util.ArrayList;

/**
 * BaseRectangle is the class for storing data of Rectangles
 * @author jingye
 */
public class BaseRectangle {
    protected  double arcWidth;
    protected  double arcHeight;
    protected  ArrayList<Integer> recColor;
    protected double timesY;
    protected double timesX;
    protected double  timesHeight;
    protected double  timesWidth;
    public BaseRectangle(double arcWidth, double arcHeight,  ArrayList<Integer>recColor,ArrayList<Double>recPosition)
    {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.recColor = recColor;

        this.timesY = recPosition.get(0);
        this.timesX = recPosition.get(1);
        this.timesHeight = recPosition.get(2);
        this.timesWidth = recPosition.get(3);
    }
    /**
     * Those method is used to get the degree of the filleted corner
     *
     */
    public double getArcWidth()
    {return arcWidth;}
    public double getArcHeight()
    {return arcHeight;}
    /**
     * This method is used to get color of rectangle
     * @return a list which include the date about color of rectangle
     */
    public ArrayList<Integer> getColor()
    {
        return recColor;
    }
    /**
     * Those method is used to get the date which is the multiple of the number that listener get
     * timeX and timeY is the multiple of position date
     * timesHeight and timesWidth is the multiple of size data
     */
    public double getTimesX() {
        return timesX;
    }
    public double getTimesY() {
        return timesY;
    }
    public double getTimesHeight() {
        return timesHeight;
    }
    public double getTimesWidth() {
        return timesWidth;
    }
}
