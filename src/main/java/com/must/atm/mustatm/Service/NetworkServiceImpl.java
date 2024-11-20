package com.must.atm.mustatm.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author bywang
 */
public class NetworkServiceImpl implements NetworkService
{
    String server = Init.getProperties().getProperty("server");
    /**
     * Send image to server
     * @param api api address
     * @param stream image stream
     * @return rawFaceId
     * @throws Exception exception
     */
    @Override
    public HttpResponse<String> sendImage(String api, byte[] stream) throws Exception
    {
        try
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(server + api))
                    .version(HttpClient.Version.HTTP_1_1)
                    .POST(HttpRequest.BodyPublishers.ofByteArray(stream))
                    .build();
            try(var client = HttpClient.newHttpClient())
            {
                return client.send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (Exception e)
            {
                throw new Exception(e.getMessage());
            }
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }
    /**
     * Send request to server
     * @param api api address
     * @return response from server
     * @throws Exception exception
     */
    @Override
    public HttpResponse<String> request(String api) throws Exception
    {
        try
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(server + api))
                    .version(HttpClient.Version.HTTP_1_1)
                    .GET()
                    .build();
            try(var client = HttpClient.newHttpClient())
            {
                return client.send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (Exception e)
            {
                throw new Exception(e.getMessage());
            }
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }
    /**
     * Send json to server
     * @param api api address
     * @param json json string
     * @return response from server
     * @throws Exception exception
     */
    @Override
    public HttpResponse<String> sendJson(String api, String json) throws Exception
    {
        try
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(server + api))
                    .version(HttpClient.Version.HTTP_1_1)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
            try(var client = HttpClient.newHttpClient())
            {
                return client.send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (Exception e)
            {
                throw new Exception(e.getMessage());
            }
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }
}
