package com.joymaker.kivytutorials;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(context,ExampleActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent= PendingIntent.getActivity(context,100,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"CHANNEL_ID").setContentIntent(pendingIntent).
                setSmallIcon(R.drawable.icon1).
                setContentTitle("Примеры приложений на Kivy")
                .setContentText("Посмотрите примеры приложений на Kivy").setAutoCancel(true);
        notificationManager.notify(100, builder.build());
    }
}
