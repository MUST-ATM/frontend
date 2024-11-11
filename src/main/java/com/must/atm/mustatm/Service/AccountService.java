package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.Type.cardType;
import javafx.scene.image.Image;

/**
 * @author bywang
 */
public interface AccountService
{
    String getFaceId(Image image) throws Exception;
    int getUserId(String faceId) throws Exception;
    double getBalance(int userId, cardType cardType) throws Exception;
}
