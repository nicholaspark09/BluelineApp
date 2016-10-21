package com.apps.nicholaspark.bluelineapp;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

/**
 * Created by nicholaspark on 10/20/16.
 */

public interface ActionBarProvider {
    ActionBar getSupportActionBar();
    void setActionBar(Toolbar toolbar);
}
