package com.kermanifar.mohsen.myfirstapp.customview;

import android.app.Application;
import android.graphics.Typeface;

public class MyApplication extends Application {
    private static Typeface iranSansFont;
    @Override
    public void onCreate() {
        super.onCreate();
        iranSansFont = Typeface.createFromAsset(getAssets(), "fonts/IRANSansMobile_Medium.ttf");
    }
    public Typeface getIranianFont() {
        return iranSansFont;
    }
}
