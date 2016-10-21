package com.apps.nicholaspark.bluelineapp.data.api;

import com.apps.nicholaspark.bluelineapp.data.models.User;

import io.reactivex.Single;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by nicholaspark on 10/20/16.
 */

public interface UserApi {
    @POST("/login") Single<User> login(@Query("email") String email, @Query("password") String password);
}
