package com.must.atm.mustatm.Service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificationServiceImplTest
{

    @Test
    void faceRecognition()
    {
        VerificationServiceImpl verificationService = new VerificationServiceImpl();
        assertDoesNotThrow(()->
                verificationService.faceRecognition("src/main/resources/capture.jpg"));

    }

    @Test
    void faceAntiSpoofing()
    {
        VerificationServiceImpl verificationService = new VerificationServiceImpl();
        assertDoesNotThrow(()->
                verificationService.faceAntiSpoofing("src/main/resources/capture.jpg"));
    }
}