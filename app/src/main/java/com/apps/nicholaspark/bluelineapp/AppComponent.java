package com.apps.nicholaspark.bluelineapp;

import com.apps.nicholaspark.bluelineapp.ui.createaccount.CreateAccountView;
import com.apps.nicholaspark.bluelineapp.ui.intro.IntroController;
import com.apps.nicholaspark.bluelineapp.ui.repos.ReposController;

/**
 * Created by nicholaspark on 10/20/16.
 */

public interface AppComponent {
    void inject(BluelineApp app);
    void inject(MainActivity activity);
    void inject(ReposController reposController);
    void inject(IntroController introController);
    void inject(CreateAccountView view);
}
