package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.Type.cardType;

import java.awt.image.BufferedImage;

/**
 * @author bywang
 */
public interface AccountService
{

    String getFaceId(BufferedImage image);

    int getUserId(String faceId) throws Exception;
    double getBalance(int userId, cardType cardType) throws Exception;
}
