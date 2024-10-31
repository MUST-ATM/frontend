package com.must.atm.mustatm.Service;

import javafx.scene.image.Image;


/**
 * @author bywang
 */
public class VerificationServiceImpl implements VerificationService
{
    @Override
    public String faceRecognition(Image image) throws Exception
    {
        NetworkServiceImpl request = new NetworkServiceImpl();
        var response = request.sendImage("/upload/face-reco",imageBuffer(image));
        if(response.statusCode()==200)
        {
            //TODO: After real test, the body should change to "faceId"
            return response.body();
        }
        else
        {
            return null;
        }
    }
    @Override
    public boolean faceAntiSpoofing(Image image) throws Exception
    {
        NetworkServiceImpl request = new NetworkServiceImpl();
        var response = request.sendImage("/upload/face-anti",imageBuffer(image));
        return response.statusCode() == 200;
    }

    private byte[] imageBuffer(Image image)
    {
        int w = (int)image.getWidth();
        int h = (int)image.getHeight();
        return new byte[w * h * 4];
    }
}
