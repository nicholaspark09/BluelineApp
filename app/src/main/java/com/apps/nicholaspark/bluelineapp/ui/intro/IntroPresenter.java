package com.apps.nicholaspark.bluelineapp.ui.intro;

import com.apps.nicholaspark.bluelineapp.AppComponent;
import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;
import com.apps.nicholaspark.bluelineapp.preferences2.Preference;
import com.apps.nicholaspark.bluelineapp.preferences2.RxSharedPreferences;
import com.apps.nicholaspark.bluelineapp.util.Transformers;


import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import timber.log.Timber;

import static com.apps.nicholaspark.bluelineapp.util.Transformers.distinctToMainThread;

/**
 * Created by nicholaspark on 10/23/16.
 */

@ApplicationScope public class IntroPresenter implements IntroContract.Presenter{

    IntroContract.View mView;
    
    @Inject
    IntroPresenter(IntroContract.View view){
        mView = view;
    }

    @Override
    public void openLogin() {
        mView.showLoginUi();
    }

    @Override
    public void openCreateAccount() {
        mView.showCreateAccountUi();
    }
}
