package com.clemmahe.firebasemvpdagger.firebase;

import com.clemmahe.firebasemvpdagger.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * FirebaseComponent
 * Created by clem on 05/12/2016.
 */

@Singleton
@Component(modules = {FirebaseModule.class, ApplicationModule.class})
public interface FirebaseComponent {

    FirebaseManager getFirebaseManager();

}