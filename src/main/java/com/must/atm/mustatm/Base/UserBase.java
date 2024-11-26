package com.must.atm.mustatm.Base;

/**
 * @author bywang
 */
public class UserBase
{
    private int userId;
    private String faceId;

    public UserBase(int userId, String faceId)
    {
        this.userId = userId;
        this.faceId = faceId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getFaceId()
    {
        return faceId;
    }

    public void setFaceId(String faceId)
    {
        this.faceId = faceId;
    }
}
