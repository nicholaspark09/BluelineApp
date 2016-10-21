package com.apps.nicholaspark.bluelineapp;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.apps.nicholaspark.bluelineapp.di.DaggerService;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    @Inject Application app;
    @BindView(R.id.changeFrameLayout) FrameLayout viewContainer;

    private Unbinder unbinder;
    private Router router;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerService.getAppComponent(this).inject(this);
        router = Conductor.attachRouter(this,viewContainer,savedInstanceState);

    }


    @Override
    public void onBackPressed() {
        if(!router.handleBack())
            super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
