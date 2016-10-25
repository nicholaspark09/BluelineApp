package com.apps.nicholaspark.bluelineapp.ui.createaccount;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nicholaspark on 10/24/16.
 */

public class CreateAccountPresenterTest {
    @Mock CreateAccountContract.View mView;
    private CreateAccountPresenter presenter;

    @Before
    public void setCreateAccountPresenterTest(){
        MockitoAnnotations.initMocks(this);
        presenter = new CreateAccountPresenter(mView);
    }

    @Test
    public void getIdAndCheckIfProperDigits_showErrorForIncorrectNumbers(){
        setIncorrectNumbers();
        presenter.onAccountId();
        verify(mView).showError("Please put in numbers only");
    }

    @Test
    public void getIdAndCheckIfProperDigits_showEmailAndPassword(){
        setProperNumbers();
        presenter.onAccountId();
    }

    private void setIncorrectNumbers(){
        when(mView.getId()).thenReturn("2930nsakasdfj");
    }

    private void setProperNumbers(){
        when(mView.getId()).thenReturn("2930292938125");
    }
}
