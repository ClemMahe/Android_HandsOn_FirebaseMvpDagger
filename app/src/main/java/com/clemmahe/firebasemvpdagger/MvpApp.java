package com.clemmahe.firebasemvpdagger;

import android.app.Application;

import com.clemmahe.firebasemvpdagger.firebase.DaggerFirebaseComponent;
import com.clemmahe.firebasemvpdagger.firebase.FirebaseComponent;


/**
 * MvpApp
 * Created by clem on 05/12/2016.
 */

public class MvpApp extends Application {

    private FirebaseComponent mFirebaseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //Firebase component
        mFirebaseComponent = DaggerFirebaseComponent.builder()
                .applicationModule(new ApplicationModule((getApplicationContext())))
                .build();
    }

    /**
     * Get Firebase component
     * @return FirebaseComponent
     */
    public FirebaseComponent getFirebaseComponent() {
        return mFirebaseComponent;
    }

}