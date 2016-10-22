package com.apps.nicholaspark.bluelineapp.data.github;

import android.support.annotation.NonNull;

import com.apps.nicholaspark.bluelineapp.data.models.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by nicholaspark on 10/21/16.
 */

public class GithubRemoteDataSource implements GithubDataSource{
    private final GithubApiService apiService;

    @Inject
    public GithubRemoteDataSource(GithubApiService apiService){
        this.apiService = apiService;
    }


    @Override
    public Observable<List<Repo>> getRepos(String username) {
        return apiService.listRepos(username);
    }

    @Override
    public Observable<Repo> getRepo(@NonNull int repoId) {
        return null;
    }

    @Override
    public void saveRepo(@NonNull Repo repo) {
        //The Repo will save it
    }

    @Override
    public void deleteRepo(@NonNull int repoId) {
        //The Repo will delete
    }

    @Override
    public void deleteAllRepos() {
        //The Repo will delete all of them
    }

    @Override
    public void refreshRepos() {
        //The Repo will refresh it
    }
}
