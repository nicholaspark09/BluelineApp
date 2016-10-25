package com.apps.nicholaspark.bluelineapp.ui.createaccount;

import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nicholaspark on 10/24/16.
 */

@Module public class CreateAccountModule {

    @Provides @ApplicationScope CreateAccountContract.View provideView(){
        return new CreateAccountView();
    }
}
