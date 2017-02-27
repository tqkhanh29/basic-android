package com.lastroot.basic.network;

import android.content.Context;
import android.support.annotation.NonNull;

import com.lastroot.basic.R;
import com.lastroot.basic.model.UserResponse;
import com.lastroot.basic.model.User;

import rx.Observable;

/**
 * Created by Truong Quoc Khanh on 2/24/2017.
 */

public class UserRepository {
    private static final String TAG = UserRepository.class.getSimpleName();

    private AccountService mAccountService;

    public UserRepository(@NonNull Context context){
        mAccountService = BaseRetrofit.createBase(context.getString(R.string.endpoint)).create(AccountService.class);
    }

    public Observable<UserResponse> post(@NonNull User user) {
        return mAccountService.login(user.getQueryMap());
    }
}
