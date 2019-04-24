package com.kermanifar.mohsen.myfirstapp.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class CustomFontRadioButton extends RadioButton {
    public CustomFontRadioButton(Context context) {
        super(context);

        if (!isInEditMode()) {
            setFontRadioButton();
        }
    }

    public CustomFontRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            setFontRadioButton();
        }
    }

    public CustomFontRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode()) {
            setFontRadioButton();
        }
    }

    public CustomFontRadioButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        if (!isInEditMode()) {
            setFontRadioButton();
        }
    }
    public void setFontRadioButton() {
        MyApplication myApplication = (MyApplication)getContext().getApplicationContext();
        setTypeface(myApplication.getIranianFont());
    }
}
