package com.must.atm.mustatm.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.must.atm.mustatm.Service.Type.cardType;

import java.awt.image.BufferedImage;

/**
 * Account Service
 * Get FaceId, UserId, and Balance
 * @author bywang
 */
public class AccountServiceImpl implements AccountService
{
    /**
     * Get FaceId
     * @param image The image of the user
     * @return The faceId of the user
     */
    @Override
    public String getFaceId(BufferedImage image)
    {
        VerificationServiceImpl verificationService = new VerificationServiceImpl();
        try
        {
            return verificationService.faceRecognition(image);
        } catch (Exception e)
        {
            System.out.println("Face Recognition Failed");
            throw new RuntimeException(e);
        }
    }
    /**
     * Get UserId
     * @param faceId The faceId of the user
     * @return The userId of the user
     */
    @Override
    public int getUserId(String faceId)
    {
        NetworkServiceImpl networkService = new NetworkServiceImpl();
        String rawUserId;
        try
        {
            rawUserId = networkService.request("/account/face/"+faceId).body();
        } catch (Exception e)
        {
            System.out.println("UserID Request Failed");
            throw new RuntimeException(e);
        }
        //Json to Object
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            return mapper.readTree(rawUserId).get("userID").asInt();
        } catch (JsonProcessingException e)
        {
            System.out.println("Json Processing Failed");
            throw new RuntimeException(e);
        }
    }
    /**
     * Get Balance
     * @param userId The userId of the user
     * @param currency The currency of the card
     * @return The balance of the user
     */
    @Override
    public double getBalance(int userId, cardType currency)
    {
        NetworkServiceImpl networkService = new NetworkServiceImpl();
        String balance;
        try
        {
            balance = networkService.request("/account/card/"+userId+"/"+currency).body();
        } catch (Exception e)
        {
            System.out.println("Balance Request Failed");
            throw new RuntimeException(e);
        }
        //Json to Object
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            return mapper.readTree(balance).get("balance").asDouble();
        } catch (JsonProcessingException e)
        {
            System.out.println("Json Processing Failed");
            throw new RuntimeException(e);
        }
    }

}