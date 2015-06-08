package com.example.user.loftmoneytraker.auth;

/**
 * Created by Admin on 07-Jun-15.
 */

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AuthService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new Authenticator(this).getIBinder();
    }
}