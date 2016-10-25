package com.apps.nicholaspark.bluelineapp;

import android.app.Application;

import com.apps.nicholaspark.bluelineapp.data.DataModule;
import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;
import com.apps.nicholaspark.bluelineapp.ui.createaccount.CreateAccountModule;
import com.apps.nicholaspark.bluelineapp.ui.intro.IntroModule;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nicholaspark on 10/20/16.
 */

@Module(includes = {DataModule.class, IntroModule.class, CreateAccountModule.class})
final class BluelineAppModule {

    private final BluelineApp app;

    BluelineAppModule(BluelineApp app){
        this.app = app;
    }

    @Provides @ApplicationScope Application provideApp(){
        return app;
    }
}
