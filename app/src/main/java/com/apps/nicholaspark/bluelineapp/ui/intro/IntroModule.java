package com.apps.nicholaspark.bluelineapp.ui.intro;

import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nicholaspark on 10/24/16.
 */

@Module public class IntroModule {

    @Provides @ApplicationScope IntroContract.View provideIntroView(){
        return new IntroController();
    }
}
