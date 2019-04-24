package com.kermanifar.mohsen.myfirstapp.datamodel;

import android.graphics.drawable.Drawable;

public class Cloth {

    private int id;
    private Drawable imageItem;
    private String txtTile;
    private int viewCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Drawable getImageItem() {
        return imageItem;
    }

    public void setImageItem(Drawable imageItem) {
        this.imageItem = imageItem;
    }

    public String getTxtTile() {
        return txtTile;
    }

    public void setTxtTile(String txtTile) {
        this.txtTile = txtTile;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
