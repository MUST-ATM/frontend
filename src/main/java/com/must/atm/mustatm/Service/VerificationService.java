package com.must.atm.mustatm.Service;

import javafx.scene.image.Image;

public interface VerificationService
{
    boolean faceRecognition(Image image);
    boolean faceAntiSpoofing(Image image);
    String getFaceId();

}
