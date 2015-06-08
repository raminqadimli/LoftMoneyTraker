package com.example.user.loftmoneytraker.rest;

import com.example.user.loftmoneytraker.auth.SessionManager;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by user on 03.06.2015.
 */
@EBean
public class AuthenticatorInterceptor implements ClientHttpRequestInterceptor {
    public static String authToken;

    @Bean
    SessionManager sessionManager;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add("authToken", sessionManager.getAuthToken());
        return execution.execute(request, body);
    }
}
