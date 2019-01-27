package com.mansourappdevelopment.androidapp.sqliteandrececlerview;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.BaseColumns._ID;
import static com.mansourappdevelopment.androidapp.sqliteandrececlerview.ItemContract.ItemEntry.COLUMN_AMOUNT;
import static com.mansourappdevelopment.androidapp.sqliteandrececlerview.ItemContract.ItemEntry.COLUMN_NAME;
import static com.mansourappdevelopment.androidapp.sqliteandrececlerview.ItemContract.ItemEntry.COLUMN_TIMESTAMP;
import static com.mansourappdevelopment.androidapp.sqliteandrececlerview.ItemContract.ItemEntry.TABLE_NAME;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase database;
    private EditText txtItemName;
    private TextView txtItemCount;
    private Button btnInc;
    private Button btnDec;
    private Button btnAdd;
    private int count = 0;
    private ItemAdapter itemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemDBHelper dbHelper = new ItemDBHelper(this);
        database = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemAdapter = new ItemAdapter(this, getAllItems());
        recyclerView.setAdapter(itemAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                removeItem((long) viewHolder.itemView.getTag());
            }
        }).attachToRecyclerView(recyclerView);

        txtItemName = (EditText) findViewById(R.id.txtItemName);
        txtItemCount = (TextView) findViewById(R.id.txtItemCount);
        btnInc = (Button) findViewById(R.id.btnInc);
        btnDec = (Button) findViewById(R.id.btnDec);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increase();
            }
        });


        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrease();
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }

    private void increase() {
        count++;
        txtItemCount.setText(String.valueOf(count));
    }

    private void decrease() {
        if (count >= 0) {
            count--;
            txtItemCount.setText(String.valueOf(count));
        }
    }

    private void addItem() {
        String itemName = txtItemName.getText().toString();
        if (itemName.trim().length() == 0 || count == 0)
            return;

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, itemName);
        contentValues.put(COLUMN_AMOUNT, count);
        database.insert(TABLE_NAME, null, contentValues);
        itemAdapter.swapCursor(getAllItems());
        txtItemName.getText().clear();

    }

    private Cursor getAllItems() {
        return database.query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                COLUMN_TIMESTAMP + " DESC");

    }

    private void removeItem(long id) {
        database.delete(TABLE_NAME,
                _ID + " = " + id, null);
        itemAdapter.swapCursor(getAllItems());

    }
}
