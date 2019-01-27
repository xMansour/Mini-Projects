package com.mansourappdevelopment.androidapp.startactivityforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_FIRST_NUMBER = "com.mansourappdevelopment.androidapp.startactivityforresult.EXTRA_FIRST_NUMBER";
    public static final String EXTRA_SECOND_NUMBER = "com.mansourappdevelopment.androidapp.startactivityforresult.EXTRA_SECOND_NUMBER";
    public static final int REQUEST_CODE = 1;
    private Button btnGetResult;
    private EditText txtFirstNumber;
    private EditText txtSecondNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFirstNumber = (EditText) findViewById(R.id.txtFirstNum);
        txtSecondNumber = (EditText) findViewById(R.id.txtSecondNum);
        btnGetResult = (Button) findViewById(R.id.btnGetResult);
        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt(txtFirstNumber.getText().toString());
                int secondNumber = Integer.parseInt(txtSecondNumber.getText().toString());
                Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
                intent.putExtra(EXTRA_FIRST_NUMBER, firstNumber);
                intent.putExtra(EXTRA_SECOND_NUMBER, secondNumber);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            int result = data.getIntExtra(SecondaryActivity.EXTRA_RESULT, 0);
            btnGetResult.setText(String.valueOf(result));
        }
    }
}
