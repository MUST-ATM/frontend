package com.must.atm.mustatm.Service;

import java.awt.image.BufferedImage;


/**
 * Verification Service
 * @author bywang
 */
public interface VerificationService
{

    String faceRecognition(BufferedImage image);

    boolean faceAntiSpoofing(BufferedImage image) throws Exception;
}
