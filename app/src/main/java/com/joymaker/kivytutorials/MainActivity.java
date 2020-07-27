package com.joymaker.kivytutorials;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.LauncherActivity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

//ca-app-pub-9652455907097724~8649310702
public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private AdView mAdView;
    AlarmManager alarmManager;

    private PendingIntent alarmIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE,1);
        alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        if (System.currentTimeMillis() > calendar.getTimeInMillis()) {
            calendar.add(Calendar.DATE, 1);
        }

        Intent intent = new Intent(this, AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(MainActivity.this, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);



        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);




        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        listView = findViewById(R.id.listView);
        setTitle("Справочник Kivy Python");
        String[] kivyList = {"Установка Kivy",
                             "Первое приложение",
                             "Настройка размера экрана",
                             "Размер и позиционирование",
                             "Layouts(Макеты)",
                             "Виджеты",
                             "Kv Design Language",
                            "Примеры приложений"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,kivyList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch (i) {
                    case 0:
                        intent = new Intent (MainActivity.this, DetailActivity.class);
                        intent.putExtra("setup",i);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent (MainActivity.this, DetailActivity.class);
                        intent.putExtra("setup",i);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent (MainActivity.this, DetailActivity.class);
                        intent.putExtra("setup",i);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent (MainActivity.this, DetailActivity.class);
                        intent.putExtra("setup",i);
                        startActivity(intent);
                        break;
                    case 4:
                        Intent intentLayouts = new Intent(MainActivity.this,LayoutsActivity.class);
                        startActivity(intentLayouts);
                        break;
                    case 5:
                        Intent intentWidgets = new Intent(MainActivity.this,WidgetsActivity.class);
                        startActivity(intentWidgets);
                        break;
                    case 6:
                        Intent kvIntent = new Intent(MainActivity.this,KivyDesignLanguageActivity.class);
                        startActivity(kvIntent);
                        break;
                    case 7:
                        Intent exIntent = new Intent(MainActivity.this,ExampleActivity.class);
                        startActivity(exIntent);
                        break;

                }
            }
        });
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "name", NotificationManager.IMPORTANCE_DEFAULT);
             channel.setDescription("dfsdfsf");
             channel.setShowBadge(true);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
