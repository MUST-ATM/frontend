package com.must.atm.mustatm.Service;

import javafx.scene.image.Image;


/**
 * Verification Service
 * @author bywang
 */
public interface VerificationService
{
    String faceRecognition(Image image) throws Exception;
    boolean faceAntiSpoofing(Image image) throws Exception;

}
