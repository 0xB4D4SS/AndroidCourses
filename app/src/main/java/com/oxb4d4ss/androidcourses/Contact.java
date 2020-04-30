package com.oxb4d4ss.androidcourses;

public class Contact {
    final private String name;
    final private String phoneNum;

    Contact(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName() { return this.name; }

    public String getPhoneNum() { return this.phoneNum; }
}
