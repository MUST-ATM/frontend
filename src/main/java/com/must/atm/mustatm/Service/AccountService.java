package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.Type.cardType;

/**
 * @author bywang
 */
public interface AccountService
{

    String getFaceId(String imagePath);

    int getUserId(String faceId) throws Exception;
    double getBalance(int userId, cardType cardType) throws Exception;
}
