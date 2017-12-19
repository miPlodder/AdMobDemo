package com.example.saksham.admobdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    AdView mAddView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //using demo app id
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        mAddView = (AdView) findViewById(R.id.banner);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice("CA1F2F56DD759BF77553C493558386AA").build();
        mAddView.loadAd(adRequest);

        ((Button)findViewById(R.id.btnNext)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(
                        new Intent(
                                MainActivity.this,
                                InterstitialActivity.class
                        )
                );

            }
        });

    }
}
