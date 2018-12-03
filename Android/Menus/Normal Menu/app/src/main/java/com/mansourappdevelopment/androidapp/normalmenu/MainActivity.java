package com.mansourappdevelopment.androidapp.normalmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Item 1 Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "Item 2 Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "Item 3 Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.upload:
                Toast.makeText(this, "Upload Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.download:
                Toast.makeText(this, "Download Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkable1:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                break;
            case R.id.checkable2:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                break;
            case R.id.checkable3:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                break;
            case R.id.singlecheckable1:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                break;
            case R.id.singlecheckable2:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                break;
            case R.id.singlecheckable3:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
