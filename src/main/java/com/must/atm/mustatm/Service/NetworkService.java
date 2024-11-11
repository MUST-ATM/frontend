package com.must.atm.mustatm.Service;

import java.net.http.HttpResponse;

/**
 * Network service
 * @author bywang
 */
public interface NetworkService
{
    HttpResponse<String>sendImage(String api,byte[] stream) throws Exception;
    HttpResponse<String>request(String api) throws Exception;
    HttpResponse<String> sendJson(String api, String json) throws Exception;
}