package com.oxb4d4ss.androidcourses;

import androidx.annotation.Nullable;

public class Contact {
    final private String name;
    final private String phoneNum;
    final private String phoneNum2;
    final private String email;
    final private String email2;
    final private String description;

    Contact(String name,
            String phoneNum,
            @Nullable String phoneNum2,
            @Nullable String email,
            @Nullable String email2,
            @Nullable String description) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.phoneNum2 = phoneNum2;
        this.email = email;
        this.email2 = email2;
        this.description = description;
    }


    public String getName() { return this.name; }

    public String getPhoneNum() { return this.phoneNum; }

    public String getPhoneNum2() { return this.phoneNum2; }

    public String getEmail() { return this.email; }

    public String getEmail2() { return this.email2; }

    public String getDescription() { return this.description; }
}
