package com.must.atm.mustatm.Base;

import com.must.atm.mustatm.Service.Type.cardType;

/**
 * @author bywang
 */
public class AccountBase extends UserBase
{
    public AccountBase(UserBase user, double balance, cardType account)
    {
        super(user.getUserId(),user.getFaceId());
        this.userId = user.getUserId();
        this.faceId = user.getFaceId();
        this.balance = balance;
        this.account = account;
    }
    private int userId;
    private String faceId;
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

    @Override
    public int getUserId()
    {
        return userId;
    }

    @Override
    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    @Override
    public String getFaceId()
    {
        return faceId;
    }

    @Override
    public void setFaceId(String faceId)
    {
        this.faceId = faceId;
    }
}
