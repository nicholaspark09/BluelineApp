package com.apps.nicholaspark.bluelineapp.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by nicholaspark on 10/20/16.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationScope {
}
