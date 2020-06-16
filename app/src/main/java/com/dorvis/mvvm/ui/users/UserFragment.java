package com.dorvis.mvvm.ui.users;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dorvis.mvvm.R;
import com.dorvis.mvvm.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {


    @BindView(R.id.tab_layout_user)
    TabLayout tabLayoutUser;
    @BindView(R.id.viewpager_user)
    ViewPager viewpagerUser;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        initView();
        return view;
    }

    private void initView() {
        setupPager(viewpagerUser);
    }

    private void setupPager(ViewPager viewpagerUser) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new DeleteUserFragment(),"Delete User");
        viewPagerAdapter.addFragment(new SingleUserFragment(),"Single User");
        viewPagerAdapter.addFragment(new UpdateUserFragment(),"Update User");
        viewpagerUser.setAdapter(viewPagerAdapter);
    }

}
