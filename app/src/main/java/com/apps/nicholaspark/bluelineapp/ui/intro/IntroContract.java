package com.apps.nicholaspark.bluelineapp.ui.intro;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by nicholaspark on 10/24/16.
 */

public interface IntroContract {

    interface View<Presenter>{
        void showLoginUi();
        void showCreateAccountUi();
    }

    interface Presenter{
        void openLogin();
        void openCreateAccount();
    }
}
