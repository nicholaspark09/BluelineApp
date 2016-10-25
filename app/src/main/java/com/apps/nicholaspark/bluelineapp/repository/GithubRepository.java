package com.apps.nicholaspark.bluelineapp.repository;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.apps.nicholaspark.bluelineapp.data.github.GithubDataSource;
import com.apps.nicholaspark.bluelineapp.data.models.Repo;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by nicholaspark on 10/21/16.
 */

public class GithubRepository implements GithubDataSource {
    private final GithubDataSource localDataSource;
    private final GithubDataSource remoteDataSource;
    CompositeDisposable compositeDisposable;
    @VisibleForTesting
    public Map<Integer,Repo> mCachedRepositories;
    @VisibleForTesting
    boolean mCacheIsDirty = false;

    @Inject public GithubRepository(@Named("localDataSource") GithubDataSource localDataSource, @Named("remoteDataSource") GithubDataSource remoteDataSource){
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Repo>> getRepos(String username) {
        if(mCachedRepositories != null && !mCacheIsDirty){
            return null;
        }
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
