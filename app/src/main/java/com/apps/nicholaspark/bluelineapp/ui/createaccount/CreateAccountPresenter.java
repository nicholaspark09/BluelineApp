package com.apps.nicholaspark.bluelineapp.ui.createaccount;

import javax.inject.Inject;

/**
 * Created by nicholaspark on 10/24/16.
 */

public class CreateAccountPresenter implements CreateAccountContract.Presenter{
    CreateAccountContract.View mView;

    @Inject
    CreateAccountPresenter(CreateAccountContract.View view){
        mView = view;
    }


    @Override
    public void onAccountId() {
        String accountId = mView.getId();
        String reg = "\\d{13}";
        if(accountId.matches(reg)){

        }else{
            mView.showError("Please put in numbers only");
        }
    }

    @Override
    public void createAccount(String email, String password) {

    }


    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
