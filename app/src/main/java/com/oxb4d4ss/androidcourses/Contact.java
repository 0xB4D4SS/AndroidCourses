package com.oxb4d4ss.androidcourses;

import androidx.annotation.Nullable;

public class Contact {
    final private String name;
    final private String phoneNum;
    final private String phoneNum2;
    final private String email;
    final private String email2;
    final private String birthday;
    final private String description;
    final private int image;

    static final Contact[] contacts = {
            new Contact("Ivanov Ivan", "+1234567890", null, null , null, "10.05", null, R.mipmap.ic_launcher),
            new Contact("Petrov Petr", "+9876543210", null, "p.petrov@gmail.com" , null, null, null, R.mipmap.ic_launcher)
    };

    Contact(String name,
            String phoneNum,
            @Nullable String phoneNum2,
            @Nullable String email,
            @Nullable String email2,
            @Nullable String birthday,
            @Nullable String description,
            int image) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.phoneNum2 = phoneNum2;
        this.email = email;
        this.email2 = email2;
        this.birthday = birthday;
        this.description = description;
        this.image = image;
    }


    public String getName() { return this.name; }

    public String getPhoneNum() { return this.phoneNum; }

    public String getPhoneNum2() { return this.phoneNum2; }

    public String getEmail() { return this.email; }

    public String getEmail2() { return this.email2; }

    public String getBirthday() { return this.birthday; }

    public String getDescription() { return this.description; }

    public int getImage() { return this.image; }
}
