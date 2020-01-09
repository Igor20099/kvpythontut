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

public class KivyDesignLanguageActivity extends AppCompatActivity {
    private ListView kvDesignListView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kivy_design_language);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView7);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        kvDesignListView = findViewById(R.id.kivyDesignListVIew);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        String[] kvItems = {"Введение","Первое приложение с Kv Design Language","Класс Builder"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,kvItems);
        kvDesignListView.setAdapter(arrayAdapter);
        setTitle("Kv Design Language");
        kvDesignListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i) {
                    case 0:
                        intent = new Intent (KivyDesignLanguageActivity.this, DetailKivyDesignLanguageAcitvity.class);
                        intent.putExtra("kv",i);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent (KivyDesignLanguageActivity.this, DetailKivyDesignLanguageAcitvity.class);
                        intent.putExtra("kv",i);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent (KivyDesignLanguageActivity.this, DetailKivyDesignLanguageAcitvity.class);
                        intent.putExtra("kv",i);
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
                Intent intent = new Intent(KivyDesignLanguageActivity.this,MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
