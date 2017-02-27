package com.lastroot.basic.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.lastroot.basic.R;
import com.lastroot.basic.model.UserResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {
    private static final String TAG = ResultActivity.class.getCanonicalName();

    @BindView(R.id.access_token_textview)
    TextView mAccessTokenView;

    private static final String ACCESS_TOKEN = "access_token";

    public static Intent newIntent(Context context, UserResponse userResponse) {
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra(ACCESS_TOKEN, userResponse.getAccessToken());
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null && mAccessTokenView != null) {
            String accessToken = intent.getStringExtra(ACCESS_TOKEN);
            Log.d(TAG, "Access token " + accessToken);
            mAccessTokenView.setText(accessToken);
        }
    }
}
