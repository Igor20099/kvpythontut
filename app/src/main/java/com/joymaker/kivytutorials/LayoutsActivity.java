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

public class LayoutsActivity extends AppCompatActivity {
    private ListView layoutsListView;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        layoutsListView = findViewById(R.id.layoutsListView);
        ActionBar actionBar =getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        String[] layouts = {"Anchor Layout","Box Layout","Float Layout","Relative Layout","Grid Layout","Page Layout","Scatter Layout","Stack Layout","Вложенные макеты"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,layouts);
        layoutsListView.setAdapter(arrayAdapter);
        setTitle("Layouts(Макеты)");
        layoutsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i) {
                    case 0:
                        intent = new Intent (LayoutsActivity.this, DetailLayoutActivity.class);
                        intent.putExtra("layout",i);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent (LayoutsActivity.this, DetailLayoutActivity.class);
                        intent.putExtra("layout",i);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent (LayoutsActivity.this, DetailLayoutActivity.class);
                        intent.putExtra("layout",i);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent (LayoutsActivity.this, DetailLayoutActivity.class);
                        intent.putExtra("layout",i);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent (LayoutsActivity.this, DetailLayoutActivity.class);
                        intent.putExtra("layout",i);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent (LayoutsActivity.this, DetailLayoutActivity.class);
                        intent.putExtra("layout",i);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent (LayoutsActivity.this, DetailLayoutActivity.class);
                        intent.putExtra("layout",i);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent (LayoutsActivity.this, DetailLayoutActivity.class);
                        intent.putExtra("layout",i);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent (LayoutsActivity.this, DetailLayoutActivity.class);
                        intent.putExtra("layout",i);
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
                Intent intent = new Intent(LayoutsActivity.this,MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
