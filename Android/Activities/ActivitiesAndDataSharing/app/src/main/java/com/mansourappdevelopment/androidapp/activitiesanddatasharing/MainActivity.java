package com.mansourappdevelopment.androidapp.activitiesanddatasharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.mansourappdevelopment.androidapp.activitiesanddatasharing.EXTRA_TEXT";
    private Button btnSendToSecondary;
    private EditText txtMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMain = (EditText) findViewById(R.id.txtMain);
        btnSendToSecondary = (Button) findViewById(R.id.btnSendToSecondary);
        btnSendToSecondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondaryActivity();
            }
        });


    }

    private void openSecondaryActivity() {
        String text = txtMain.getText().toString();
        Intent intent = new Intent(this, SecondaryActivity.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }
}
