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

public class DetailKivyDesignLanguageAcitvity extends AppCompatActivity {

    private WebView detailKvWebView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kivy_design_language_acitvity);

        detailKvWebView = findViewById(R.id.detailKvWebView);
        mAdView = findViewById(R.id.adView8);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        WebSettings settings = detailKvWebView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        Intent intent = getIntent();
        int index = intent.getIntExtra("kv",-1);
        switch (index) {
            case 0:
                detailKvWebView.loadUrl("file:///android_asset/kivydesign/introkvdesign.html");
                setTitle("Введение");
                break;
            case 1:
                detailKvWebView.loadUrl("file:///android_asset/kivydesign/firstappkv.html");
                setTitle("Первое приложение с Kv Design Language");
                break;
            case 2:
                detailKvWebView.loadUrl("file:///android_asset/kivydesign/classbuilder.html");
                setTitle("Класс Builder");
                break;
            case 3:
                detailKvWebView.loadUrl("file:///android_asset/kivydesign/id.html");
                setTitle("Атрибут id");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(DetailKivyDesignLanguageAcitvity.this,KivyDesignLanguageActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
