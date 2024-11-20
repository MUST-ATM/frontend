package com.must.atm.mustatm.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpResponse;

import static com.must.atm.mustatm.Service.utils.bufferToByte;

/**
 * Verification Service
 * This service is used to verify the user's identity
 * It includes two methods: faceRecognition and faceAntiSpoofing
 * @author bywang
 */
public class VerificationServiceImpl implements VerificationService
{
    /**
     * Face Recognition
     * @param imagePath The image path of the user
     * @return The faceId of the user
     */
    @Override
    public String faceRecognition(String imagePath) throws IOException
    {
        var image = ImageIO.read(new File(imagePath));
        NetworkServiceImpl request = new NetworkServiceImpl();
        HttpResponse<String> response;
        try
        {
            response = request.sendImage("/upload/face-reco", bufferToByte(image));
        } catch (Exception e)
        {
            System.out.println("Face Recognition Failed");
            throw new RuntimeException(e);
        }
        if(response.statusCode()==200)
        {
            ObjectMapper mapper = new ObjectMapper();
            try
            {
                return mapper.readTree(response.body()).get("username").asText();
            } catch (JsonProcessingException e)
            {
                System.out.println("Json Processing Failed");
                throw new RuntimeException(e);
            }
        }
        else
        {
            return null;
        }
    }
    /**
     * Face Anti-Spoofing
     * @param imagePath The image of the user
     * @return True if the image is real, False if the image is fake
     */
    @Override
    public boolean faceAntiSpoofing(String imagePath) throws Exception
    {
        var image = ImageIO.read(new File(imagePath));
        NetworkServiceImpl request = new NetworkServiceImpl();
        var response = request.sendImage("/upload/face-anti", bufferToByte(image));
        return response.statusCode() == 200;
    }

}