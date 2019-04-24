package com.kermanifar.mohsen.myfirstapp.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class CustomFontEditText extends EditText {
    public CustomFontEditText(Context context) {
        super(context);

        if (!isInEditMode()) {
            setFontEditText();
        }
    }

    public CustomFontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            setFontEditText();
        }
    }

    public CustomFontEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (!isInEditMode()) {
            setFontEditText();
        }
    }

    public CustomFontEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        if (!isInEditMode()) {
            setFontEditText();
        }
    }

    public void setFontEditText() {
        MyApplication myApplication = (MyApplication)getContext().getApplicationContext();
        setTypeface(myApplication.getIranianFont());
    }
}
