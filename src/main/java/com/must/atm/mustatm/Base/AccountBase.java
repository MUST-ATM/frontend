package com.must.atm.mustatm.Base;

import com.must.atm.mustatm.Service.Type.cardType;

/**
 * @author bywang
 */
public class AccountBase extends UserBase
{
    public AccountBase(int userId, String faceId, double balance, cardType account)
    {
        super(userId, faceId);
        this.balance = balance;
        this.account = account;
    }

    private double balance;
    private cardType account;

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public cardType getAccount()
    {
        return account;
    }

    public void setAccount(cardType account)
    {
        this.account = account;
    }
}
