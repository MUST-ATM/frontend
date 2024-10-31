package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.cards.cardType;
import javafx.scene.image.Image;

import java.net.http.HttpResponse;
import java.util.HashMap;

/**
 * @author bywang
 */
public interface AccountService
{
    String getFaceId(Image image) throws Exception;
    int getUserId(String faceId) throws Exception;
    String getUserName(int userId);
    HashMap<cardType,Integer> getCardsId(int userId);
    double getBalance(int cardId);
    HashMap<String,String>resolveRawInfo(HttpResponse<String> rawInfo);
    //TODO: getRawInfo, RawInfo need to be defined
}
