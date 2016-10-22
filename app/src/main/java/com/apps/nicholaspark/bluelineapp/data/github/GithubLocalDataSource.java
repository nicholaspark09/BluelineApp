package com.apps.nicholaspark.bluelineapp.data.github;

import android.support.annotation.NonNull;


import com.apps.nicholaspark.bluelineapp.data.models.Repo;
import com.squareup.sqlbrite.BriteDatabase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by nicholaspark on 10/21/16.
 */

public class GithubLocalDataSource implements GithubDataSource{

    private BriteDatabase db;
    @Inject
    public GithubLocalDataSource(BriteDatabase db){
        this.db = db;
    }

    @Override
    public Observable<List<Repo>> getRepos(String username) {
        return null;
    }

    @Override
    public Observable<Repo> getRepo(@NonNull int repoId) {
        return null;
    }

    @Override
    public void saveRepo(@NonNull Repo repo) {

    }

    @Override
    public void deleteRepo(@NonNull int repoId) {

    }

    @Override
    public void deleteAllRepos() {

    }

    @Override
    public void refreshRepos() {

    }
}
