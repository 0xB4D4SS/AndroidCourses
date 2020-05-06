package com.oxb4d4ss.androidcourses;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;


public class ContactsService extends Service {

    private final IBinder contactsBinder = new ContactsBinder();

    static final Contact[] contacts = {
            new Contact("Ivanov Ivan", "+1234567890", null, null , null, null),
            new Contact("Petrov Petr", "+9876543210", null, "p.petrov@gmail.com" , null, null)
    };

    @Override
    public IBinder onBind(Intent intent) {
        return contactsBinder;
    }

    static public Contact[] getContacts() {
        return contacts;
    }

    static public Contact getDetailedContact(int id) {
        return contacts[id];
    }

    public class ContactsBinder extends Binder {
        ContactsService getService() {
            return ContactsService.this;
        }
    }
}
