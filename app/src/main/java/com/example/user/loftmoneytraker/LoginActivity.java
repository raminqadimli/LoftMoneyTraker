package com.example.user.loftmoneytraker;

/**
 * Created by Admin on 07-Jun-15.
 */

import android.accounts.AccountAuthenticatorActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.loftmoneytraker.auth.SessionManager;
import com.example.user.loftmoneytraker.rest.AuthResult;
import com.example.user.loftmoneytraker.rest.RestClient;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

@EActivity(R.layout.login)
public class LoginActivity extends AccountAuthenticatorActivity {

    @RestService
    RestClient api;

    @ViewById
    TextView login, password;

    @Bean
    SessionManager sessionManager;

    @Click
    void okClicked() {
        login();
    }

    @Background
    void login() {
        final String loginName = this.login.getText().toString();
        final AuthResult loginResult = api.login(loginName, password.getText().toString());
        handleLoginResult(loginName, loginResult);
    }

    @UiThread
    void handleLoginResult(String loginName, AuthResult loginResult) {
        if (loginResult.isSuccess()) {
            sessionManager.createAccount(loginName, loginResult.getAuthToken());
            setAccountAuthenticatorResult(new Bundle());
            finish();
        } else
            Toast.makeText(this, R.string.login_error, Toast.LENGTH_LONG).show();
    }
}