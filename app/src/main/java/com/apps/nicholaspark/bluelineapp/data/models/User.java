package com.apps.nicholaspark.bluelineapp.data.models;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import static com.apps.nicholaspark.bluelineapp.util.Strings.isBlank;

/**
 * Created by nicholaspark on 10/20/16.
 */

@AutoValue public abstract class User {

    public static User create(String name, String email, String password){
        boolean isAuthed = !isBlank(name) && !isBlank(email) && !isBlank(password);
        return new AutoValue_User(name,email,password,isAuthed);
    }

    public abstract String name();
    public abstract String email();
    public abstract String password();
    public abstract boolean isAuthed();
}
