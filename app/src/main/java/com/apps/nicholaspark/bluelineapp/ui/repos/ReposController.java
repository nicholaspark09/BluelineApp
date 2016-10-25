package com.apps.nicholaspark.bluelineapp.ui.repos;


import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;

import com.apps.nicholaspark.bluelineapp.AppComponent;

import com.apps.nicholaspark.bluelineapp.R;
import com.apps.nicholaspark.bluelineapp.ui.base.BaseController;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;

/**
 * Created by nicholaspark on 10/22/16.
 */

public final class ReposController extends BaseController{

    @Inject ReposPresenter presenter;
    @BindView(R.id.swipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    private Disposable disposable;

    @Override
    protected int layoutId() { return R.layout.repos_index_view; }

    @Override
    protected void inject(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);
        presenter.start();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadRepos();
            }
        });
    }

    @Override
    protected void onDetach(@NonNull View view) {
        super.onDetach(view);
    }

    private void render(ReposViewModel viewModel){


    }
}
