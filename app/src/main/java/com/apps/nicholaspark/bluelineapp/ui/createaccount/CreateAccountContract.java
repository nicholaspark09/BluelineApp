package com.apps.nicholaspark.bluelineapp.ui.createaccount;

import com.apps.nicholaspark.bluelineapp.ui.base.BasePresenter;
import com.apps.nicholaspark.bluelineapp.ui.base.BaseView;

/**
 * Created by nicholaspark on 10/24/16.
 */

public interface CreateAccountContract {

    interface View extends BaseView<Presenter>{
        String getId();
        void setLoadingIndicator(boolean active);
        void showError(String error);
    }

    interface Presenter extends BasePresenter{
        void onAccountId();
        void createAccount(String email, String password);
    }
}
