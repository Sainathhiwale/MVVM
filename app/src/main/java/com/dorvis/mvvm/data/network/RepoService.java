package com.dorvis.mvvm.data.network;

import com.dorvis.mvvm.data.model.User;
import com.dorvis.mvvm.data.model.users.UsersList;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RepoService {
    @Headers("Content-Type: application/json")
    @POST("api/Users")
    Single<User>registerUser(@Body User user);

    //get all user list
    @GET("api/Users")
    Single<UsersList>getUsersList();


}
