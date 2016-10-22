package com.apps.nicholaspark.bluelineapp.repository;

/**
 * Created by nicholaspark on 10/22/16.
 */

public enum LoadingState {
    IDLE,
    LOADING,
    ERROR;

    public boolean isLoading(){
        return this == LOADING;
    }

    public boolean isIdle(){
        return this == IDLE;
    }

    public boolean isError(){
        return this == ERROR;
    }
}
