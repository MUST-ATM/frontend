package com.must.atm.mustatm.Service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CameraServiceImplTest
{
    @Test
    @DisplayName("Test camera capture")
    void capture()
    {
        CameraServiceImpl cameraService = new CameraServiceImpl();
        assertDoesNotThrow(cameraService::capture);
    }
}