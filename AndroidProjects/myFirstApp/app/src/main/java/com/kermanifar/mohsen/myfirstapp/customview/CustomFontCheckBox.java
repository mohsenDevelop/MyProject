package com.kermanifar.mohsen.myfirstapp.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class CustomFontCheckBox extends CheckBox {
    public CustomFontCheckBox(Context context) {
        super(context);
        if (!isInEditMode()) {
            setFontCheckBox();
        }
    }

    public CustomFontCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            setFontCheckBox();
        }
    }

    public CustomFontCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            setFontCheckBox();
        }
    }

    public CustomFontCheckBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode()) {
            setFontCheckBox();
        }
    }
    public void setFontCheckBox() {
        MyApplication myApplication = (MyApplication)getContext().getApplicationContext();
        setTypeface(myApplication.getIranianFont());
    }
}
