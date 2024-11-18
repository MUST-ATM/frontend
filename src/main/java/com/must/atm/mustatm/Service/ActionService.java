package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.Type.cardType;

/**
 * @author bywang
 */
public interface ActionService
{
    double deposit(int userId,cardType cardType,double amount);
    double withdraw(int userId,cardType cardType,double amount);
    void setBalance(int userId,cardType cardType,double amount);
}
