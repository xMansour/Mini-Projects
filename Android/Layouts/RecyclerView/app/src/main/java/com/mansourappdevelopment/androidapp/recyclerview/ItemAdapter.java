package com.mansourappdevelopment.androidapp.recyclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterViewHolder> {
    private Context mContext;
    private ArrayList<Item> mItems;

    public ItemAdapter(Context mContext, ArrayList<Item> mItems) {
        this.mContext = mContext;
        this.mItems = mItems;

    }

    @NonNull
    @Override
    public ItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_item, parent, false);
        return new ItemAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterViewHolder holder, int position) {
        Item item = mItems.get(position);
        holder.mTextViewItem.setText(item.getmItemName());
        holder.mImageViewItem.setImageResource(item.getmItemImage());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ItemAdapterViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageViewItem;
        private TextView mTextViewItem;

        public ItemAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageViewItem = (ImageView) itemView.findViewById(R.id.imageViewItem);
            mTextViewItem = (TextView) itemView.findViewById(R.id.textViewItem);
        }
    }

}
