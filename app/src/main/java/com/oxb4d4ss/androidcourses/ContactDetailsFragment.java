package com.oxb4d4ss.androidcourses;

import android.app.Fragment;
import android.app.FragmentTransaction;
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
        detailedContactName.setText(ContactListFragment.contacts[i].getName());
        detailedContactPhoneNum.setText(ContactListFragment.contacts[i].getPhoneNum());
        return view;
    }

}
