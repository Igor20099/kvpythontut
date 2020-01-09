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

public class DetailLayoutActivity extends AppCompatActivity {
    private WebView detailLayoutWebView;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_layout);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        detailLayoutWebView = findViewById(R.id.detailLayoutWeb);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        WebSettings settings = detailLayoutWebView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        Intent intent = getIntent();
        int index = intent.getIntExtra("layout",-1);
        switch (index) {
            case 0:
                detailLayoutWebView.loadUrl("file:///android_asset/layouts/anchorlayout.html");
                setTitle("Anchor Layout");
                break;
            case 1:
                detailLayoutWebView.loadUrl("file:///android_asset/layouts/boxlayout.html");
                setTitle("Box Layout");
                break;
            case 2:
                detailLayoutWebView.loadUrl("file:///android_asset/layouts/floatlayout.html");
                setTitle("Float Layout");
                break;
            case 3:
                detailLayoutWebView.loadUrl("file:///android_asset/layouts/relativelayout.html");
                setTitle("Relative Layout");
                break;
            case 4:
                detailLayoutWebView.loadUrl("file:///android_asset/layouts/gridlayout.html");
                setTitle("Grid Layout");
                break;
            case 5:
                detailLayoutWebView.loadUrl("file:///android_asset/layouts/pagelayout.html");
                setTitle("Page Layout");
                break;
            case 6:
                detailLayoutWebView.loadUrl("file:///android_asset/layouts/scatterlayout.html");
                setTitle("Scatter Layout");
                break;
            case 7:
                detailLayoutWebView.loadUrl("file:///android_asset/layouts/stacklayout.html");
                setTitle("Stack Layout");
                break;
            case 8:
                detailLayoutWebView.loadUrl("file:///android_asset/layouts/nestedlayouts.html");
                setTitle("Вложенные макеты");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(DetailLayoutActivity.this,LayoutsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
