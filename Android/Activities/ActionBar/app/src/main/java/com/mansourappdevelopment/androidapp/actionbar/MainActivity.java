package com.mansourappdevelopment.androidapp.actionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnOpenSecondaryActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpenSecondaryActivity = (Button) findViewById(R.id.btnOpenSecondaryActivity);
        btnOpenSecondaryActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                startActivity(intent);
            }
        });
    }
}
