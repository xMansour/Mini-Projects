package com.mansourappdevelopment.androidapp.parallelprogrammingwithasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnStart = (Button) findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAsyncTask();
            }
        });
    }

    private void startAsyncTask() {
        MyAsyncTask asyncTask = new MyAsyncTask(this);
        asyncTask.execute(10);

    }

    //Leaving the asyncTask like this could cause memory leak, because the
    //asyncTask has a reference to the main activity, that's why it can access
    //the ui widgets.
    //If the main activity is terminated, this class will cause memory leak.
    //this could be avoided using a static keyword, but will no longer have access
    //to UI widgets.
    //or you can use WeakReference<MainActivity>
    private static class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
        private WeakReference<MainActivity> weakReference;

        MyAsyncTask(MainActivity mainActivity) {
            weakReference = new WeakReference<>(mainActivity);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            MainActivity activity = weakReference.get();
            if (activity == null || activity.isFinishing())
                return;
            activity.progressBar.setVisibility(View.VISIBLE);
        }

        //this is the only method that will run in the background, so you should update the ui in one of the other 3
        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {
                publishProgress((i * 100) / integers[0]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Finished";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            MainActivity activity = weakReference.get();
            if (activity == null || activity.isFinishing())
                return;
            activity.progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            MainActivity activity = weakReference.get();
            if (activity == null || activity.isFinishing())
                return;
            Toast.makeText(activity, "Finished", Toast.LENGTH_SHORT).show();
            activity.progressBar.setProgress(0);
            activity.progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
