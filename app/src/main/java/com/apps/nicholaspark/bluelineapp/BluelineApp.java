package com.apps.nicholaspark.bluelineapp;

import android.app.Application;
import android.os.StrictMode;

import com.apps.nicholaspark.bluelineapp.di.DaggerService;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

import timber.log.Timber;

import static android.os.StrictMode.setThreadPolicy;
import static android.os.StrictMode.setVmPolicy;

/**
 * Created by nicholaspark on 10/20/16.
 */

public class BluelineApp extends Application{

    @Inject Application application;
    private BluelineComponent appComponent;

    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG) {
            setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        }
        super.onCreate();
        if(LeakCanary.isInAnalyzerProcess(this))
            return;
        if(BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
        Timber.i("Initializing app");
        buildComponentAndInject();
    }

    @Override
    public Object getSystemService(String name) {
        if(name.equals(DaggerService.SERVICE_NAME) && appComponent != null)
            return appComponent;
        return super.getSystemService(name);
    }

    private void buildComponentAndInject(){
        appComponent = BluelineComponent.Initializer.init(this);
        appComponent.inject(this);
    }
}
