package com.mansourappdevelopment.androidapp.recyclerview;

public class Item {
    private String mItemName;
    private int mItemImage;

    public Item(String mItemName, int mItemImage) {
        this.mItemName = mItemName;
        this.mItemImage = mItemImage;
    }

    public String getmItemName() {
        return this.mItemName;
    }

    public int getmItemImage() {
        return this.mItemImage;
    }
}
