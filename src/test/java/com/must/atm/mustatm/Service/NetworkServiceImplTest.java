package com.must.atm.mustatm.Service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class NetworkServiceImplTest
{

    @Test
    @DisplayName("Test request")
    void request()
    {
        NetworkServiceImpl networkService = new NetworkServiceImpl();
        assertDoesNotThrow(() -> networkService.request("/ping"));
    }

    @Test
    @DisplayName("Test sendJson")
    void sendJson()
    {
        NetworkServiceImpl networkService = new NetworkServiceImpl();
        assertDoesNotThrow(() -> networkService.sendJson("/ping/", "test"));
    }
}