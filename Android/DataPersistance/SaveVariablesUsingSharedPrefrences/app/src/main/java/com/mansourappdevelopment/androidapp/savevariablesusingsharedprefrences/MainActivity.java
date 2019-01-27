package com.mansourappdevelopment.androidapp.savevariablesusingsharedprefrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "com.mansourappdevelopment.androidapp.savevariablesusingsharedprefrences.SHARED_PREFS";
    public static final String SHARED_TEXT = "com.mansourappdevelopment.androidapp.savevariablesusingsharedprefrences.SHARED_TEXT";
    private EditText txtMain;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMain = (EditText) findViewById(R.id.txtMain);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        loadData();

    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SHARED_TEXT, txtMain.getText().toString());
        editor.apply();

    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String text = sharedPreferences.getString(SHARED_TEXT, "");
        txtMain.setText(text);
    }
}
