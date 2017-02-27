package com.lastroot.basic.model;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Truong Quoc Khanh on 2/27/2017.
 */

public class User {

    private String mEmail;

    private String mPassword;

    public User(@NonNull String email, @NonNull String password) {
        mEmail = email;
        mPassword = password;
    }

    public Map<String, String> getQueryMap() {
        Map<String, String> map = new HashMap<>();
        map.put("grant_type", "password");

        if (mEmail != null) {
            map.put("username", mEmail);
        }

        if (mPassword != null) {
            map.put("password", mPassword);
        }

        return map;
    }
}
