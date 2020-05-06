package com.oxb4d4ss.androidcourses;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;

public class MainActivity extends AppCompatActivity {
    ContactsService myService;
    boolean mBound = false;

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, ContactsService.class);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            ContactListFragment contactListFragment = new ContactListFragment();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragmentLayout, contactListFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(conn);
            mBound = false;
        }
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ContactsService.ContactsBinder binder = (ContactsService.ContactsBinder) service;
            myService = binder.getService();
            mBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };

}
