package com.apps.nicholaspark.bluelineapp.ui.repos;

import com.apps.nicholaspark.bluelineapp.repository.GithubRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nicholaspark on 10/22/16.
 */

public class ReposPresenterTest {
    private ReposPresenter presenter;
    private static final String username = "nicholaspark09";
    @Mock GithubRepository repository;

    @Before
    public void setupReposPresenterTest(){
        MockitoAnnotations.initMocks(this);
        presenter = new ReposPresenter(repository);
    }

    @Test public void loadReposCalled_NoReposAvailable(){
        setReposNotAvailable();
        presenter.loadRepos();
        verify(repository).getRepos(presenter.username);
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
