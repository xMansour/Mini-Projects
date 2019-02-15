package com.mansourappdevelopment.androidapp.notificationchannels;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.mansourappdevelopment.androidapp.notificationchannels.NotificationChannelCreator.CHANNEL_1_ID;
import static com.mansourappdevelopment.androidapp.notificationchannels.NotificationChannelCreator.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private EditText txtTitle;
    private EditText txtMessage;
    private Button btnChannel1;
    private Button btnChannel2;

    private NotificationManagerCompat notificationManagerCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        notificationManagerCompat = NotificationManagerCompat.from(this);


        txtTitle = (EditText) findViewById(R.id.txtTitle);
        txtMessage = (EditText) findViewById(R.id.txtMessage);
        btnChannel1 = (Button) findViewById(R.id.btnChannel1);
        btnChannel2 = (Button) findViewById(R.id.btnChannel2);

        btnChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1();
            }
        });

        btnChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel2();
            }
        });
    }

    private void sendOnChannel1() {
        String title = txtTitle.getText().toString();
        String message = txtMessage.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_remove_red_eye_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_SERVICE)
                .build();


        notificationManagerCompat.notify(1, notification);
    }

    private void sendOnChannel2() {

        String title = txtTitle.getText().toString();
        String message = txtMessage.getText().toString();
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_remove_red_eye)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_SERVICE)
                .build();


        notificationManagerCompat.notify(2, notification);

    }
}
