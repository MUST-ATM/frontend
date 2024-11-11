package com.must.atm.mustatm.Service;

import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URISyntaxException;

public interface VerificationService
{
    String faceRecognition(Image image) throws Exception;
    boolean faceAntiSpoofing(Image image) throws Exception;

}
