package com.oxb4d4ss.androidcourses;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class ContactListFragment extends ListFragment {

    static final Contact[] contacts = {
            new Contact("Ivanov Ivan", "+1234567890"),
            new Contact("Petrov Petr", "+9876543210")
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Contact List");

        ArrayAdapter<Contact> contactAdapter = new ArrayAdapter<Contact>(getActivity(), 0, contacts) {
            @SuppressLint("NewApi")
            @NonNull
            @Override
            public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.fragment_contactlist, null, false);
                }
                TextView contactName = (TextView) convertView.findViewById(R.id.contactName);
                TextView contactNum = (TextView) convertView.findViewById(R.id.contactNum);

                Contact currContact = contacts[i];
                contactName.setText(currContact.getName());
                contactNum.setText(currContact.getPhoneNum());

                return convertView;
            }
        };
        setListAdapter(contactAdapter);

    }
    @Override
    public void onListItemClick(@NonNull ListView listView, @Nullable View view, int i, long id) {
        ContactDetailsFragment detailsFragment = ContactDetailsFragment.newInstance(i);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.fragmentLayout, detailsFragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Contact List");

    }
}
