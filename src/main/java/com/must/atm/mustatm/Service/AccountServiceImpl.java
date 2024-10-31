package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.cards.cardType;
import javafx.scene.image.Image;

import java.net.http.HttpResponse;
import java.util.HashMap;

/**
 * @author bywang
 */
public class AccountServiceImpl implements AccountService
{

    @Override
    public String getFaceId(Image image) throws Exception
    {
        VerificationServiceImpl verificationService = new VerificationServiceImpl();
        var faceId = verificationService.faceRecognition(image);
        if (faceId != null)
        {
            return faceId;
        }
        else
        {
            return null;
        }
    }
    @Override
    public int getUserId(String faceId) throws Exception
    {
        NetworkServiceImpl networkService = new NetworkServiceImpl();
        var rawUserId = networkService.request("/account/face/"+faceId).body();
        //TODO: convert rawUserId to UserId
        return 0;
    }
    @Override
    public HashMap<String,String> resolveRawInfo(HttpResponse<String> rawInfo)
    {
        return null;
    }
    @Override
    public String getUserName(int userId)
    {
        return "";
    }

    @Override
    public HashMap<cardType, Integer> getCardsId(int userId)
    {
        return null;
    }

    @Override
    public double getBalance(int cardId)
    {
        return 0;
    }
}
