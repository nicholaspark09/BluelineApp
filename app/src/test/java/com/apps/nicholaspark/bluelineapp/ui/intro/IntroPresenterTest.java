package com.apps.nicholaspark.bluelineapp.ui.intro;

import com.apps.nicholaspark.bluelineapp.preferences2.RxSharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by nicholaspark on 10/24/16.
 */

public class IntroPresenterTest {
    @Mock IntroController mView;
    private IntroPresenter presenter;

    @Before
    public void setupIntroPresenter(){
        MockitoAnnotations.initMocks(this);
        presenter = new IntroPresenter(mView);
    }

    @Test
    public void clickOnLogin_showLoginUi(){
        presenter.openLogin();
        verify(mView).showLoginUi();
    }

    @Test
    public void clickOnCreateAccount_showCreateAccountUi(){
        presenter.openCreateAccount();
        verify(mView).showCreateAccountUi();
    }
}
