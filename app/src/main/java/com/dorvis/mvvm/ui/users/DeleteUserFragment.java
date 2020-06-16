package com.dorvis.mvvm.ui.users;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dorvis.mvvm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUserFragment extends Fragment {


    public DeleteUserFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new DeleteUserFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        return view;
    }

}
