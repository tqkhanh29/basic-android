package com.lastroot.basic.ui;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lastroot.basic.BasicApplication;
import com.lastroot.basic.R;
import com.lastroot.basic.model.UserResponse;
import com.lastroot.basic.model.User;
import com.lastroot.basic.util.TextUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_layout_email)
    TextInputLayout mEmailLayout;

    @BindView(R.id.input_email)
    EditText mEmailEditText;

    @BindView(R.id.input_layout_password)
    TextInputLayout mPasswordLayout;

    @BindView(R.id.input_password)
    EditText mPasswordEditText;

    @BindView(R.id.activity_main)
    RelativeLayout mMainLayout;

    private Subscription mSubscription;

    private UserResponse mUserResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSubscription = Subscriptions.empty();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_button)
    void login() {
        final String email = mEmailEditText.getText().toString();
        final String password = mPasswordEditText.getText().toString();

        if (!TextUtil.verifyEmail(email)) {
            mEmailLayout.setError("Email format is not correct!");
            return;
        }

        if (!TextUtil.verifyPassword(password)){
            mPasswordLayout.setError("Please enter password");
            return;
        }

        final User user = new User(email, password);
        mSubscription = BasicApplication.getUserRepository()
                                    .post(user)
                                    .subscribeOn(Schedulers.newThread())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(this::onNext, this::onError, this::onCompleted);

    }

    private void onCompleted() {
        if (mUserResponse != null) {
            Intent intent = ResultActivity.newIntent(this, mUserResponse);
            startActivity(intent);
        }
    }

    private void onError(Throwable e) {
        if (e instanceof HttpException) {
            Response<?> response = ((HttpException) e).response();
            Gson gson = new Gson();

            try {
                String errorJson = response.errorBody().string();
                Error error = gson.fromJson(errorJson, Error.class);
                Snackbar snackbar = Snackbar.make(mMainLayout, error.getMessage(), Snackbar.LENGTH_SHORT);
                snackbar.show();
            } catch (JsonSyntaxException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void onNext(UserResponse userResponse) {
        mUserResponse = userResponse;
    }

    @Override
    protected void onDestroy() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        super.onDestroy();
    }
}
