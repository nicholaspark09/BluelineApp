package com.apps.nicholaspark.bluelineapp.ui.repos;

import com.apps.nicholaspark.bluelineapp.repository.GithubRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nicholaspark on 10/22/16.
 */

public class ReposPresenterTest {
    private ReposPresenter presenter;
    private static final String username = "nicholaspark09";
    @Mock GithubRepository repository;
    @Mock Scheduler scheduler;

    @Before
    public void setupReposPresenterTest(){
        MockitoAnnotations.initMocks(this);
        presenter = new ReposPresenter(repository,scheduler);
    }

    @Test public void loadReposCalled_NoReposAvailable(){
        setReposNotAvailable();
        presenter.loadRepos();
        verify(repository).getRepos(presenter.username);
        assertThat(repository.mCachedRepositories.size(),is(0));
    }

    //TODO Please finish the test case
    @Test public void loadReposCalled_ReposAvailable(){

    }

    private void setReposNotAvailable(){
        when(repository.getRepos(username)).thenReturn(Observable.just(Collections.emptyList()));
    }

    private void setReposAvailable(){

    }


}
