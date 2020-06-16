package com.dorvis.mvvm.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dorvis.mvvm.R;
import com.dorvis.mvvm.data.model.users.UsersList;
import com.dorvis.mvvm.ui.users.allusers.AllUserViewModel;
import com.dorvis.mvvm.ui.users.allusers.GetAllUserFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyUserViewHolder> {

    private final List<UsersList> usersLists = new ArrayList<>();

    public UsersAdapter() {

    }

    @NonNull
    @Override
    public MyUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_all_list, parent, false);
        return new MyUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyUserViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (usersLists!=null)
            return usersLists.size();
        else
        return 0;
    }

    public class MyUserViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvUrsId)
        TextView tvUrsId;
        @BindView(R.id.tvUsrName)
        TextView tvUsrName;
        @BindView(R.id.tvUsrPswrd)
        TextView tvUsrPswrd;

        public MyUserViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

