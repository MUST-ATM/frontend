package com.must.atm.mustatm.Base;

/**
 * @author bywang
 */
public class StatusBase
{
    private boolean faceRecognition;
    private boolean faceAntiSpoofing;

    public StatusBase()
    {
        faceRecognition = false;
        faceAntiSpoofing = false;
    }

    public void setFaceRecognition(boolean faceRecognition)
    {
        this.faceRecognition = faceRecognition;
    }

    public void setFaceAntiSpoofing(boolean faceAntiSpoofing)
    {
        this.faceAntiSpoofing = faceAntiSpoofing;
    }

    public boolean getFaceRecognition()
    {
        return faceRecognition;
    }

    public boolean getFaceAntiSpoofing()
    {
        return faceAntiSpoofing;
    }
}
