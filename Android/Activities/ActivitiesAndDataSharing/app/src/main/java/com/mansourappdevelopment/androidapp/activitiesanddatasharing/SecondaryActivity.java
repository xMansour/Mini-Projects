package com.mansourappdevelopment.androidapp.activitiesanddatasharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    private TextView txtSecondary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        txtSecondary = (TextView) findViewById(R.id.txtSecondary);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        txtSecondary.setText(text);

    }
}
