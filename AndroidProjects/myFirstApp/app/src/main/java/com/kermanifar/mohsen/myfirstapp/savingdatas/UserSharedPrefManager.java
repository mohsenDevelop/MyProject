package com.kermanifar.mohsen.myfirstapp.savingdatas;

import android.content.Context;
import android.content.SharedPreferences;

import com.kermanifar.mohsen.myfirstapp.datamodel.User;

public class UserSharedPrefManager {

    private SharedPreferences sharedPreferences;

    private static final String USER_SHARED_PREF_NAME = "user_shared_pref";

    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_JAVA_EXPERT = "java_expert";
    private static final String KEY_CSS_EXPERT = "css_expert";
    private static final String KEY_HTML_EXPERT = "html_expert";
    private static final String KEY_GENDER = "gender";


    public UserSharedPrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences(USER_SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveUser(User user) {
       SharedPreferences.Editor editor  =  sharedPreferences.edit();
       editor.putString(KEY_FIRST_NAME, user.getFirstName());
       editor.putString(KEY_LAST_NAME, user.getLastName());
       editor.putBoolean(KEY_JAVA_EXPERT, user.isJavaExpert());
       editor.putBoolean(KEY_CSS_EXPERT, user.isCssExpert());
       editor.putBoolean(KEY_HTML_EXPERT, user.isHtmlExpert());
       editor.putInt(KEY_GENDER, user.getGender());

       editor.apply();
    }

    public User getUser() {
        User user = new User();

        user.setFirstName(sharedPreferences.getString(KEY_FIRST_NAME, ""));
        user.setLastName(sharedPreferences.getString(KEY_LAST_NAME, ""));
        user.setJavaExpert(sharedPreferences.getBoolean(KEY_JAVA_EXPERT, false));
        user.setCssExpert(sharedPreferences.getBoolean(KEY_CSS_EXPERT, false));
        user.setHtmlExpert(sharedPreferences.getBoolean(KEY_HTML_EXPERT, false));
        user.setGender((byte) sharedPreferences.getInt(KEY_GENDER, User.MALE)) ;

        return user;
    }
}
