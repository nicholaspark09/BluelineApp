package com.apps.nicholaspark.bluelineapp.ui.repos;

import android.support.annotation.NonNull;
import android.util.Pair;

import com.apps.nicholaspark.bluelineapp.data.models.Repo;
import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;
import com.apps.nicholaspark.bluelineapp.repository.GithubRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by nicholaspark on 10/22/16.
 */

@ApplicationScope final class ReposPresenter {

    private final GithubRepository repository;
    public static final String username = "nicholaspark09";

    @Inject ReposPresenter(GithubRepository repository){
        this.repository = repository;
    }

    Observable<ReposViewModel> viewModel(){
        return null;
    }

    public void loadRepos(){
        repository.getRepos(username);
    }

    public void openRepo(@NonNull Repo repo){

    }


}
