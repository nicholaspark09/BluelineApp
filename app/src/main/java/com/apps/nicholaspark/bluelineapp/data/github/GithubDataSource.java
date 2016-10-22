package com.apps.nicholaspark.bluelineapp.data.github;

import android.support.annotation.NonNull;


import com.apps.nicholaspark.bluelineapp.data.models.Repo;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by nicholaspark on 10/21/16.
 */

public interface GithubDataSource {
    Observable<List<Repo>> getRepos(String username);
    Observable<Repo> getRepo(@NonNull int repoId);
    void saveRepo(@NonNull Repo repo);
    void deleteRepo(@NonNull int repoId);
    void deleteAllRepos();
    void refreshRepos();
}
