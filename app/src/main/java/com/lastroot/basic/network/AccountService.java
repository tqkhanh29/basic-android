package com.lastroot.basic.network;

import com.lastroot.basic.model.UserResponse;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Truong Quoc Khanh on 2/24/2017.
 */

public interface AccountService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    @FormUrlEncoded
    @POST("oauth2/token")
    Observable<UserResponse> login(@FieldMap Map<String, String> queryMap);
}
