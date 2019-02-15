package com.mansourappdevelopment.androidapp.foregroundservice;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String SERVICE_EXTRA = "com.mansourappdevelopment.androidapp.foregroundservice.SERVICE_EXTRA";
    private Button btnStartService;
    private Button btnStopService;
    private EditText txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtContent = (EditText) findViewById(R.id.txtContent);
        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStopService = (Button) findViewById(R.id.btnStopService);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });


        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService();
            }
        });

    }

    private void startService() {
        String content = txtContent.getText().toString();

        Intent intent = new Intent(this, ForegroundService.class);
        intent.putExtra(SERVICE_EXTRA, content);
        //startService(intent);
        ContextCompat.startForegroundService(this, intent);
    }

    private void stopService() {
        Intent intent = new Intent(this, ForegroundService.class);
        stopService(intent);

    }
}
