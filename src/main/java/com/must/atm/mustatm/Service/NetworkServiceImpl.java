package com.must.atm.mustatm.Service;

import java.io.IOException;
import java.net.Authenticator;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @author bywang
 */
public class NetworkServiceImpl implements NetworkService
{
    String server = Init.getProperties().getProperty("server");
    @Override
    public HttpResponse<String> sendImage(String api, byte[] stream) throws Exception
    {
        try
        {
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(20))
                    .authenticator(Authenticator.getDefault())
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(server + api))
                    .POST(HttpRequest.BodyPublishers.ofByteArray(stream))
                    .build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public HttpResponse<String> request(String api) throws Exception
    {
        try
        {
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(20))
                    .authenticator(Authenticator.getDefault())
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(server + api))
                    .GET()
                    .build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }
}
