package com.apps.nicholaspark.bluelineapp.ui.repos;

import com.apps.nicholaspark.bluelineapp.data.models.Repo;
import com.apps.nicholaspark.bluelineapp.repository.LoadingState;
import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Created by nicholaspark on 10/22/16.
 */

@AutoValue abstract class ReposViewModel {

    static ReposViewModel create(LoadingState loadingState, List<Repo> repos, Repo repo){
        return new AutoValue_ReposViewModel(loadingState,repos,repo);
    }

    abstract LoadingState loadingState();

    abstract List<Repo> loadRepos();

    abstract Repo openRepo();

}
