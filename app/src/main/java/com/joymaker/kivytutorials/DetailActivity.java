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

public class DetailActivity extends AppCompatActivity {
    private WebView detailWebView;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        detailWebView = findViewById(R.id.detailWebView);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        WebSettings settings = detailWebView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        Intent intent = getIntent();
        int index = intent.getIntExtra("setup",-1);
        switch (index) {
            case 0:
                detailWebView.loadUrl("file:///android_asset/setup.html");
                setTitle("Установка Kivy");
                break;
            case 1:
                detailWebView.loadUrl("file:///android_asset/firstapp.html");
                setTitle("Первое приложение");
                break;
            case 2:
                detailWebView.loadUrl("file:///android_asset/configscreen.html");
                setTitle("Настройка размера экрана");
                break;
            case 3:
                detailWebView.loadUrl("file:///android_asset/sizepos.html");
                setTitle("Размеры и позиционирование");
                break;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
