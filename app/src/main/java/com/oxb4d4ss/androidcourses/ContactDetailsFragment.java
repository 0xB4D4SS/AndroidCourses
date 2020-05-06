package com.oxb4d4ss.androidcourses;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ContactDetailsFragment extends Fragment {

    static ContactDetailsFragment newInstance(int index) {
        ContactDetailsFragment fragment = new ContactDetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Contact Details");
        View view = inflater.inflate(R.layout.fragment_detailslist, container, false);
        int i = this.getArguments().getInt("index");
        TextView detailedContactName = (TextView) view.findViewById(R.id.detailedContactName);
        TextView detailedContactPhoneNum = (TextView) view.findViewById(R.id.detailedContactPhoneNum);
        TextView detailedContactPhoneNum2 = (TextView) view.findViewById(R.id.detailedContactPhoneNum2);
        TextView detailedContactEmail = (TextView) view.findViewById(R.id.detailedContactEmail);
        TextView detailedContactEmail2 = (TextView) view.findViewById(R.id.detailedContactEmail2);
        TextView detailedContactDescription = (TextView) view.findViewById(R.id.detailedContactDescription);
        detailedContactName.setText(ContactsService.getDetailedContact(i).getName());
        detailedContactPhoneNum.setText(ContactsService.getDetailedContact(i).getPhoneNum());
        if (ContactsService.getDetailedContact(i).getPhoneNum2() != null) {
            detailedContactPhoneNum2.setText(ContactsService.getDetailedContact(i).getPhoneNum2());
        }
        if (ContactsService.getDetailedContact(i).getEmail() != null) {
            detailedContactEmail.setText(ContactsService.getDetailedContact(i).getEmail());
        }
        if (ContactsService.getDetailedContact(i).getEmail2() != null) {
            detailedContactEmail2.setText(ContactsService.getDetailedContact(i).getEmail2());
        }
        if (ContactsService.getDetailedContact(i).getDescription() != null) {
            detailedContactDescription.setText(ContactsService.getDetailedContact(i).getDescription());
        }
        return view;
    }

}
