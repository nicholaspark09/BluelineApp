package com.apps.nicholaspark.bluelineapp.data;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.apps.nicholaspark.bluelineapp.preferences2.Preference;
import com.google.gson.Gson;

/**
 * Created by nicholaspark on 10/24/16.
 */

public class GsonPreferenceAdapter<T> implements Preference.Adapter<T> {
    private final Class<T> mClass;
    private final Gson gson;

    GsonPreferenceAdapter(Gson gson, Class<T> aClass){
        this.mClass = aClass;
        this.gson = gson;
    }

    @Override public T get(@NonNull String key, @NonNull SharedPreferences preferences) {
        return gson.fromJson(preferences.getString(key, ""), mClass);
    }

    @Override public void set(@NonNull String key, @NonNull T value, @NonNull SharedPreferences.Editor editor) {
        editor.putString(key, gson.toJson(value)).apply();
    }

}
