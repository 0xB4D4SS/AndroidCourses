package com.oxb4d4ss.androidcourses;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.widget.ArrayAdapter;

import java.lang.ref.WeakReference;


public class ContactsService extends Service {

    private final IBinder contactsBinder = new ContactsBinder();

    class ContactsBinder extends Binder {
        ContactsService getService() {
            return ContactsService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return contactsBinder;
    }

    public void getContacts(ContactListFragment.ResultListener callback) {
        final WeakReference<ContactListFragment.ResultListener> ref = new WeakReference(callback);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Contact[] result = Contact.contacts;
                ContactListFragment.ResultListener local = ref.get();
                if (local != null) {
                    local.onComplete(result);
                }
            }
        }).start();
    }

    public void getContact(ContactDetailsFragment.ResultListener callback, final int id) {
        final WeakReference<ContactDetailsFragment.ResultListener> ref = new WeakReference(callback);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Contact result = Contact.contacts[id];
                ContactDetailsFragment.ResultListener local = ref.get();
                if (local != null) {
                    local.onComplete(result);
                }
            }
        }).start();
    }

}
