package com.apps.nicholaspark.bluelineapp.ui;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.nicholaspark.bluelineapp.AppComponent;
import com.apps.nicholaspark.bluelineapp.di.DaggerService;
import com.bluelinelabs.conductor.Controller;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by nicholaspark on 10/20/16.
 */

public abstract class BaseController extends Controller{
    private Unbinder unbinder;
    private boolean injected;

    protected void onViewBound(View view){}

    @LayoutRes protected abstract int layoutId();

    protected abstract void inject(AppComponent component);

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        if(!injected)
        {
            inject(DaggerService.getAppComponent(container.getContext()));
            injected = true;
        }
        View view = inflater.inflate(layoutId(),container,false);
        unbinder = ButterKnife.bind(this,view);
        onViewBound(view);
        return view;
    }

    @Override
    protected void onDestroyView(View view) {
        unbinder.unbind();
    }

    @Nullable protected ActionBar getActionBar(){
        return ((AppCompatActivity)getActivity()).getSupportActionBar();
    }

    @Nullable protected void setActionBar(Toolbar toolbar){
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
    }
}
