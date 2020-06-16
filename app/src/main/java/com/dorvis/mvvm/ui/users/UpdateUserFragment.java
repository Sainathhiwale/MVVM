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
public class UpdateUserFragment extends Fragment {


    public UpdateUserFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new UpdateUserFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_user, container, false);
    }

}
