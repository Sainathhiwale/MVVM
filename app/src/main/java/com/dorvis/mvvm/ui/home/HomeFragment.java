package com.dorvis.mvvm.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dorvis.mvvm.R;
import com.dorvis.mvvm.base.BaseFragment;
import com.dorvis.mvvm.data.model.User;
import com.dorvis.mvvm.ui.users.UserFragment;
import com.dorvis.mvvm.ui.users.allusers.GetAllUserFragment;
import com.dorvis.mvvm.utils.ViewModelFactory;


import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {
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
    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @OnClick({R.id.llUser, R.id.llBook, R.id.llAuthers, R.id.llActivities, R.id.llCoverPhto})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llUser:
              /*  UserFragment fragment = new UserFragment();
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;*/
            case R.id.llBook:

                Toast.makeText(getActivity(), "book", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llAuthers:
                Toast.makeText(getActivity(), "authers", Toast.LENGTH_SHORT).show();

                break;
            case R.id.llActivities:
                Toast.makeText(getActivity(), "activities", Toast.LENGTH_SHORT).show();

                break;
            case R.id.llCoverPhto:
                Toast.makeText(getActivity(), "photo", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}