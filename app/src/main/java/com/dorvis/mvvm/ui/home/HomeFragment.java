package com.dorvis.mvvm.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dorvis.mvvm.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    @BindView(R.id.tvUserList)
    TextView tvUserList;
    @BindView(R.id.llUser)
    LinearLayout llUser;
    @BindView(R.id.tvBook)
    TextView tvBook;
    @BindView(R.id.llBook)
    LinearLayout llBook;
    @BindView(R.id.tvAuthers)
    TextView tvAuthers;
    @BindView(R.id.llAuthers)
    LinearLayout llAuthers;
    @BindView(R.id.tvActivities)
    TextView tvActivities;
    @BindView(R.id.llActivities)
    LinearLayout llActivities;
    @BindView(R.id.tvCoverPhto)
    TextView tvCoverPhto;
    @BindView(R.id.llCoverPhto)
    LinearLayout llCoverPhto;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    @OnClick({R.id.llUser, R.id.llBook, R.id.llAuthers, R.id.llActivities, R.id.llCoverPhto})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llUser:
                break;
            case R.id.llBook:
                break;
            case R.id.llAuthers:
                break;
            case R.id.llActivities:
                break;
            case R.id.llCoverPhto:
                break;
        }
    }
}