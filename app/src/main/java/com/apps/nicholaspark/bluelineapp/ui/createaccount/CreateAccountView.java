package com.apps.nicholaspark.bluelineapp.ui.createaccount;

import android.support.design.widget.TextInputEditText;

import com.apps.nicholaspark.bluelineapp.AppComponent;
import com.apps.nicholaspark.bluelineapp.R;
import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;
import com.apps.nicholaspark.bluelineapp.ui.base.BaseController;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by nicholaspark on 10/24/16.
 */

@ApplicationScope public class CreateAccountView extends BaseController implements CreateAccountContract.View{
    @BindView(R.id.accountIdEditText) TextInputEditText accountIdEditText;
    @Inject CreateAccountPresenter presenter;



    @Override
    protected int layoutId() {
        return R.layout.create_account_view;
    }

    @Override
    protected void inject(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    public String getId() {
        return accountIdEditText.getText().toString();
    }


    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showError(String error) {

    }
}
