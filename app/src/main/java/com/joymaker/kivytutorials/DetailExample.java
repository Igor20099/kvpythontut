package com.joymaker.kivytutorials;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class DetailExample extends AppCompatActivity {
    private WebView detailExampleWebView;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_example);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView9);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        detailExampleWebView = findViewById(R.id.detailExampleWeb);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        WebSettings settings = detailExampleWebView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        Intent intent = getIntent();
        int index = intent.getIntExtra("example",-1);
        switch (index) {
            case 0:
                detailExampleWebView.loadUrl("file:///android_asset/examples/convertorkg.html");
                setTitle("Перевод килограммов в граммы");
                break;
            case 1:
                detailExampleWebView.loadUrl("file:///android_asset/examples/timer.html");
                setTitle("Таймер");
                break;
            case 2:
                detailExampleWebView.loadUrl("file:///android_asset/examples/calc.html");
                setTitle("Простой калькулятор");
                break;
            case 3:
                detailExampleWebView.loadUrl("file:///android_asset/examples/player.html");
                setTitle("Простой аудиоплеер");
                break;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(DetailExample.this,ExampleActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
