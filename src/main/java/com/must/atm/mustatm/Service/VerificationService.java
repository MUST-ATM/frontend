package com.must.atm.mustatm.Service;

import java.io.IOException;


/**
 * Verification Service
 * @author bywang
 */
public interface VerificationService
{

    String faceRecognition(String image) throws IOException;
    boolean faceAntiSpoofing(String imagePath) throws Exception;
}
