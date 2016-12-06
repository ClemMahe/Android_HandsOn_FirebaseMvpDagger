package com.clemmahe.firebasemvpdagger.firebase;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * FirebaseModule
 * Created by clem on 05/12/2016.
 */
@Module
public class FirebaseModule {

    @Singleton
    @Provides
    FirebaseManager provideManager(Context context) {
        return new FirebaseManager(context);
    }

}
