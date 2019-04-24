package com.kermanifar.mohsen.myfirstapp.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class CustomFontButton extends Button {
    public CustomFontButton(Context context) {
        super(context);

        if (!isInEditMode()) {
            setFontButton();
        }
    }

    public CustomFontButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            setFontButton();
        }
    }

    public CustomFontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode()) {
            setFontButton();
        }
    }

    public CustomFontButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        if (!isInEditMode()) {
            setFontButton();
        }
    }

    public void setFontButton() {
        MyApplication myApplication = (MyApplication) getContext().getApplicationContext();
        setTypeface(myApplication.getIranianFont());
    }
}
