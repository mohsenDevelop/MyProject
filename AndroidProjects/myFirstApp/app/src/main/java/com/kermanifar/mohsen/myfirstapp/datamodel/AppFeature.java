package com.kermanifar.mohsen.myfirstapp.datamodel;

import android.support.annotation.DrawableRes;

public class AppFeature {

    public static final int ID_POST_ACTIVITY = 0;
    public static final int ID_USER_POFILE = 1;
    public static final int ID_FATION = 2;
    public static final int ID_MUSIC = 3;
    public static final int ID_VIDEO = 4;
    public static final int ID_LOG_IN = 5;

    private int id;
    private String caption;
    @DrawableRes
    private int imageFeature;
    private Class destinationActivity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getImageFeature() {
        return imageFeature;
    }

    public void setImageFeature(int imageFeature) {
        this.imageFeature = imageFeature;
    }

    public Class getDestinationActivity() {
        return destinationActivity;
    }

    public void setDestinationActivity(Class destinationActivity) {
        this.destinationActivity = destinationActivity;
    }
}
