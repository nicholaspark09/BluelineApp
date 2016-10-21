package com.apps.nicholaspark.bluelineapp;

import com.apps.nicholaspark.bluelineapp.data.DataModule;
import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nicholaspark on 10/20/16.
 */

@Module(includes = DataModule.class)
final class BluelineAppModule {

    private final BluelineApp app;

    BluelineAppModule(BluelineApp app){
        this.app = app;
    }

    @Provides @ApplicationScope BluelineApp provideApp(){
        return app;
    }
}
