package com.dorvis.mvvm.ui.users.allusers;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dorvis.mvvm.R;
import com.dorvis.mvvm.adapter.UsersAdapter;
import com.dorvis.mvvm.base.BaseFragment;
import com.dorvis.mvvm.utils.ViewModelFactory;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GetAllUserFragment extends BaseFragment {
    private static final String TAG = "GetAllUserFragment";
    @BindView(R.id.rvUsers)
    RecyclerView rvUsers;
    @BindView(R.id.tv_error)
    TextView tvError;
    @BindView(R.id.loading_view)
    ProgressBar loadingView;

    @Inject
    ViewModelFactory viewModelFactory;

    public AllUserViewModel allUserViewModel;

    public GetAllUserFragment() {
        // Required empty public constructor
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_get_all_user;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        rvUsers.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

    }


}
