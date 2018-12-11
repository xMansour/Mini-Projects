package com.mansourappdevelopment.androidapp.usingthreads;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mBtnStart;
    private Switch mSwitch;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStart = (Button) findViewById(R.id.btnStart);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRunnable runnable = new myRunnable(10);
                Thread thread = new Thread(runnable);
                thread.start();
            }
        });
        mSwitch = (Switch) findViewById(R.id.switch1);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mSwitch.setText("On");
                } else {
                    mSwitch.setText("Off");
                }
            }
        });
    }

    private class myRunnable implements Runnable {
        private int mSeconds;

        public myRunnable(int seconds) {
            this.mSeconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < mSeconds; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
