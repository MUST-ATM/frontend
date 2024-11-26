package com.must.atm.mustatm.Service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificationServiceImplTest
{

    @Test
    @DisplayName("Test faceRecognition method")
    void faceRecognition()
    {
        VerificationServiceImpl verificationService = new VerificationServiceImpl();
        assertDoesNotThrow(()->
                verificationService.faceRecognition("src/main/resources/capture.jpg"));

    }

    @Test
    @DisplayName("Test faceAntiSpoofing method")
    void faceAntiSpoofing()
    {
        VerificationServiceImpl verificationService = new VerificationServiceImpl();
        assertDoesNotThrow(()->
                verificationService.faceAntiSpoofing("src/main/resources/capture.jpg"));
    }
}