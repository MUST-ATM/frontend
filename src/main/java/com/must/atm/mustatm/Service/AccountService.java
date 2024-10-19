package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.cards.cardType;

import java.util.HashMap;

/**
 * @author bywang
 */
public interface AccountService
{
    int getUserId(String faceId);
    String getUserName(int userId);
    HashMap<cardType,Integer> getCardsId(int userId);
    double getBalance(int cardId);
    //TODO: getRawInfo, RawInfo need to be defined
}
