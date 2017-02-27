package com.lastroot.basic.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Truong Quoc Khanh on 2/24/2017.
 */

public class UserResponse {

    @SerializedName("access_token")
    private String mAccessToken;

    @SerializedName("expires_in")
    private int mExpiresIn;

    @SerializedName("refresh_token")
    private String mRefreshToken;

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
    }

    public int getExpiresIn() {
        return mExpiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        mExpiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return mRefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        mRefreshToken = refreshToken;
    }

}
