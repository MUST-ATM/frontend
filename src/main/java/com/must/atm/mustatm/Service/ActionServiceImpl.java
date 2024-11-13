package com.must.atm.mustatm.Service;

import com.must.atm.mustatm.Service.Type.cardType;

/**
 * Action service
 * @author bywang
 */
public class ActionServiceImpl implements ActionService
{
    /**
     * Set balance
     * @param userId user id
     * @param cardType card type
     * @param amount new balance
     */
    @Override
    public void setBalance(int userId, cardType cardType, double amount)
    {
        if(amount < 0)
        {
            throw new RuntimeException("Amount cannot be negative");
        }
        NetworkServiceImpl networkService = new NetworkServiceImpl();
        try
        {
            var result = networkService.sendJson("/account/balance/change", "{\"userId\":"+userId+",\"currency\":\""+cardType+"\",\"amount\":"+amount+"}");
            if(result.statusCode() != 200)
            {
                throw new RuntimeException("Set balance failed");
            }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}