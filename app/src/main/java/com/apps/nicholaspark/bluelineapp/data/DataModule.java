package com.apps.nicholaspark.bluelineapp.data;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.apps.nicholaspark.bluelineapp.data.api.ApiModule;
import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;
import com.apps.nicholaspark.bluelineapp.preferences2.RxSharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;

import static com.jakewharton.byteunits.DecimalByteUnit.MEGABYTES;

/**
 * Created by nicholaspark on 10/20/16.
 */
@Module(includes = ApiModule.class)
public class DataModule {

    private static final String SHARED_PREFERENCES_LOCATION = "my.account.prefs";
    private static final int DISK_CACHE_SIZE = (int) MEGABYTES.toBytes(50);

    @Provides @ApplicationScope SharedPreferences provideSharedPreferences(Application application){
        return application.getSharedPreferences(SHARED_PREFERENCES_LOCATION, Context.MODE_PRIVATE);
    }

    @Provides @ApplicationScope RxSharedPreferences provideRxSharedPreferences(SharedPreferences pref){
        return RxSharedPreferences.create(pref);
    }



}
