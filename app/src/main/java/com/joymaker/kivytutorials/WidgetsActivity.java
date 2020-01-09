package com.joymaker.kivytutorials;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class WidgetsActivity extends AppCompatActivity {
    private ListView widgetsListView;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        widgetsListView = findViewById(R.id.widgetsListView);
        setTitle("Виджеты");
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        String[] widgets = {"Accordion","Button","Carousel","Check Box","Code Input","Color Picker","Image","Label","Slider","Text Input","Modal View", "Spinner", "Switch"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,widgets);
        widgetsListView.setAdapter(arrayAdapter);
        widgetsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i) {
                    case 0:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent (WidgetsActivity.this, DetailWidgetActivity.class);
                        intent.putExtra("widget",i);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(WidgetsActivity.this,MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
