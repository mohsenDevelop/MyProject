package com.kermanifar.mohsen.myfirstapp.datamodel;

public class User {

    private String firstName = "";
    private String lastName = "";
    private boolean isJavaExpert = false;
    private boolean isCssExpert = false;
    private boolean isHtmlExpert = false;

    public static final byte MALE = 0;
    public static final byte FEMALE = 1;

    private byte gender = MALE;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isJavaExpert() {
        return isJavaExpert;
    }

    public void setJavaExpert(boolean javaExpert) {
        isJavaExpert = javaExpert;
    }

    public boolean isCssExpert() {
        return isCssExpert;
    }

    public void setCssExpert(boolean cssExpert) {
        isCssExpert = cssExpert;
    }

    public boolean isHtmlExpert() {
        return isHtmlExpert;
    }

    public void setHtmlExpert(boolean htmlExpert) {
        isHtmlExpert = htmlExpert;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }
}
