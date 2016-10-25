package com.apps.nicholaspark.bluelineapp.ui.repos;

import android.support.annotation.NonNull;
import android.util.Pair;

import com.apps.nicholaspark.bluelineapp.data.models.Repo;
import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;
import com.apps.nicholaspark.bluelineapp.repository.GithubRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by nicholaspark on 10/22/16.
 */

@ApplicationScope final class ReposPresenter implements ReposContract.Presenter{

    private final GithubRepository repository;
    public static final String username = "nicholaspark09";
    private final Scheduler mainThread;

    @Inject ReposPresenter(GithubRepository repository, Scheduler mainThread){
        this.repository = repository;
        this.mainThread = mainThread;
    }

    Observable<ReposViewModel> viewModel(){
        return null;
    }

    public void loadRepos(){

    }

    public void openRepo(@NonNull Repo repo){

    }

//    ReposViewModel toViewModel(){
//        return ReposViewModel.create();
//    }

    @Override
    public void start() {
        loadRepos();
    }
}
