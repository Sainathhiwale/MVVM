package com.dorvis.mvvm.ui.users;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dorvis.mvvm.R;
import com.dorvis.mvvm.ui.users.allusers.PageViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SingleUserFragment extends Fragment {
    private static final String TAG = "SingleUserFragment";
    PageViewModel pageViewModel;
    public SingleUserFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new SingleUserFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_user, container, false);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return view;
    }

}
