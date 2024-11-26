package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Base.UserBase;
import com.must.atm.mustatm.Service.Type.cardType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class IntegrationTest
{
    private static final UserBase user = new UserBase(0, "");
    @BeforeAll
    @DisplayName("Get user")
    static void getUser()
    {
        VerificationServiceImpl verificationService = new VerificationServiceImpl();
        var faceId = "";
        try
        {
            faceId = verificationService.faceRecognition("src/main/resources/topBar.png");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            if (verificationService.faceAntiSpoofing("src/main/resources/topBar.png"))
            {
                user.setFaceId(faceId);
                user.setUserId(new AccountServiceImpl().getUserId(faceId));

            }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    @Test
    @DisplayName("Test deposit function")
    void testDeposit()
    {
        ActionServiceImpl actionService = new ActionServiceImpl();
        //CNY
        actionService.deposit(user.getUserId(), cardType.CNY, 100);
        System.out.println("CNY left: "+new AccountServiceImpl().getBalance(user.getUserId(),cardType.CNY));
        //HKD
        actionService.deposit(user.getUserId(), cardType.HKD,100);
        System.out.println("HKD left: "+new AccountServiceImpl().getBalance(user.getUserId(),cardType.HKD));
        //MOP
        actionService.deposit(user.getUserId(), cardType.MOP,100);
        System.out.println("MOP left: "+new AccountServiceImpl().getBalance(user.getUserId(),cardType.MOP));
    }
    @AfterEach
    @DisplayName("Test withdraw function")
    void testWithdraw()
    {
        ActionServiceImpl actionService = new ActionServiceImpl();
        //CNY
        actionService.withdraw(user.getUserId(), cardType.CNY, 100);
        System.out.println("CNY left: "+new AccountServiceImpl().getBalance(user.getUserId(),cardType.CNY));
        //HKD
        actionService.withdraw(user.getUserId(), cardType.HKD,100);
        System.out.println("HKD left: "+new AccountServiceImpl().getBalance(user.getUserId(),cardType.HKD));
        //MOP
        actionService.withdraw(user.getUserId(), cardType.MOP,100);
        System.out.println("MOP left: "+new AccountServiceImpl().getBalance(user.getUserId(),cardType.MOP));
    }
    @AfterEach
    @DisplayName("check current account balance")
    void  checkAccount()
    {
        AccountServiceImpl accountService = new AccountServiceImpl();
        //CNY
        System.out.println("CNY left: "+accountService.getBalance(user.getUserId(),cardType.CNY));
        //HKD
        System.out.println("HKD left: "+accountService.getBalance(user.getUserId(),cardType.HKD));
        //MOP
        System.out.println("MOP left: "+accountService.getBalance(user.getUserId(),cardType.MOP));
    }


}
