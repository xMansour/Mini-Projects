package com.mansourappdevelopment.androidapp.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondaryActivity extends AppCompatActivity {
    public static final String EXTRA_RESULT = "com.mansourappdevelopment.androidapp.startactivityforresult.EXTRA_RESULT";
    private Button btnAdd;
    private Button btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);

        Intent intent = getIntent();
        final int firstNumber = intent.getIntExtra(MainActivity.EXTRA_FIRST_NUMBER, 0);
        final int secondNumber = intent.getIntExtra(MainActivity.EXTRA_SECOND_NUMBER, 0);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = firstNumber + secondNumber;
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_RESULT, result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = firstNumber - secondNumber;
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_RESULT, result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
