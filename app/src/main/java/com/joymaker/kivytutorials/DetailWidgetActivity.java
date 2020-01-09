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

public class DetailWidgetActivity extends AppCompatActivity {
    private WebView detailWidgetWebView;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_widget);
        mAdView = findViewById(R.id.adView6);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        detailWidgetWebView = findViewById(R.id.widgetWebView);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        WebSettings settings = detailWidgetWebView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        Intent intent = getIntent();
        int index = intent.getIntExtra("widget",-1);
        switch (index) {
            case 0:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/accordion.html");
                setTitle("Accordion");
                break;
            case 1:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/button.html");
                setTitle("Button");
                break;
            case 2:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/carousel.html");
                setTitle("Carousel");
                break;
            case 3:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/checkbox.html");
                setTitle("Check Box");
                break;
            case 4:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/codeinput.html");
                setTitle("Code Input");
                break;
            case 5:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/colorpicker.html");
                setTitle("Color Picker");
                break;
            case 6:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/image.html");
                setTitle("Image");
                break;
            case 7:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/label.html");
                setTitle("Label");
                break;
            case 8:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/slider.html");
                setTitle("Slider");
                break;
            case 9:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/textinput.html");
                setTitle("Text Input");
                break;
            case 10:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/modalview.html");
                setTitle("Modal View");
                break;
            case 11:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/spinner.html");
                setTitle("Spinner");
                break;
            case 12:
                detailWidgetWebView.loadUrl("file:///android_asset/widgets/switch.html");
                setTitle("Switch");
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(DetailWidgetActivity.this,WidgetsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
