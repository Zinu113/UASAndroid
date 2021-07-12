package com.julius.usersapi.services;

import com.julius.usersapi.model.GetUser;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/users")
    Call<GetUser> getUsersList();
}
