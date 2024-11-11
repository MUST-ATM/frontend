package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.Type.cardType;

/**
 * @author bywang
 */
public interface ActionService
{
    void setBalance(int userId,cardType cardType,double amount);
}
