package com.must.atm.mustatm.Service;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class VerificationServiceImplTest
{

    @Test
    void faceRecognition()
    {
        VerificationServiceImpl verificationService = new VerificationServiceImpl();
        assertDoesNotThrow(()->
                verificationService.faceRecognition(ImageIO.read(new File("src/main/resources/capture.jpg"))));

    }

    @Test
    void faceAntiSpoofing()
    {
        VerificationServiceImpl verificationService = new VerificationServiceImpl();
        assertDoesNotThrow(()->
                verificationService.faceAntiSpoofing(ImageIO.read(new File("src/main/resources/capture.jpg"))));
    }
}