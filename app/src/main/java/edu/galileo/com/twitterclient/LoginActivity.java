package edu.galileo.com.twitterclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

public class LoginActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "YrYHZujezbDDoVXqhVZKmbjTk";
    private static final String TWITTER_SECRET = "f04tXShefzWnMGI58kbG33aTpRod2zolIF9JV1U1ZHAmftDjPw";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_login);
    }
}
