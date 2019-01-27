package com.mansourappdevelopment.androidapp.savearraylistusinggsonandsharedprefrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "com.mansourappdevelopment.androidapp.savearraylistusinggsonandsharedprefrences.SHARED_PREFS";
    public static final String SHARED_LIST = "com.mansourappdevelopment.androidapp.savearraylistusinggsonandsharedprefrences.SHARED_LIST";
    private List<Operation> operations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveData();
        loadData();

    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(operations);
        editor.putString(SHARED_LIST, json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(SHARED_LIST, "");
        Type type = new TypeToken<List<Operation>>() {
        }.getType();
        operations = gson.fromJson(json, type);
    }

}
