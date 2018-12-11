package com.mansourappdevelopment.androidapp.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ItemAdapter mItemAdapter;
    private ArrayList<Item> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        initializeData();
        initializeAdapter();

    }

    public void initializeData(){
        mItems = new ArrayList<>();
        mItems.add(new Item("20%", R.drawable.ic_battery_20));
        mItems.add(new Item("50%", R.drawable.ic_battery_50));
        mItems.add(new Item("80%", R.drawable.ic_battery_80));
        mItems.add(new Item("100%", R.drawable.ic_battery_full));

    }
    public void initializeAdapter(){
        mItemAdapter = new ItemAdapter(this, mItems);
        mRecyclerView.setAdapter(mItemAdapter);
    }
}
