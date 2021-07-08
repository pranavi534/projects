package com.example.graphsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    AdView adView;
    InterstitialAd ad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adView  = findViewById(R.id.adView);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        AdRequest request= new AdRequest.Builder().build();
        adView.loadAd(request);


        ad = new InterstitialAd(this,"ca-app-pub-3940256099942544/1033173712",request,new InterstitialAd);
    }

    public void bar(View view) {
        startActivity(new Intent(this,BarActivity.class));
    }

    public void pie(View view) {
        startActivity(new Intent(this,PieActivity.class));
    }

    public void show(View view) {
    }
}