package com.lastroot.basic;

import android.app.Application;

import com.lastroot.basic.network.UserRepository;

/**
 * Created by Truong Quoc Khanh on 2/27/2017.
 */

public class BasicApplication extends Application {
    private static UserRepository sUserRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        sUserRepository = new UserRepository(getApplicationContext());
    }

    public static UserRepository getUserRepository() {
        return sUserRepository;
    }
}
