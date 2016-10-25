package com.apps.nicholaspark.bluelineapp.data;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.apps.nicholaspark.bluelineapp.data.api.ApiModule;
import com.apps.nicholaspark.bluelineapp.data.db.DbHelper;
import com.apps.nicholaspark.bluelineapp.data.github.GithubApiService;
import com.apps.nicholaspark.bluelineapp.data.github.GithubDataSource;
import com.apps.nicholaspark.bluelineapp.data.github.GithubLocalDataSource;
import com.apps.nicholaspark.bluelineapp.data.github.GithubRemoteDataSource;
import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;
import com.apps.nicholaspark.bluelineapp.preferences2.RxSharedPreferences;
import com.apps.nicholaspark.bluelineapp.repository.GithubRepository;
import com.apps.nicholaspark.bluelineapp.ui.intro.IntroModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

import static com.jakewharton.byteunits.DecimalByteUnit.MEGABYTES;

/**
 * Created by nicholaspark on 10/20/16.
 */
@Module(includes = {ApiModule.class})
public class DataModule {
    private static final String SHARED_PREFERENCES_LOCATION = "my.account.prefs";
    private static final int DISK_CACHE_SIZE = (int) MEGABYTES.toBytes(50);
    private static final String DB_PASSWORD = "adlfjasdlfj";

//    @Provides @ApplicationScope Gson provideGson(){
//        return new GsonBui
//    }

    @Provides @ApplicationScope SharedPreferences provideSharedPreferences(Application application){
        return application.getSharedPreferences(SHARED_PREFERENCES_LOCATION, Context.MODE_PRIVATE);
    }

    @Provides @ApplicationScope RxSharedPreferences provideRxSharedPreferences(SharedPreferences pref){
        return RxSharedPreferences.create(pref);
    }

    @Provides @ApplicationScope GithubApiService provideGithubApiService(){
        return GithubApiService.Creator.makeGithubApiService();
    }

    @Provides @ApplicationScope DbHelper provideDbHelper(Application application){
        return new DbHelper(application);
    }

    @Provides @ApplicationScope SqlBrite provideSqlBrite(){
        return SqlBrite.create(m-> Timber.tag("Database").v(m));
    }

    @Provides @ApplicationScope BriteDatabase provideBriteDatabase(Application application, SqlBrite sqlBrite,DbHelper dbHelper){
        BriteDatabase db = sqlBrite.wrapDatabaseHelper(application,dbHelper,DB_PASSWORD, Schedulers.io());
        db.setLoggingEnabled(true);
        return db;
    }

    @Provides @ApplicationScope @Named("localDataSource") GithubDataSource provideGithubLocalDataSource(BriteDatabase briteDatabase){
        return new GithubLocalDataSource(briteDatabase);
    }

    @Provides @ApplicationScope @Named("remoteDataSource") GithubDataSource provideGithubRemoteDataSource(GithubApiService apiService){
        return new GithubRemoteDataSource(apiService);
    }

    @Provides @ApplicationScope GithubRepository provideGithubRepository(@Named("localDataSource") GithubDataSource localSource, @Named("remoteDataSource") GithubDataSource remoteSource){
        return new GithubRepository(localSource,remoteSource);
    }

    @Provides @ApplicationScope Scheduler providesMainThread(){
        return AndroidSchedulers.mainThread();
    }
}
