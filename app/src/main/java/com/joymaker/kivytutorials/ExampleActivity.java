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

public class ExampleActivity extends AppCompatActivity {
    private ListView exampleListView;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView8);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        exampleListView = findViewById(R.id.exampleListView);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        String[] layouts = {"Перевод килограммов в граммы","Таймер","Простой калькулятор","Простой аудиоплеер"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,layouts);
        exampleListView.setAdapter(arrayAdapter);
        setTitle("Примеры приложений");
        exampleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i) {
                    case 0:
                        intent = new Intent (ExampleActivity.this, DetailExample.class);
                        intent.putExtra("example",i);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent (ExampleActivity.this, DetailExample.class);
                        intent.putExtra("example",i);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent (ExampleActivity.this, DetailExample.class);
                        intent.putExtra("example",i);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent (ExampleActivity.this, DetailExample.class);
                        intent.putExtra("example",i);
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
                Intent intent = new Intent(ExampleActivity.this,MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
