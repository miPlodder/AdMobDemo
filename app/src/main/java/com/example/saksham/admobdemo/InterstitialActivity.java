package com.example.saksham.admobdemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;
    public static final String TAG = "InterstitialActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        final AdRequest adRequest = new AdRequest.Builder().addTestDevice("CA1F2F56DD759BF77553C493558386AA").build();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

                Log.d(TAG, "onAdLoaded: ");
                //we need show function to display the app otherwise ad will not be displayed
                mInterstitialAd.show();
            }

            //we need to manually request for second interstitial ad
            @Override
            public void onAdClosed() {
                super.onAdClosed();

                Log.d(TAG, "onAdClosed: ");

                (new CountDownTimer(60000, 100) {

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        mInterstitialAd.loadAd(adRequest);
                    }
                }).start();

            }
        });

    }

}
