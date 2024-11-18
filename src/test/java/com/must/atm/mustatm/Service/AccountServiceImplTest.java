package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.Type.cardType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for AccountServiceImpl
 * User should always be "233"
 */
class AccountServiceImplTest
{
    @Test
    @DisplayName("Test getFaceId")
    void getFaceId()
    {
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.getFaceId(null);
    }
    @Test
    @DisplayName("Test getUserId by FaceId")
    void getUserId()
    {
        AccountServiceImpl accountService = new AccountServiceImpl();

        assertEquals(233,accountService.getUserId("233"));
    }

    @Test
    @DisplayName("get balance with HKD")
    void getBalanceHkd()
    {
        AccountServiceImpl accountService = new AccountServiceImpl();
       assertDoesNotThrow(() -> accountService.getBalance(233, cardType.HKD));
    }
    @Test
    @DisplayName("get balance with USD")
    void getBalanceUsd()
    {
        AccountServiceImpl accountService = new AccountServiceImpl();
       assertDoesNotThrow(() -> accountService.getBalance(233, cardType.OTHER));
    }
    @Test
    @DisplayName("get balance with MOP")
    void getBalanceMop()
    {
        AccountServiceImpl accountService = new AccountServiceImpl();
        assertDoesNotThrow(() -> accountService.getBalance(233, cardType.MOP));
    }

    @AfterAll
    @DisplayName("Test getBalance after set balance to 2333 in HKD")
    static void getBalance()
    {
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.getBalance(233, cardType.HKD);
        assertEquals(2333, accountService.getBalance(233, cardType.HKD));
    }
}