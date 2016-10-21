package com.apps.nicholaspark.bluelineapp;

import com.apps.nicholaspark.bluelineapp.di.ApplicationScope;

import dagger.Component;

/**
 * Created by nicholaspark on 10/20/16.
 */
@ApplicationScope @Component(modules = BluelineAppModule.class)
public interface BluelineComponent extends AppComponent{

    final class Initializer{
        private Initializer(){
            throw new IllegalStateException("Can't have instances of a component");
        }
        static BluelineComponent init(BluelineApp app){
            return DaggerBluelineComponent.builder().bluelineAppModule(new BluelineAppModule(app)).build();
        }
    }
}
