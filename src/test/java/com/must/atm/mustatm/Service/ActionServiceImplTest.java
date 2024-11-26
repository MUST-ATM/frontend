package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.Type.cardType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionServiceImplTest
{

    @Test
    @DisplayName("Test deposit")
    void deposit()
    {
        ActionServiceImpl actionService = new ActionServiceImpl();
        assertDoesNotThrow(() -> actionService.deposit(233, cardType.HKD, 233));
    }

    @Test
    @DisplayName("Test withdraw")
    void withdraw()
    {
        ActionServiceImpl actionService = new ActionServiceImpl();
        assertDoesNotThrow(() -> actionService.withdraw(233, cardType.HKD, 233));
    }

    @AfterEach
    @DisplayName("Test set balance to 2333 in HKD")
    void setBalance()
    {
        ActionServiceImpl actionService = new ActionServiceImpl();
        assertDoesNotThrow(() -> actionService.setBalance(233, cardType.HKD, 2333));
    }
}