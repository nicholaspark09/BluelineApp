package com.apps.nicholaspark.bluelineapp.data.github;

import com.apps.nicholaspark.bluelineapp.data.models.Repo;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by nicholaspark on 10/21/16.
 */

public interface GithubApiService {
    String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);

    class Creator{
        public static GithubApiService makeGithubApiService(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit.create(GithubApiService.class);
        }
    }
}
