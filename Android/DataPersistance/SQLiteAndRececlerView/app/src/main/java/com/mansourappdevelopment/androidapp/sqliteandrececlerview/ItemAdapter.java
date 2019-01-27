package com.mansourappdevelopment.androidapp.sqliteandrececlerview;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.provider.BaseColumns._ID;
import static com.mansourappdevelopment.androidapp.sqliteandrececlerview.ItemContract.ItemEntry.COLUMN_AMOUNT;
import static com.mansourappdevelopment.androidapp.sqliteandrececlerview.ItemContract.ItemEntry.COLUMN_NAME;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private Context context;
    private Cursor cursor;

    public ItemAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView txtItemName;
        private TextView txtItemCount;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            txtItemCount = (TextView) itemView.findViewById(R.id.txtCount);
            txtItemName = (TextView) itemView.findViewById(R.id.txtName);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        if (!cursor.moveToPosition(i))
            return;

        String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
        int count = cursor.getInt(cursor.getColumnIndex(COLUMN_AMOUNT));
        long id = cursor.getLong(cursor.getColumnIndex(_ID));
        Log.i("itemInfo", name);
        Log.i("itemInfo", String.valueOf(count));

        itemViewHolder.txtItemName.setText(name);
        itemViewHolder.txtItemCount.setText(String.valueOf(count));
        itemViewHolder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public void swapCursor(Cursor cursor) {
        if (this.cursor != null)
            this.cursor.close();

        this.cursor = cursor;

        if (cursor != null)
            notifyDataSetChanged();

    }
}
