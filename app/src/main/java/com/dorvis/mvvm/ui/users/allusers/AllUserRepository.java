package com.dorvis.mvvm.ui.users.allusers;

import com.dorvis.mvvm.data.model.users.UsersList;
import com.dorvis.mvvm.data.network.RepoService;

import javax.inject.Inject;

import io.reactivex.Single;

public class AllUserRepository {
    private final RepoService repoService;
    @Inject
    public AllUserRepository(RepoService repoService) {
        this.repoService = repoService;
    }

    public Single<UsersList>getUserLists(){
        return repoService.getUsersList();
    }
}
