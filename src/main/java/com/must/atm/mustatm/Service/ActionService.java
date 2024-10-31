package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.cards.cardType;

import java.util.HashMap;

/**
 * @author bywang
 */
public interface ActionService
{
    int getCardId(HashMap<cardType, Integer> cards);
    double getBalance(int userId,cardType cardType);
}
