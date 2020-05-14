package com.oxb4d4ss.androidcourses;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContactDetailsFragment extends Fragment {
    private ContactsService service;
    private TextView detailedContactName;
    private TextView detailedContactPhoneNum;
    private TextView detailedContactPhoneNum2;
    private TextView detailedContactEmail;
    private TextView detailedContactEmail2;
    private TextView detailedContactBday;
    private TextView detailedContactDescription;

    static ContactDetailsFragment newInstance(int index) {
        ContactDetailsFragment fragment = new ContactDetailsFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(@NonNull Context ctx) {
        super.onAttach(ctx);
        if (ctx instanceof ServiceInterface) {
            this.service = ((ServiceInterface) ctx).getService();
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Contact Details");
        View view = inflater.inflate(R.layout.fragment_detailslist, container, false);
        int i = this.getArguments().getInt("index");
        detailedContactName = view.findViewById(R.id.detailedContactName);
        detailedContactPhoneNum = view.findViewById(R.id.detailedContactPhoneNum);
        detailedContactPhoneNum2 = view.findViewById(R.id.detailedContactPhoneNum2);
        detailedContactEmail = view.findViewById(R.id.detailedContactEmail);
        detailedContactEmail2 = view.findViewById(R.id.detailedContactEmail2);
        detailedContactBday = view.findViewById(R.id.detailedContactBday);
        detailedContactDescription = view.findViewById(R.id.detailedContactDescription);
        service.getContact(callback, i);
        return view;
    }

    public interface ResultListener {
        void onComplete(Contact result);
    }

    private ContactDetailsFragment.ResultListener callback = new ContactDetailsFragment.ResultListener() {
        @Override
        public void onComplete(Contact result) {
            final Contact contact = result;
            if (detailedContactName != null) {
                detailedContactName.post(new Runnable() {
                    @Override
                    public void run() {
                        if (detailedContactName != null
                                && detailedContactPhoneNum != null
                                && detailedContactPhoneNum2 != null
                                && detailedContactEmail != null
                                && detailedContactEmail2 != null
                                && detailedContactBday != null
                                && detailedContactDescription != null) {
                            detailedContactName.setText(contact.getName());
                            detailedContactPhoneNum.setText(contact.getPhoneNum());
                            detailedContactPhoneNum.setText(contact.getPhoneNum2());
                            detailedContactEmail.setText(contact.getEmail());
                            detailedContactEmail2.setText(contact.getEmail2());
                            detailedContactBday.setText(contact.getBirthday());
                            detailedContactDescription.setText(contact.getDescription());
                        }
                    }
                });
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        detailedContactName = null;
        detailedContactPhoneNum = null;
        detailedContactPhoneNum2 = null;
        detailedContactEmail = null;
        detailedContactEmail2 = null;
        detailedContactBday = null;
        detailedContactDescription = null;
    }

}
