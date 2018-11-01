package com.example.androidbti.exemploaulanotificacao;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notify(View view){

        Notification.Builder builder = new Notification.Builder(this, NotificationUtils.getChannelID(this));

        builder.setSmallIcon(android.R.drawable.sym_action_chat);

        Notification.BigTextStyle style = new Notification.BigTextStyle()
                .setBigContentTitle("Titulo")
                .bigText("Texto da minha notificacao");

        builder.setStyle(style);

        //Icon icon = Icon.createWithResource(this, android.R.drawable.ic_menu_view);
        Intent intent1 = new Intent(this, NotificationReceiver.class);
        intent1.setAction(NotificationReceiver.ACTION_BUTTON_1);

        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(this, 0, intent1, 0);


        Notification.Action action1 = new Notification
                .Action
                .Builder(Icon.createWithResource(this, android.R.drawable.ic_menu_view), "Botão 1", pendingIntent1 )
                .build();

        Intent intent2 = new Intent(this, NotificationReceiver.class);
        intent1.setAction(NotificationReceiver.ACTION_BUTTON_2);

        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent1, 0);


        Notification.Action action2 = new Notification
                .Action
                .Builder(Icon.createWithResource(this, android.R.drawable.ic_menu_view), "Botão 2", pendingIntent2 )
                .build();

        builder.addAction(action1);
        builder.addAction(action2);







        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(50, notification);
    }
}
