package com.example.user.loftmoneytraker.rest;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by user on 03.06.2015.
 */
public class AuthenticatorInterceptor implements ClientHttpRequestInterceptor {
    public static String authToken;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add("authToken", authToken);
        return execution.execute(request, body);
    }
}
