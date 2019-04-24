package com.kermanifar.mohsen.myfirstapp.view.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.kermanifar.mohsen.myfirstapp.R;
import com.kermanifar.mohsen.myfirstapp.savingdatas.UserSharedPrefManager;
import com.kermanifar.mohsen.myfirstapp.datamodel.User;

public class ProfileActivity extends AppCompatActivity {

    private Button btnChangePhoto, btnSave;
    private EditText edtName, edtFamily;
    private CheckBox chkJava, chkCss, chkHtml;
    private RadioButton maleRadio, femaleRadio;
    private TextView txtInfo, txtExpert, txtGender;


     UserSharedPrefManager prefManager;
    private User user = new User();

    private Typeface irSansMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        prefManager = new UserSharedPrefManager(this);
        user = prefManager.getUser();

        setView();

        //Start set font
        irSansMobile = Typeface.createFromAsset(getAssets(), "fonts/IRANSansMobile.ttf");

        //End set font


        txtInfo.setTypeface(irSansMobile);
        txtExpert.setTypeface(irSansMobile);
        txtGender.setTypeface(irSansMobile);


        // Start change photo button event.
        btnChangePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this,"دکمه تغییر عکس کلیک شد . ", Toast.LENGTH_LONG).show();
            }
        });

        //End change photo button event .

        edtName.setText(user.getFirstName());
        edtFamily.setText(user.getLastName());

        //Start first name edit text event .

        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                user.setFirstName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //End first name edit text event

        //Start last name edit text event .
        edtFamily.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                user.setLastName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //End last name edit text event

        chkJava.setChecked(user.isJavaExpert());
        chkCss.setChecked(user.isCssExpert());
        chkHtml.setChecked(user.isHtmlExpert());

        //Start Java checkbox event .
        chkJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                user.setJavaExpert(isChecked);
            }
        });
        //End Java checkbox event .

        //Start Css checkbox event .
        chkCss.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                user.setCssExpert(isChecked);
            }
        });
        //End Css checkbox event .

        //Start Html checkbox event .
        chkHtml.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                user.setHtmlExpert(isChecked);
            }
        });
        //End Html checkbox event .

        byte gender = user.getGender();
        if (gender == User.MALE) {
            maleRadio.setChecked(true);
        }else {
            femaleRadio.setChecked(false);
        }

        //Start Radio Button event .
        maleRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    user.setGender(User.MALE);
                }else  {
                    user.setGender(User.FEMALE);
                }
            }
        });
        //End checkbox event .


        btnSave.setTypeface(irSansMobile);
        //Start Save Button event.
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefManager.saveUser(user);
                Toast.makeText(ProfileActivity.this, "تغییرات ذخیره شد .", Toast.LENGTH_SHORT).show();
            }
        });
        //End save Button event .

    }


    private void setView() {


        btnChangePhoto = findViewById(R.id.btn_change_photo);

         edtName = findViewById(R.id.edt_name);
         edtFamily = findViewById(R.id.edt_family);

         chkJava = findViewById(R.id.chk_java);
         chkCss = findViewById(R.id.chk_css);
         chkHtml = findViewById(R.id.chk_html);

         maleRadio = findViewById(R.id.rdo_male);
         femaleRadio = findViewById(R.id.rdo_female);

         btnSave = findViewById(R.id.btn_save_profile);

         txtInfo = findViewById(R.id.txt_info);
         txtExpert = findViewById(R.id.txt_expert);
         txtGender = findViewById(R.id.txt_gender);

         setUpToolbar();
    }

    public void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setTitle("اطلاعات کاربری");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            if (toolbar.getChildAt(i) instanceof TextView) {
                ((TextView) toolbar.getChildAt(i)).setTypeface(irSansMobile);
            }
        }

    }


}
