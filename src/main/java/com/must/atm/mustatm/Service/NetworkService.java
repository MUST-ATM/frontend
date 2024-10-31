package com.must.atm.mustatm.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

/**
 * @author bywang
 */
public interface NetworkService
{
    HttpResponse<String>sendImage(String api,byte[] stream) throws Exception;
    HttpResponse<String>request(String api) throws Exception;
}
