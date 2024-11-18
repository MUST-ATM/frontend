package com.must.atm.mustatm.Service;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificationServiceImplTest
{

    @Test
    void faceRecognition()
    {
        VerificationServiceImpl verificationService = new VerificationServiceImpl();
        verificationService.faceRecognition(new Image("233.jpg"));
        assertNotEquals(null,verificationService.faceRecognition(new Image("233.jpg")));
    }

    @Test
    void faceAntiSpoofing()
    {
        VerificationServiceImpl verificationService = new VerificationServiceImpl();
        assertDoesNotThrow(()->verificationService.faceAntiSpoofing(new Image("233.jpg")));
    }
}