package com.apps.nicholaspark.bluelineapp.di;

import android.content.Context;

import com.apps.nicholaspark.bluelineapp.BluelineComponent;

/**
 * Created by nicholaspark on 10/20/16.
 */

public final class DaggerService {
    public static final String SERVICE_NAME = DaggerService.class.getName();

    private DaggerService(){ throw new AssertionError("No instances");}

    public static BluelineComponent getAppComponent(Context context){
        return (BluelineComponent) context.getApplicationContext().getSystemService(SERVICE_NAME);
    }
}
